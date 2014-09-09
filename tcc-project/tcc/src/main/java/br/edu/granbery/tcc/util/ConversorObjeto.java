package br.edu.granbery.tcc.util;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.granbery.model.BaseEntity;

@FacesConverter("conversorObjeto")
public class ConversorObjeto implements Converter {

	public Object getAsObject(FacesContext arg0, UIComponent component,	String value) {
		if (value != null) {
			return this.getAttributesFrom(component).get(value);
		}
		return null;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !"".equals(value)) {

			BaseEntity entity = (BaseEntity) value;

			this.addAttribute(component, entity);

			Integer codigo = entity.getId();
			if (codigo != null) {
				return String.valueOf(codigo);
			}
		}

		return (String) value;

	}

	protected void addAttribute(UIComponent component, BaseEntity o) {
		String key = String.valueOf(o.getId());
		this.getAttributesFrom(component).put(key, o);
	}

	protected Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}

}
