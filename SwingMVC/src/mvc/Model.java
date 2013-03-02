package mvc;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Model extends AbstractModel {

    private PropertyChangeSupport propertyChangeSupport;
    private int number;
    private String name;

    public Model() {
	propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public int getNumber() {
	return number;
    }

    public void setNumber(int number) {
	int oldNumber = getNumber();
	this.number = number;
	firePropertyChange(Controller.ELEMENT_NUMBER_PROPERTY, oldNumber,
		getNumber());
    }

    public String getName() {
	return name;
    }

    @Override
    protected void firePropertyChange(String propertyName, Object oldValue,
	    Object newValue) {
	propertyChangeSupport.firePropertyChange(propertyName, oldValue,
		newValue);
    }

    public void setName(String name) {
	String oldName = getName();
	this.name = name;
	firePropertyChange(Controller.ELEMENT_NAME_PROPERTY, oldName, getName());
    }

    public void initDefaults() {
	setNumber(99);
	setName("Developement Phase");
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
	propertyChangeSupport.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
	propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
