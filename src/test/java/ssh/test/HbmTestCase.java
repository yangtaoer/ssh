package ssh.test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ssh.day03.User;
import ssh.day04.Product;

public class HbmTestCase {
	SessionFactory factory;
	
	@Before
	public void init(){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
		
	}
	
	@Test
	public void testSave(){
		Session s = factory.openSession();
		User user = new User(3, "陈浩亮", 22, 3000.00, new Date(System.currentTimeMillis()));		
		Transaction tx = s.beginTransaction();//相当于开启事务
		s.save(user);
		tx.commit();//提交事务,必须的
		s.close();
	}
	
	@Test
	public void testGet(){
		Integer id = 1;
		Session s = factory.openSession();
		User user = (User)s.get(User.class, id);
		System.out.println(user);
		s.close();
	}

	@Test
	public void testUpdate(){
		Integer id = 1;
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		User user = (User)s.get(User.class, id);	//先查询对象
		user.setAge(55);
		user.setHiredate(new Date());
		user.setName("王麻子");
		s.update(user);
		tx.commit();
		s.close();
	}
	@Test
	public void testFindAll(){
		String hql="from User";
		Session s = factory.openSession();
		Query query = s.createQuery(hql);
		List<User> list = query.list();
		for(User u : list){
			System.out.println(u);
		}
		s.close();
	}
	
	@Test
	public void testFindAll2(){
		//sql: select t_id,t_name from t_user;
		//hql: select new map(id as Id,name as Name) from User
		Session s = factory.openSession();
		String hql = "select new map(id as id,name as Name) from User";
		Query query = s.createQuery(hql);
		List<Map<String,Object>> list = query.list();
		for(Map<String,Object> map : list){
			System.out.println(map);
		}
	}
	
	@Test
	public void testFindByParam(){
		//sql: select * from t_user where t_salary > ?
		//hql : from User where salary > ?
		String hql = "from User where salary > ?";
		Session s = factory.openSession();
		Query query = s.createQuery(hql);
		query.setDouble(0, 3000.0);//序号从0开始;
		List<User> list = query.list();
		for(User u : list){
			System.out.println(u);
		}
	}
	
	@Test
	public void testFindByParams(){
		//sql: select * from t_user where t_salary > ?
		//hql : from User where salary > ?
		String hql = "from User where salary>:salary";
		Session s = factory.openSession();
		Query query = s.createQuery(hql);
		query.setDouble("salary", 3000.0);//序号从0开始;
		List<User> list = query.list();
		for(User u : list){
			System.out.println(u);
		}
	}
	
	@Test
	public void testAutoUpdate(){
		Session s = factory.openSession();
		User user = new User(6, "陈浩亮儿", 22, 3000.00, new Date(System.currentTimeMillis()));		
		Transaction tx = s.beginTransaction();//相当于开启事务
		s.save(user);//User是持久状态
		user.setAge(23);
		user.setSalary(100.0);
		s.flush();
		tx.commit();//提交事务,必须的
		s.close();
	}
	
	@Test
	public void testState(){
		Session s = factory.openSession();
		//User user = new User(5, "陈浩亮仔", 23, 3200.00, new Date(System.currentTimeMillis()));		
		Transaction tx = s.beginTransaction();//相当于开启事务
		User user = (User)s.get(User.class, 6);
		//s.save(user);//User是持久状态
		s.evict(user);//对象为游离状态,无法更改数据
		s.update(user);
		user.setAge(23);
		user.setSalary(119.0);
		s.flush();
		tx.commit();//提交事务,必须的
		s.close();
	}
	
	@Test
	public void testAddProduct(){
		Product p = new Product(null,"汽车",20000.0,new Date());
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		System.out.println("1----"+p);
		s.save(p);
		//Hibernate 或自动读取自增长的ID
		System.out.println("2----"+p);
		tx.commit();
		s.close();
	}
	
	@After
	public void destory(){
		factory.close();
	}
}
