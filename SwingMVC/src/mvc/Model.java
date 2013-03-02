package mvc;

import java.beans.PropertyChangeSupport;

public class Model extends AbstractModel {

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
	firePropertyChange(ModelController.ELEMENT_NUMBER_PROPERTY, oldNumber,
		getNumber());
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	String oldName = getName();
	this.name = name;
	firePropertyChange(ModelController.ELEMENT_NAME_PROPERTY, oldName, getName());
    }

    public void initDefaults() {
	setNumber(99);
	setName("Developement Phase");
    }

}
