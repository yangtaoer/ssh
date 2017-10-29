package ssh.day04;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class ProductAction {

	@Resource
	private ProductService ps;
	
	private List<Product> products;
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public String list(){
		products = ps.list();
		return "success";
	}
}
