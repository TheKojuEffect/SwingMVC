package mvc.service;

import mvc.model.AbstractModel;
import mvc.model.Model;

public class ModelServiceImpl implements ModelService {
    private Model model;

    @Override
    public AbstractModel getModel() {
	return model;
    }

}
