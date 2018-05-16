package com.epam.task04.entity.node;

import java.util.List;

public class OpenTag implements Node{
	private String name;
	private List<Attribute> attributes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(this.getClass() != o.getClass())
			return false;
		OpenTag newObj = (OpenTag)o;
		if (!this.getName().equals(newObj.getName()))
				return false;
		if (this.getAttributes().size() != newObj.getAttributes().size() || !this.getAttributes().containsAll(newObj.getAttributes()))
			return false;
		return true;
	}
	
	@Override
	public int hashCode(){
		int result = 17;
		
		result = 37 * result + this.getName().hashCode();
		result = 37 * result + this.getAttributes().hashCode();
		
		return result;
	}
	
	@Override
	public java.lang.String toString() {
		if(attributes == null) {
			return "OpenTag: " +
					"name = '" + name + '\'';
		} else return "OpenTag: " +
						"name = '" + name + '\'' +
						", attributes = " + attributes;		
	}
}
