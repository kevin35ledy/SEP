package models;

/**
 * @author qfdk
 *
 */
public interface Subject {
	/**
	 * @param o Observer
	 */
	public void attach(Observer<?> o);
	/**
	 * @param o Observer
	 */
	public void detach(Observer<?> o);
}
