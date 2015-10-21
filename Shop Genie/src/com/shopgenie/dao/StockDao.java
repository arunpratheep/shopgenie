package com.shopgenie.dao;

import com.shopgenie.entities.Stock;

public class StockDao extends GenericDao<Stock, Integer> {

	public StockDao(Class<Stock> entity) {
		super(entity);
	}
	public StockDao()
	{
		super(Stock.class);
	}
}
