package com.yscxsss.order.entity;

import java.util.Date;

public class Order {

	private int orderId;
	private Date odate;
	private int status;
	private int paySet;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getOdate() {
		return odate;
	}
	public void setOdate(Date odate) {
		this.odate = odate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPaySet() {
		return paySet;
	}
	public void setPaySet(int paySet) {
		this.paySet = paySet;
	}
	
	
	
	
}
