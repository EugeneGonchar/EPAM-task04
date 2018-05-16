package com.epam.task04.dao;

import com.epam.task04.dao.impl.XmlDAOImpl;

public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	private XmlDAO XmlDAO;
	
	private DAOFactory() {}
	
	public static DAOFactory getInstance() {
		return instance;
	}

	public XmlDAO getXmlDAO() {
		return new XmlDAOImpl();
	}
}
