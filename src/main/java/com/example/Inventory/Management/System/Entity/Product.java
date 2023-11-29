package com.example.Inventory.Management.System.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name = "Product_Table")
public class Product {
     @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String code;
	private String name;
	private String vname;


	private String type;
    private int price;
	private String detail;
	

	public Product () {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
    public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
	

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name +   ", code=" + code + ", vname=" + vname + " , type=" + type + ", detail=" + detail + ", price=" + price + "]";
	}
}
