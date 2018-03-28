package com.yscxsss.order.entity;

import com.yscxsss.user.entity.User;

import java.util.Date;
import java.util.List;

public class Order {

	private User user;
	//TODO 如果用户有多个寄件地址，是否要定义成数组
	private String address;
	private List<SalesItem> items;
	
	private int orderId;
	//TODO 对应字段odate,是否考虑重新建一个数据库及表
	private Date orderDate;
	private int status;
	private int paySet;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<SalesItem> getItems() {
		return items;
	}
	public void setItems(List<SalesItem> items) {
		this.items = items;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	
}
