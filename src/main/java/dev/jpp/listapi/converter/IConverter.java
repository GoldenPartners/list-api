package dev.jpp.listapi.converter;

import java.util.List;

public interface IConverter<E,M> {
	
	public abstract E modelToEntity(M model);
	public abstract List<E> listModelToListEntity(List<M> models);
	public abstract M entityToModel(E entity);
	public abstract List<M> listEntityToListModel(List<E> entities);
	
}
