package dev.jpp.listapi.service;

import java.util.List;

public interface ISimpleCrudService<T> {
	public abstract T add(T model);
	public abstract T update(T model);
	public abstract void remove(Long id);
	public abstract List<T> findAll();
	public abstract T findById(Long id);
}
