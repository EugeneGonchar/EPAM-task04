package com.epam.task04.entity.node;

public class Content implements Node{
	String text;

	public String getText() {
		return text;
	}

	public void setContent(String text) {
		this.text = text;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		Content newObj = (Content)o;
		if (this.getText().equals(newObj.getText()))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		
		result = 37 * result + this.getText().hashCode();
		
		return result;
	}
	
	@Override
	public java.lang.String toString() {
		return "Content: " +
				"text = '" + text + '\'';
	}
}
