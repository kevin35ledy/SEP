package models;

public interface Observer<T> {

	public void update(T subject);
}
