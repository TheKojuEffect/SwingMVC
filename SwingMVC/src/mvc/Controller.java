package mvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class Controller implements PropertyChangeListener {

    
    public static final String ELEMENT_NUMBER_PROPERTY = "Number";
    public static final String ELEMENT_NAME_PROPERTY = "Name";
    
    private ArrayList<View> registeredViews;
    private ArrayList<Model> registeredModels;

    public Controller() {
	registeredViews = new ArrayList<View>();
	registeredModels = new ArrayList<Model>();
    }

    public void addModel(Model model) {
	registeredModels.add(model);
	model.addPropertyChangeListener(this);
    }

    public void removeModel(Model model) {
	registeredModels.remove(model);
	model.removePropertyChangeListener(this);
    }

    public void addView(View view) {
	registeredViews.add(view);
    }

    public void removeView(View view) {
	registeredViews.remove(view);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
	for (View view : registeredViews) {
	    view.modelPropertyChange(evt);
	}
    }
    
    public void changeName(String name) {
	
    }
}
