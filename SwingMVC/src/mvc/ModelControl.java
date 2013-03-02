package mvc;

public interface ModelControl {

    public static final String ELEMENT_NUMBER_PROPERTY = "Number";
    public static final String ELEMENT_NAME_PROPERTY = "Name";

    public void setNumber(int newNumber);

    public void setName(String newName);
}
