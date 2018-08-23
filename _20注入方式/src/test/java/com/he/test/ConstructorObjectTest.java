package com.he.test;

import com.hs.model.Role;
import com.hs.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorObjectTest {

	/**
	 * 测试在类名前面加@Component进行实例化类
	 */
	@Test
	public void test01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		User user = ac.getBean("user",User.class);
		System.out.println(user);
	}
	/**
	 * 测试在beans.xml中用构造函数实例化对象——普通值
	 */
	@Test
	public void test02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		User user = ac.getBean("user01",User.class);
		System.out.println(user);
	}

	/**
	 * 测试在beans.xml中用构造函数实例化对象——数组，list，set
	 */
	@Test
	public void test03() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		User user = ac.getBean("user02",User.class);
		System.out.println(user);
	}
	/**
	 * 测试在beans.xml中用构造函数实例化对象——Map和Properties
	 */
	@Test
	public void test04() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		User user = ac.getBean("user03",User.class);
		System.out.println(user);
	}

	/**
	 * 自定义类型实例化，给User类中的Role类的变量，进行实例化操作
	 */
	@Test
	public void test05() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		User user = ac.getBean("user04",User.class);
		System.out.println(user);
		//下面这个证明User类的那个bean Role role,范围只能在User里
		/*Role role1 = ac.getBean("role1", Role.class);
		System.out.println(role1);*/
	}

	/**
	 * 给自定义类型初始化数据
	 */
	@Test
	public void test06() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		User user = ac.getBean("user05",User.class);
		System.out.println(user);
	}
	/**
	 * 给自定义类型初始化数据——推荐引用方式
	 */
	@Test
	public void test07() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		User user = ac.getBean("user06",User.class);
		System.out.println(user);
		Role role = ac.getBean("role2", Role.class);
		System.out.println(role);
	}

	/**
	 * 接口注入实现类，实现接口回调
	 */
	@Test
	public void test08() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		User user = ac.getBean("user07",User.class);
		user.getHsTest().print();
	}
}
