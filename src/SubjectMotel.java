/**
 * Subject.java
 *
 * Objects implementing this interface allow observers
 * to register with it. When this object changes state,
 * it notifies all registered observers.
 */
public interface SubjectMotel {

	/**
	 *  allows an observer to register with the subject */
	public void addObserver(ObserverColony o);

	/**
	 *  removes an observer */
	public void removeObserver(ObserverColony o);

	/**
	 *  notifes all registered observers when its state changes */
	public void notifyObservers();
}
