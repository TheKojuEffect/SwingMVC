package mvc.view.interfaces;

import java.beans.PropertyChangeEvent;

import mvc.controller.AbstractController;

public interface ModelEventSink {
    public void modelPropertyChange(PropertyChangeEvent event);

    public void setController(AbstractController controller);
}
