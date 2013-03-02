package mvc.controller;

import mvc.model.control.ModelControl;

public class ModelController extends AbstractController implements ModelControl {

    @Override
    public void setNumber(Integer newNumber) {
	setModelProperty(ELEMENT_NUMBER_PROPERTY, newNumber);
    }

    @Override
    public void setName(String newName) {
	setModelProperty(ELEMENT_NAME_PROPERTY, newName);
    }

}