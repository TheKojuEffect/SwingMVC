package mvc.service;

import mvc.model.AbstractModel;
import mvc.model.Model;

public class ModelServiceImpl implements ModelService {
    private Model model;

    @Override
    public AbstractModel getModel() {
	return model;
    }

    @Override
    public void setNumber(Integer newNumber) {
	model.setNumber(newNumber);
    }

    @Override
    public void setName(String newName) {
	model.setName(newName);
    }

    @Override
    public Model createModel(Model model) {
	this.model = model;
	return model;
    }

}
