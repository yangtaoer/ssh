package ssh.day04;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao{
	
	@Resource
	private HibernateTemplate ht;

	public void add(Product p) {
		ht.save(p);//ht�ṩ��session����ع���
		/**
		 *  ��װ������Ĺ���
		 * 	Transaction tx = s.beginTransaction();	
		 *	s.save(p);		
		 *	tx.commit();
		 *	s.close();
		 */
	}

	public List<Product> findAll() {
		//sql = select * from t_product(������)
		//hql = from Product(������)
		String hql = "from Product";
		List<Product> list = (List<Product>)ht.find(hql);
		return list;
	}
	
	
}
