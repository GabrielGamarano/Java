package model.entidades;

import java.io.Serializable;
import java.util.Date;

public class PedidoEstoque implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer orderId;
	private Integer orderQnt;
	private Double orderPrice;
	private Date orderBuyDate;
	private Date orderExpireDate;
	
	private Estoque estoque;
	
	public PedidoEstoque() {
		
	}

	public PedidoEstoque(Integer orderId, Integer orderQnt, Double orderPrice, Date orderBuyDate, Date orderExpireDate,
			Estoque estoque) {
		super();
		this.orderId = orderId;
		this.orderQnt = orderQnt;
		this.orderPrice = orderPrice;
		this.orderBuyDate = orderBuyDate;
		this.orderExpireDate = orderExpireDate;
		this.estoque = estoque;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderQnt() {
		return orderQnt;
	}

	public void setOrderQnt(Integer orderQnt) {
		this.orderQnt = orderQnt;
	}

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Date getOrderBuyDate() {
		return orderBuyDate;
	}

	public void setOrderBuyDate(Date orderBuyDate) {
		this.orderBuyDate = orderBuyDate;
	}

	public Date getOrderExpireDate() {
		return orderExpireDate;
	}

	public void setOrderExpireDate(Date orderExpireDate) {
		this.orderExpireDate = orderExpireDate;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
		PedidoEstoque other = (PedidoEstoque) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PedidoEstoque [orderId=" + orderId + ", orderQnt=" + orderQnt + ", orderPrice=" + orderPrice
				+ ", orderBuyDate=" + orderBuyDate + ", orderExpireDate=" + orderExpireDate + ", estoque=" + estoque
				+ "]";
	}
	
	

}
