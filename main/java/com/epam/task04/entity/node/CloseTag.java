package com.epam.task04.entity.node;

public class CloseTag implements Node{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		CloseTag newObj = (CloseTag)o;
		if (this.getName().equals(newObj.getName()))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		
		result = 37 * result + this.getName().hashCode();
		
		return result;
	}
	
	@Override
	public java.lang.String toString() {
		return "CloseTag: " +
				"name = '" + name + '\'';
	}
}
