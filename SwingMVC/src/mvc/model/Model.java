package mvc.model;

import mvc.model.control.ModelControl;

public class Model extends AbstractModel implements ModelControl {

    private Integer number;
    private String name;

    public Model() {
	super();
    }

    public Integer getNumber() {
	return number;
    }

    @Override
    public void setNumber(Integer number) {
	Integer oldNumber = getNumber();
	this.number = number;
	firePropertyChange(ModelControl.ELEMENT_NUMBER_PROPERTY, oldNumber,
		getNumber());
    }

    public String getName() {
	return name;
    }

    @Override
    public void setName(String name) {
	String oldName = getName();
	this.name = name;
	firePropertyChange(ModelControl.ELEMENT_NAME_PROPERTY, oldName,
		getName());
    }

    @Override
    public String toString() {
	return new String("Number: " + getNumber() + "\nName: " + getName());
    }

    public void initDefaults() {
	setNumber(99);
	System.out.println(getNumber());
	setName("Test Model");
	System.out.println(getName());
    }

}
