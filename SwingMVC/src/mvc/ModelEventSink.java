package mvc;

import java.beans.PropertyChangeEvent;

public interface ModelEventSink {
    public void modelPropertyChange(PropertyChangeEvent event);
}
