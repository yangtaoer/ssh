package ssh.day04;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{

	
	@Resource
	private ProductDao dao;
	public List<Product> list() {
		return dao.findAll();

	}

}
