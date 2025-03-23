package fr.matheo_pedron.action;

public interface Action<T> {
	T run();

	String description();
}
