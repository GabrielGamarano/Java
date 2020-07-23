package model.dao;

import java.util.List;

import model.entidades.PedidoEstoque;

public interface NovoEstoqueDao {
	
	void insert(PedidoEstoque obj);
	void update(PedidoEstoque obj);
	void deleteById(Integer id);
	PedidoEstoque findById(Integer id);
	List<PedidoEstoque> findAll();

}
