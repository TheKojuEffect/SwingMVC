package mvc;

import java.lang.reflect.Method;

public class ModelController extends AbstractController implements ModelControl {

    @Override
    public void setName(String name) {
	try {
	    Method method = getModel().getClass().getMethod("setName",
		    new Class[] { name.getClass() });

	    method.invoke(getModel(), name);

	} catch (Exception e) {
	    System.err.println("Method invocation error");
	    e.printStackTrace();
	}
    }

    @Override
    public void setNumber(int number) {
	// TODO Auto-generated method stub

    }

}
