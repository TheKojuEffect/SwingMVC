package mvc;

import mvc.controller.ModelController;
import mvc.model.Model;
import mvc.service.ModelService;
import mvc.service.ModelServiceImpl;
import mvc.view.View;

public class Main {
    public static void main(String[] args) throws InterruptedException {
	Model model = new Model();
	ModelController modelController = new ModelController();
	View view = new View();

	ModelService modelService = new ModelServiceImpl();
	modelService.createModel(model);
	modelController.addService(modelService);
	modelController.addView(view);
	view.setVisible(true);

	Thread.sleep(2000);

	model.initDefaults();

	System.out.println(model);

    }
}
