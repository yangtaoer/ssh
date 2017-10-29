package ssh.day04;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -279236065953424961L;
	private Integer id;
	private String name;
	private Double price;
	private Date createDate;
	public Product(Integer id, String name, Double price, Date createDate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.createDate = createDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Product(){
		
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", createDate=" + createDate + "]";
	}
	
	
	
}
