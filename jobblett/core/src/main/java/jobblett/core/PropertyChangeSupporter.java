package jobblett.core;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class PropertyChangeSupporter {
  protected PropertyChangeSupport pcs = new PropertyChangeSupport(this);

  /**
   * Adds a listener.
   *
   * @param pcl the listener
   */
  public void addListener(PropertyChangeListener pcl) {
    Collection<PropertyChangeListener> listeners =
        Arrays.stream(pcs.getPropertyChangeListeners()).collect(Collectors.toList());
    if (!listeners.contains(pcl)) {
      pcs.addPropertyChangeListener(pcl);
    }
  }

  protected void removeListener(PropertyChangeListener pcl) {
    pcs.removePropertyChangeListener(pcl);
  }

  protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
    pcs.firePropertyChange(propertyName, oldValue, newValue);
  }

  protected void firePropertyChange(String propertyName, Object newValue) {
    firePropertyChange(propertyName, null, newValue);
  }

}
