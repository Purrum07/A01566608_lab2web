package mx.tec.web.lab.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Description This class has all the functionality for Product
 * @author Mario Márquez
 *
 */
@Entity
public class Product implements Serializable{
	
	/**
	 * Generated serial version Id
	 */
	private static final long serialVersionUID = 1940424686731950240L;

	/**
	 * parameter id	Product id
	 * Description Is a value generated automatically
	 */
	@Id
	@GeneratedValue
	private long id;
	
	/**
	 * parameter name	Product name
	 */
	private String name;
	
	/**
	 * parameter description	Product description
	 */
	private String description;
	
	/**
	 * parameter childSkus	Child Skus of the product, which has a relation One to Many mapped by parentProduct
	 */
	@OneToMany(mappedBy = "parentProduct", cascade = CascadeType.ALL)
	private List<Sku> childSkus;
	
	/**
	 * No arguments constructor
	 */
	public Product() {
	}

	/**
	 * Constructor including all the properties
	 * 
	 * @param id			Product id
	 * @param name			Product name
	 * @param description	Product description
	 * @param childSkus		The child skus related to the product
	 */
	public Product(long id, String name, String description, List<Sku> childSkus) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.childSkus = childSkus;
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
	 * Getter of name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter of name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter of description
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter of description
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter of the childSkus
	 * @return the childSkus
	 */
	public List<Sku> getChildSkus() {
		return childSkus;
	}

	/**
	 * Setter of the childSkus
	 * @param childSkus the childSkus to set
	 */
	public void setChildSkus(List<Sku> childSkus) {
		this.childSkus = childSkus;
	}
	
	/**
	 * toString method for Product entity
	 * @return The complete Product as a String
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", childSkus=" + childSkus
				+ "]";
	}

	/**
	 * hashCode method for Product id to create hash for id
	 * @return hash for id
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
	 * equals method for Product to compare specified product
	 * @param obj the other object with which is going to be compared
	 * @return true or false depending on the result of the comparison
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Product)) {
			return false;
		}
		Product other = (Product) obj;
		return id == other.id;
	}

}
