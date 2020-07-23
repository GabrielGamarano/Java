package model.service;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.EstoqueDao;
import model.entidades.Estoque;

public class EstoqueService {

	private EstoqueDao dao = DaoFactory.createEstoqueDao();
	
	public List<Estoque> findAll(){
		return dao.findAll();
	}
	
	public void saveOrUpdate(Estoque obj) {
		if (obj.getProdId() == null) {
			dao.insert(obj);
		}else {
			dao.update(obj);
		}
	}
}
