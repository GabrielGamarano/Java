package model.dao;

import db.DB;
import model.dao.impl.EstoqueDaoJDBC;
import model.dao.impl.NovoEstoqueDaoJDBC;

public class DaoFactory {
	
	public static EstoqueDao createEstoqueDao() {
		return new EstoqueDaoJDBC(DB.getConnection());
	}
	
	public static NovoEstoqueDao createNovoEstoqueDao() {
		return new NovoEstoqueDaoJDBC(DB.getConnection());
	}

}
