package models;

/**
 * @author qfdk kevin
 *
 * @param <T>
 */
public interface Observer<T> {
	
	/**
	 * update
	 * @param subject subject
	 */
	public void update(T subject);
}
