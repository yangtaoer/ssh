package ssh.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ssh.day04.Product;

public class OrmTestCase {
	ClassPathXmlApplicationContext ctx ;
	SessionFactory factory;
	
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("spring-orm.xml");
		factory = ctx.getBean("sessionFactory",SessionFactory.class);
		
	}
	
	@Test
	public void testGetProduct(){
		Session s = factory.openSession();
		Product p = (Product)s.get(ssh.day04.Product.class, 1);
		System.out.println(p);
		s.close();
	}
	
	
	
	@After
	public void destory(){
		factory.close();
		ctx.close();
	}
	
}
