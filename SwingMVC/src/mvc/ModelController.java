package mvc;

public class ModelController extends AbstractController implements ModelControl {

    @Override
    public void setNumber(int newNumber) {
	setModelProperty(ELEMENT_NUMBER_PROPERTY, newNumber);
    }

    @Override
    public void setName(String newName) {
	setModelProperty(ELEMENT_NAME_PROPERTY, newName);
    }

}