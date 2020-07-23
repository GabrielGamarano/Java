package model.service;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.NovoEstoqueDao;
import model.entidades.PedidoEstoque;

public class NovoEstoqueService {

private NovoEstoqueDao dao = DaoFactory.createNovoEstoqueDao();
	
	public List<PedidoEstoque> findAll(){
		return dao.findAll();
	}
	
	public void saveOrUpdate(PedidoEstoque obj) {
		if (obj.getOrderId() == null) {
			dao.insert(obj);
		}else {
			dao.update(obj);
		}
	}
}
