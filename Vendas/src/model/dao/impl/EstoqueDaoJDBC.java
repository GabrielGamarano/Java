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
import model.dao.EstoqueDao;
import model.entidades.Estoque;


public class EstoqueDaoJDBC implements EstoqueDao{

	private Connection conn;
	
	public EstoqueDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Estoque obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO estoque (ProdName, ProdCompany) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getProdName());
			st.setString(2, obj.getProdCompany());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setProdId(id);
				}
			}else {
				throw new DbException("ERRO INESPERADO! LINHA VAZIA");
			}
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Estoque obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Estoque findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estoque> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM department ORDER BY Name");
			rs = st.executeQuery();

			List<Estoque> list = new ArrayList<>();

			while (rs.next()) {
				Estoque obj = new Estoque();
				obj.setProdId(rs.getInt("EstoqueId"));
				obj.setProdName(rs.getString("ProdName"));
				obj.setProdCompany(rs.getString("ProdCompany"));
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
