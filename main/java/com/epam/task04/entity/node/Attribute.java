package com.epam.task04.entity.node;

public class Attribute implements Node{
	private String name;
	private String value;

	public Attribute() {}
	
	public Attribute(String name, String value) {
		setName(name);
		setValue(value);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		Attribute newObj = (Attribute)o;
		if (this.getName().equals(newObj.getName()))
			return false;
		if (this.getValue().equals(newObj.getValue()))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		
		result = 37 * result + this.getName().hashCode();
		result = 37 * result + this.getValue().hashCode();
		
		return result;
	}
	
	@Override
	public java.lang.String toString() {
		return "Attribute: " +
				"name = '" + name + '\'' +
				", value = '" + value + '\'';
	}
}
