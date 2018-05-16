package com.epam.task04.dao.impl;

import java.io.File;

import com.epam.task04.dao.XmlDAO;
import com.epam.task04.dao.xml.XmlLineParser;
import com.epam.task04.dao.xml.XmlReader;
import com.epam.task04.entity.node.Node;

public class XmlDAOImpl implements XmlDAO{
	XmlReader reader = new XmlReader();
	
	public XmlDAOImpl() {}
	
	public XmlDAOImpl(File file) {
		this.reader = new XmlReader(file);
	}
	
	public Node getNextNode(){
			
			Node node = null;
			
			XmlLineParser parser = new XmlLineParser(reader.readLine().toString());
			parser.setNode();
			node = parser.getNode();
			
			return node;
		}
	
	public boolean hasNext() {
		if(!reader.isEOF()) {
			return true;
		} else return false;
		
	}
	
	public void setReader(File file) {
		this.reader = new XmlReader(file);
	}
	
	public void closeReader() {
		reader.close();
	}
}
