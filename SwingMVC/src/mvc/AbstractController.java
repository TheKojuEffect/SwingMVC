package mvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class AbstractController implements PropertyChangeListener {

    protected ArrayList<ModelEventSink> registeredViews;
    protected AbstractModel model;

    public AbstractModel getModel() {
	return model;
    }

    public void setModel(AbstractModel model) {
	this.model = model;
    }

    public AbstractController() {
	registeredViews = new ArrayList<ModelEventSink>();
    }

    public void addView(ModelEventSink view) {
	registeredViews.add(view);
    }

    public void removeView(ModelEventSink view) {
	registeredViews.remove(view);
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
	try {

	    Method method = model.getClass().getMethod("set" + propertyName,
		    new Class[] { newValue.getClass() }

	    );
	    method.invoke(model, newValue);

	} catch (Exception ex) {
	    System.out.println("From setModelProperty");
	    ex.printStackTrace();
	}
    }

}