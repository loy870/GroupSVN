package com.fdmgroup.chocolatectore.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SALES database table.
 * 
 */
@Entity
@Table(name="SALES")
@NamedQuery(name="Sale.findAll", query="SELECT s FROM Sale s")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SALES_SALESID_GENERATOR", sequenceName="SALE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SALES_SALESID_GENERATOR")
	@Column(name="SALES_ID")
	private long salesId;

	@Temporal(TemporalType.DATE)
	@Column(name="SALE_DATE")
	private Date saleDate;

	//bi-directional many-to-one association to ProductSale
	@OneToMany(mappedBy="sale")
	private List<ProductSale> productSales;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private User user;

	public Sale() {
	}

	public long getSalesId() {
		return this.salesId;
	}

	public void setSalesId(long salesId) {
		this.salesId = salesId;
	}

	public Date getSaleDate() {
		return this.saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public List<ProductSale> getProductSales() {
		return this.productSales;
	}

	public void setProductSales(List<ProductSale> productSales) {
		this.productSales = productSales;
	}

	public ProductSale addProductSale(ProductSale productSale) {
		getProductSales().add(productSale);
		productSale.setSale(this);

		return productSale;
	}

	public ProductSale removeProductSale(ProductSale productSale) {
		getProductSales().remove(productSale);
		productSale.setSale(null);

		return productSale;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}