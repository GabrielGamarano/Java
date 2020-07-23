package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.NovoEstoqueDao;
import model.entidades.Estoque;
import model.entidades.PedidoEstoque;

public class NovoEstoqueDaoJDBC implements NovoEstoqueDao {

	private Connection conn;

	public NovoEstoqueDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(PedidoEstoque obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO compraEstoque (ProdName, ProdCompany, ProdQnt, ProdPrice, ProdBuyDate, ProdExpDate, EstoqueId) "
							+ "VALUES " + "(?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setOrderId(id);
				}
			} else {
				throw new DbException("ERRO INESPERADO! LINHA VAZIA");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}

	}

	@Override
	public void update(PedidoEstoque obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public PedidoEstoque findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidoEstoque> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM department ORDER BY Name");
			rs = st.executeQuery();

			List<PedidoEstoque> list = new ArrayList<>();

			while (rs.next()) {
				PedidoEstoque obj = new PedidoEstoque();
				obj.setOrderId(rs.getInt(""));
				obj.setOrderQnt(rs.getInt(""));
				obj.setOrderPrice(rs.getDouble(""));
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
}
