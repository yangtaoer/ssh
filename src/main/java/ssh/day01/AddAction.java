package ssh.day01;

public class AddAction {
	private Product product;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	//����JavaBean������ձ�����
	public String add(){
		System.out.println(product);
		return "success";
	}
	
}
