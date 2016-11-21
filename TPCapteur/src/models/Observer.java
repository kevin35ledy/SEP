package models;

import java.util.concurrent.Future;

public interface Observer<T> {

	public Future<?> update(T s);
}
