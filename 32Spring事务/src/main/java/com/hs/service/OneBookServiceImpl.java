package com.hs.service;

import com.hs.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Transactional  //点石成金，标识这个方法是事务方法
@Service    //<bean id = "oneBookServiceImpl" class="xxx">
public class OneBookServiceImpl implements OneBookService {
	//建立联系
	@Autowired  //直接在属性上注解setter方式，也可以在setter方法上注解
	//指明具体的id
	@Qualifier("bookDaoImpl")
	//<property name = "BookDao" ref="bookDaoImpl">
	private BookDao bookDao;

	//点石成金，标识这个方法是事务方法
	//@Transactional
	//@Transactional(readOnly = true) //只读，一般只做查询操作使用
	//@Transactional(noRollbackForClassName = "RuntimeException") //遇见这个异常，数据就不会回滚
//	@Transactional(propagation = Propagation.REQUIRES_NEW)
//	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void buyOneBook(String account, String isbn) {
		//1.查询书的价格
		int price = bookDao.getBookPriceByIsbn(isbn);
		//2.判断会员余额是否充足
		int balance = bookDao.getUserBalanceByAccount(account);
		if (balance < price) {
			throw new RuntimeException("账号余额不足，请充值");
		}
		//3.会员中的余额 - 书价格
		bookDao.updateUserBalance(account, price);
		//4.判断库存数量是否充足
		int stock = bookDao.getBookStockByIsbn(isbn);
		if (stock == 0) {
			throw new RuntimeException("书的库存数量不足");
		}
		//5.库存书的数量 - 1
		bookDao.updateBookStock(isbn);
	}
}
