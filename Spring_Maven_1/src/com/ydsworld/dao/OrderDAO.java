package com.ydsworld.dao;

import java.util.List;

import com.ydsworld.model.Order;

public interface OrderDAO {
	public void save(Order p);
    public List<Order> list();
}
