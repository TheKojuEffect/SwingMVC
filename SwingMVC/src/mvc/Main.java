package mvc;

public class Main {
    public static void main(String[] args) throws InterruptedException {
	Model model = new Model();
	ModelController modelController = new ModelController();
	View view = new View();

	modelController.addModel(model);
	modelController.addView(view);
	view.setVisible(true);

	Thread.sleep(2000);

	model.initDefaults();

	System.out.println(model);

    }
}
