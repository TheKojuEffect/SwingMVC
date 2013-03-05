package mvc.service;

import mvc.model.AbstractModel;
import mvc.model.Model;
import mvc.model.control.ModelControl;

public interface ModelService extends ModelControl {
    public AbstractModel getModel();

    public Model createModel(Model model);
}
