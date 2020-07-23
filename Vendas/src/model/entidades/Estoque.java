package model.entidades;

import java.io.Serializable;

public class Estoque implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private Integer prodId;
	private String prodName;
	private String prodCompany;
	
	public Estoque() {
		
	}
	
	

	public Estoque(Integer prodId, String prodName, String prodCompany) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodCompany = prodCompany;
	}



	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdCompany() {
		return prodCompany;
	}

	public void setProdCompany(String prodCompany) {
		this.prodCompany = prodCompany;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prodId == null) ? 0 : prodId.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estoque other = (Estoque) obj;
		if (prodId == null) {
			if (other.prodId != null)
				return false;
		} else if (!prodId.equals(other.prodId))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Estoque [prodId=" + prodId + ", prodName=" + prodName + ", prodCompany=" + prodCompany + "]";
	}
	
	
	
}
