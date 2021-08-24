package mx.tec.web.lab.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Description This class has all the functionality for Sku
 * @author Mario Márquez
 *
 */
@Entity
public class Sku implements Serializable{
	
	/**
	 * Generated serial version Id for Sku
	 */
	private static final long serialVersionUID = -6185764898853598449L;

	/**
	 * parameter id	Sku id
	 * Description Is a value generated automatically
	 */
	@Id
	@GeneratedValue
	private long id;
	
	/**
	 * parameter color	Sku color
	 */
	private String color;
	
	/**
	 * parameter size 	Sku size
	 */
	private String size;
	
	/**
	 * parameter listPrice	The list price
	 */
	private double listPrice;
	
	/**
	 * parameter salePrice	The sale price
	 */
	private double salePrice;
	
	/**
	 * parameter quantityOnHand	The quantity on hand
	 */
	private long quantityOnHand;
	
	/**
	 * parameter smallImageUrl	The small Image URL
	 */
	private String smallImageUrl;
	
	/**
	 * parameter mediumImageUrl	The medium Image URL
	 */
	private String mediumImageUrl;
	
	/**
	 * parameter largeImageUrl	The large Image URL
	 */
	private String largeImageUrl;
	
	/**
	 * parameter parentProduct	Parent product of the Sku, which is ignored and has a relation Many to One
	 */
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Product parentProduct;


	/**
	 * No arguments constructor
	 */
	public Sku() {
	}

	/**
	 * Constructor including all the properties
	 * 
	 * @since 2.0
	 * @param id             Sku id
	 * @param color          Sku color
	 * @param size           Sku size
	 * @param listPrice      The list price
	 * @param salePrice      The sale price
	 * @param quantityOnHand The quantity on hand
	 * @param smallImageUrl  The small Image URL
	 * @param mediumImageUrl The medium Image URL
	 * @param largeImageUrl  The large Image URL
	 */
	public Sku(long id, String color, String size, double listPrice, double salePrice, long quantityOnHand,
			String smallImageUrl, String mediumImageUrl, String largeImageUrl) {
		this.id = id;
		this.color = color;
		this.size = size;
		this.listPrice = listPrice;
		this.salePrice = salePrice;
		this.quantityOnHand = quantityOnHand;
		this.smallImageUrl = smallImageUrl;
		this.mediumImageUrl = mediumImageUrl;
		this.largeImageUrl = largeImageUrl;
	}

	/**
	 * Getter of id
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Setter of id
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Getter of color
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Setter of color
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Getter of size
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * Setter of size
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * Getter of list price
	 * @return the listPrice
	 */
	public double getListPrice() {
		return listPrice;
	}

	/**
	 * Setter of list price
	 * @param listPrice the listPrice to set
	 */
	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	/**
	 * Getter of sale price
	 * @return the salePrice
	 */
	public double getSalePrice() {
		return salePrice;
	}

	/**
	 * Setter of sale price
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	/**
	 * Getter of quantity on hand
	 * @return the quantityOnHand
	 */
	public long getQuantityOnHand() {
		return quantityOnHand;
	}

	/**
	 * Setter of quantity on hand
	 * @param quantityOnHand the quantityOnHand to set
	 */
	public void setQuantityOnHand(long quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

	/**
	 * Getter of small image Url
	 * @return the smallImageUrl
	 */
	public String getSmallImageUrl() {
		return smallImageUrl;
	}

	/**
	 * Setter of small image Url
	 * @param smallImageUrl the smallImageUrl to set
	 */
	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}

	/**
	 * Getter of medium image Url
	 * @return the mediumImageUrl
	 */
	public String getMediumImageUrl() {
		return mediumImageUrl;
	}

	/**
	 * Setter of medium image Url
	 * @param mediumImageUrl the mediumImageUrl to set
	 */
	public void setMediumImageUrl(String mediumImageUrl) {
		this.mediumImageUrl = mediumImageUrl;
	}

	/**
	 * Getter of large image Url
	 * @return the largeImageUrl
	 */
	public String getLargeImageUrl() {
		return largeImageUrl;
	}

	/**
	 * Setter of large image Url
	 * @param largeImageUrl the largeImageUrl to set
	 */
	public void setLargeImageUrl(String largeImageUrl) {
		this.largeImageUrl = largeImageUrl;
	}

	/**
	 * Getter of parent product
	 * @return the parentProduct
	 */
	public Product getParentProduct() {
		return parentProduct;
	}

	/**
	 * Setter of parent product
	 * @param parentProduct the parentProduct to set
	 */
	public void setParentProduct(Product parentProduct) {
		this.parentProduct = parentProduct;
	}
	
	/**
	 * toString method for Sku entity
	 * @return The complete Sku as a String
	 */
	@Override
	public String toString() {
		return "Sku [id=" + id + ", color=" + color + ", size=" + size + ", listPrice=" + listPrice + ", salePrice="
				+ salePrice + ", quantityOnHand=" + quantityOnHand + ", smallImageUrl=" + smallImageUrl
				+ ", mediumImageUrl=" + mediumImageUrl + ", largeImageUrl=" + largeImageUrl + ", parentProduct="
				+ parentProduct + "]";
	}

	/**
	 * hashCode method for Sku id to create hash for id
	 * @return hash for id
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	/**
	 * equals method for Sku to compare specified product
	 * @param obj the other object with which is going to be compared
	 * @return true or false depending on the result of the comparison
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Sku)) {
			return false;
		}
		Sku other = (Sku) obj;
		return id == other.id;
	}
}
