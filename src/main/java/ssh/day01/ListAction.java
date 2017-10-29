package ssh.day01;

import java.util.ArrayList;
import java.util.List;

public class ListAction {
	private List<Product> list = new ArrayList<Product>();
	
	public List<Product> getList() {
		return list;
	}
	
	public void setList(List<Product> list) {
		this.list = list;
	}
	
	public String execute(){
		Product p = new Product();
		for(int i=0;i<5;i++){
			p.setAge((int)(Math.random()*50));
			p.setAddress(String.valueOf((Math.random()*50)));
			p.setPrice((Math.random()*50));
			list.add(p);
		}
		return "success";
	}
	
	
}
