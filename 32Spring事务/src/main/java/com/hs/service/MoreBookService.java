package com.hs.service;

public interface MoreBookService {
	/**
	 * 买多本书
	 * String... 是可变长度参数列表，可以存多个
	 * @param account
	 * @param isbns
	 */
	void buyMoreBook(String account, String... isbns);
}
