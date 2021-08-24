package mx.tec.web.lab.manager;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.tec.web.lab.entity.Product;
import mx.tec.web.lab.entity.Sku;
import mx.tec.web.lab.repository.ProductRepository;

/**
 * Description This class is in charge of handle all the functionality of product
 * @author Mario Márquez
 *
 */
@Service
public class ProductManager {
	/**
	 * The resource from where the data is coming to be used
	 */
	@Resource
	ProductRepository productRepository;

	/**
	 * Retrieve all the products from the database without parameters
	 * @return the list of products
	 */
	public List<Product> getProducts() {
		
		return productRepository.findAll();
	}

	/**
	 * Retrieve the product from the database found by a given id
	 * @param id Product id
	 * @return the product found by id
	 */
	public Optional<Product> getProduct(final long id) {
		return productRepository.findById(id);
	}
	
	/**
	 * Retrieve an specific product based on a given product id
	 * @param pattern Pattern to search
	 * @return Optional containing a product if the product was found or empty otherwise
	 */
	public List<mx.tec.web.lab.entity.Product> getProducts(final String pattern) {
		return productRepository.findByNameLike(pattern);
	}


	/**
	 * Add a new product to the database with its child Skus creating the relation to create a parent product
	 * @param newProduct
	 * @return the new product added to the list
	 */
	public Product addProduct(final Product newProduct) {
		for(final Sku newSku : newProduct.getChildSkus()) {
			newSku.setParentProduct(newProduct);
		}
		return productRepository.save(newProduct);
	}

	/**
	 * Modify a product already in the database depending on the product id with its corresponding child skus and generating the parent product 
	 * @param id Product id 
	 * @param modifiedProduct
	 * @return void
	 */
	public void updateProduct(final long id, final Product modifiedProduct) {
		if(modifiedProduct.getId() == id) {
			for(final Sku modifiedSku : modifiedProduct.getChildSkus()) {
				modifiedSku.setParentProduct(modifiedProduct);
			}
			productRepository.save(modifiedProduct);
		}
	}


	/**
	 * Delete an existing product
	 * @param existingProduct
	 * @return void
	 */
	public void deleteProduct(final Product existingProduct) {
		productRepository.delete(existingProduct);
	}
}
