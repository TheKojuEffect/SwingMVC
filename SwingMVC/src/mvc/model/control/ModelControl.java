package mvc.model.control;

public interface ModelControl {

    public static final String ELEMENT_NUMBER_PROPERTY = "Number";
    public static final String ELEMENT_NAME_PROPERTY = "Name";

    public void setNumber(Integer newNumber);

    public void setName(String newName);

}
