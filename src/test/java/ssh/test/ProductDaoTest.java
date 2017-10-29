package ssh.test;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ssh.day04.Product;
import ssh.day04.ProductDao;

public class ProductDaoTest {

	
	ClassPathXmlApplicationContext ctx ;
	ProductDao dao;
	
	
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("spring-orm.xml");
		dao = ctx.getBean("productDao",ProductDao.class);
	}
	
	@Test
	public void testHibernateTemplate(){
		Product p = new Product(null, "Â·»¢", 500000.0, new Date());
		dao.add(p);
		System.out.println(p);
	}
	@Test
	public void testFindAll(){
		List<Product> list = dao.findAll();
		for(Product p : list){
			System.out.println(p);
		}
	}
	
	@After
	public void destory(){
		ctx.close();
	}
	
}
