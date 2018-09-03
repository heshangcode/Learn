package com.hs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository //<bean id =bookDaoImpl >
public class BookDaoImpl implements BookDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int getBookPriceByIsbn(String isbn) {
		String sql = "select price from tx_book where isbn=?";
		int price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		return price;
	}

	@Override
	public void updateUserBalance(String account, int price) {
		String sql = "update tx_user set balance = balance-? where account = ?";
		jdbcTemplate.update(sql, price, account);
	}

	@Override
	public void updateBookStock(String isbn) {
		String sql = "update tx_book_stock set stock = stock-1 where isbn = ?";
		jdbcTemplate.update(sql, isbn);
	}

	@Override
	public int getUserBalanceByAccount(String account) {
		String sql = "select balance from tx_user where account=?";
		int balance = jdbcTemplate.queryForObject(sql, Integer.class, account);
		return balance;
	}

	@Override
	public int getBookStockByIsbn(String isbn) {
		String sql = "select stock from tx_book_stock where isbn=?";
		int stock = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		return stock;
	}
}
