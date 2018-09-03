package com.hs.dao;

public interface BookDao {
	/**
	 * 通过书的isbn查看这本书的价格
	 * @param isbn
	 * @return
	 */
	int getBookPriceByIsbn(String isbn);

	/**
	 * 减去用户里的钱
	 * @param account
	 * @param price
	 */
	void updateUserBalance(String account, int price);

	/**
	 * 减少书的数量
	 * @param isbn
	 */
	void updateBookStock(String isbn);

	/**
	 * 查询用户的余额
	 * @param account
	 * @return
	 */
	int getUserBalanceByAccount(String account);

	/**
	 * 查询书的库存
	 * @param isbn
	 * @return
	 */
	int getBookStockByIsbn(String isbn);
}
