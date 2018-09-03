package com.hs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MoreBookServiceImpl implements MoreBookService {
	@Autowired
	private OneBookService oneBookService;

	@Transactional  //包含在这里面的都是事务方法
	@Override
	public void buyMoreBook(String account, String... isbns) {
		if (isbns != null) {
			for (String isbn : isbns) {
				oneBookService.buyOneBook(account,isbn);
			}
		}

	}
}
