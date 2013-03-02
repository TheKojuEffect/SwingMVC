package mvc.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

import mvc.model.AbstractModel;
import mvc.view.interfaces.ModelEventSink;

public abstract class AbstractController implements PropertyChangeListener {

    protected ArrayList<ModelEventSink> registeredViews;
    protected ArrayList<AbstractModel> registeredModels;


    public AbstractController() {
	registeredViews = new ArrayList<ModelEventSink>();
	registeredModels = new ArrayList<AbstractModel>();
    }

    public void addModel(AbstractModel model) {
	registeredModels.add(model);
	model.addPropertyChangeListener(this);
    }

    public void removeModel(AbstractModel model) {
	registeredModels.remove(model);
	model.removePropertyChangeListener(this);
    }

    public void removeAllModels() {
	for (AbstractModel model : registeredModels) {
	    model.removePropertyChangeListener(this);
	}
	registeredModels.clear();
    }

    public ArrayList<AbstractModel> getRegisteredModels() {
	return registeredModels;
    }
    
    public void addView(ModelEventSink view) {
	registeredViews.add(view);
	view.setController(this);
    }

    public void removeView(ModelEventSink view) {
	registeredViews.remove(view);
    }

    public void removeAllViews() {
	registeredViews.clear();
    }

    // Use this to observe property changes from model
    // and propagate them on to all the views.

    @Override
    public void propertyChange(PropertyChangeEvent event) {

	for (ModelEventSink view : registeredViews) {
	    view.modelPropertyChange(event);
	}
    }

    /**
     * This is a convenience method that subclasses can call upon
     * to fire property changes back to the models. This method
     * uses reflection to inspect each of the model classes
     * to determine whether it is the owner of the property
     * in question. If it isn't, a NoSuchMethodException is thrown,
     * which the method ignores.
     * 
     * @param propertyName
     *            = The name of the property.
     * @param newValue
     *            = An object that represents the new value
     *            of the property.
     */
    protected void setModelProperty(String propertyName, Object newValue) {
	for (AbstractModel model : registeredModels) {
	    try {

		Method method = model.getClass().getMethod(
			"set" + propertyName,
			new Class[] { newValue.getClass() }

		);
		method.invoke(model, newValue);

	    } catch (Exception ex) {
		System.err.println("From setModelProperty");
		ex.printStackTrace();
	    }
	}
    }
}