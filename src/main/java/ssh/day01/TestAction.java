package ssh.day01;

public class TestAction {
	private Integer age;
	private String address;
	private Double price;
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String save(){
		
		/**
		 * Struts ��ִ�п���������֮ǰ��������ע�뵽Bean������
		 */
		System.out.println("age:"+age);
		System.out.println("address:"+address);
		System.out.println("price:"+price);
		return "success";
	}
}
