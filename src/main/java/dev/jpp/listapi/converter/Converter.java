package dev.jpp.listapi.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

public class Converter<E, M> {
	private Class<?> entityClass;
	private Class<?> modelClass;
	private ModelMapper mapper;
	
	public Converter(Class<E> entityClass, Class<M> modelClass) {
		super();
		this.entityClass = entityClass;
		this.modelClass = modelClass;
		this.mapper = new ModelMapper();
	}
	
	@SuppressWarnings("unchecked")
	public M entityToModel(E entity) {
		return (M) mapper.map(entity, modelClass);
	}
	
	@SuppressWarnings("unchecked")
	public E modelToEntity(M model) {
		return (E) mapper.map(model, entityClass);
	}
	
	public List<M> listEntityToListModel(List<E> entities) {
		List<M> models = new ArrayList<>();
		
		for (E entity : entities) {
			models.add(entityToModel(entity));
		}
		
		return models;
	}
	
	public List<E> listModelToListEntity(List<M> models) {
		List<E> entities = new ArrayList<>();
		
		for (M model : models) {
			entities.add(modelToEntity(model));
		}
		
		return entities;
	}
}
