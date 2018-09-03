package com.hs.test;

import com.hs.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JdbcTemplateTest {

	private ApplicationContext ac;
	private JdbcTemplate jdbcTemplate;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
	}

	/**
	 * 返回Map数据
	 */
	@Test
	public void test01() {
		/*String sql = "select * from oa_user where user_id = 3";
		Map<String, Object> map = this.jdbcTemplate.queryForMap(sql);*/
		String sql = "select * from oa_user where user_id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, 2);
		System.out.println(map);
	}

	/**
	 * 返回List_Map数据
	 */
	@Test
	public void test02() {
		String sql = "select * from oa_user";
		System.out.println(jdbcTemplate.queryForList(sql));
	}

	/**
	 * 返回一个值
	 */
	@Test
	public void test03() {
		String sql = "select count(*) from oa_user";
		System.out.println(jdbcTemplate.queryForObject(sql, Integer.class));

	}

	/**
	 * 返回一个对象
	 */
	@Test
	public void test04() {
		String sql = "select * from oa_user where user_id = ?";
		User user = jdbcTemplate.queryForObject(sql, /*匿名内部类*/new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {

				User user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("User_name"));
				user.setSex(rs.getString("sex"));
				user.setMoney(rs.getBigDecimal("money"));
				user.setBirthday((Date) rs.getObject("birthday"));
				return user;
			}
		}, 2);
		System.out.println(user);

	}

	/**
	 * 返回一个List<对象>
	 */
	@Test
	public void test05() {
		String sql = "select * from oa_user where user_name like concat('%',?,'%')";
		List<User> userList = jdbcTemplate.query(sql,/*处理一条一条的数据*/new UserRowMapper(), "沙僧");
		System.out.println(userList);
	}

	/**
	 * 返回一个List<对象>——自动映射，类属性和查询的字段名字一样
	 */
	@Test
	public void test06() {
		String sql = "select * from oa_user where user_name like concat('%',?,'%')";
		List<User> userList = jdbcTemplate.query(sql,/*处理一条一条的数据，，，<User>可以不用写*/new BeanPropertyRowMapper<User>(User.class), "沙僧");
		System.out.println(userList);
	}

	/**
	 * 添加修改删除
	 */
	@Test
	public void test07() {
		String sql1 = "insert into oa_user(user_name,sex,money,birthday) values(?,?,?,?)";
		String sql2 = "update oa_user set user_name=?,sex=? where user_id = ?";
		String sql3 = "delete from oa_user where user_id = ?";
		int num1 = jdbcTemplate.update(sql1, "唐僧", "男", 220.00, "2018-8-9");
		int num2 = jdbcTemplate.update(sql2, "和尚", "男", 16);
		int num3 = jdbcTemplate.update(sql3, 17);
		System.out.println(num1+"--"+num2+"---"+num3);

	}


	/**
	 * 对于外面那个类来说，这是一个内部类，外面那个类对于这个类来说，是外部类
	 * 百度什么是内部类和特种？
	 * private使这个类只能被这个类使用
	 */
	private class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("---------");
			User user = new User();
			user.setUser_id(rs.getInt("user_id"));
			user.setUser_name(rs.getString("User_name"));
			user.setSex(rs.getString("sex"));
			user.setMoney(rs.getBigDecimal("money"));
			user.setBirthday((Date) rs.getObject("birthday"));
			return user;
		}
	}
}


