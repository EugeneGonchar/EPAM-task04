package com.epam.task04.main;

import java.io.File;

import com.epam.task04.dao.DAOFactory;
import com.epam.task04.dao.XmlDAO;
import com.epam.task04.entity.node.Node;

public class Main 
{
	public static final File NOTES_XML = new File("src\\main\\resources", "notes.xml");
	public static final File BREAKFAST_MENU_XML = new File("src\\main\\resources", "breakfastMenu.xml");
	
    public static void main( String[] args )
    {
    	
    	DAOFactory factory = DAOFactory.getInstance();
    	XmlDAO xmlDAO = factory.getXmlDAO();
    	xmlDAO.setReader(BREAKFAST_MENU_XML);
    	Node node = null;
    	while(xmlDAO.hasNext()) {
    		node = xmlDAO.getNextNode();
    		if(xmlDAO.hasNext())
    			System.out.println(node.toString());
    	}
    	xmlDAO.closeReader();
    	
    	System.out.println("--------------------");
    	
    	xmlDAO.setReader(NOTES_XML);
    	while(xmlDAO.hasNext()) {
    		node = xmlDAO.getNextNode();
    		if(xmlDAO.hasNext())
    			System.out.println(node.toString());
    	}
    	xmlDAO.closeReader();
    	
    }
    
}
