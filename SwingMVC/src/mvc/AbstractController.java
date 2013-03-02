package mvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public abstract class AbstractController implements PropertyChangeListener {

    protected ArrayList<ModelEvenSink> registeredViews;
    protected AbstractModel model;

    public AbstractModel getModel() {
        return model;
    }

    public void setModel(AbstractModel model) {
        this.model = model;
    }

    public AbstractController() {
	registeredViews = new ArrayList<ModelEvenSink>();
    }

    public void addView(ModelEvenSink view) {
	registeredViews.add(view);
    }

    public void removeView(ModelEvenSink view) {
	registeredViews.remove(view);
    }

    // Use this to observe property changes from registered models
    // and propagate them on to all the views.

    @Override
    public void propertyChange(PropertyChangeEvent event) {

	for (ModelEvenSink view : registeredViews) {
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

    }

}