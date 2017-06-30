package dev.jpp.listapi.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dev.jpp.listapi.entity.ListType;
import dev.jpp.listapi.model.ListTypeModel;

@Component("listTypeConverter")
public class ListTypeConverter implements IConverter<ListType, ListTypeModel> {

	@Override
	public ListType modelToEntity(ListTypeModel model) {
		return new ListType(model.getId(), model.getCode(), model.getDescription());
	}

	@Override
	public List<ListType> listModelToListEntity(List<ListTypeModel> models) {
		List<ListType> entities = new ArrayList<>();
		
		for (ListTypeModel model : models) {
			entities.add(this.modelToEntity(model));
		}
		
		return entities;
	}

	@Override
	public ListTypeModel entityToModel(ListType entity) {
		return new ListTypeModel(entity.getId(), entity.getCode(), entity.getDescription());
	}

	@Override
	public List<ListTypeModel> listEntityToListModel(List<ListType> entities) {
		List<ListTypeModel> models = new ArrayList<>();
		
		for (ListType entity : entities) {
			models.add(this.entityToModel(entity));
		}
		
		return models;
	}

}
