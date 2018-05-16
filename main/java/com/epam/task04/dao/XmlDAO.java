package com.epam.task04.dao;

import java.io.File;

import com.epam.task04.entity.node.Node;

public interface XmlDAO {
	
	public Node getNextNode();
	
	public boolean hasNext();
	
	public void setReader(File file);
	
	public void closeReader();
}
