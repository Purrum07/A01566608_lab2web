/**
 * 
 */
package mx.tec.web.lab.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.tec.web.lab.entity.Product;
import mx.tec.web.lab.manager.ProductManager;

/**
 * Description This class handles  of the HTTP Requests with an specific route
 * @author Mario Márquez
 *
 */
@RestController
public class ProductController {
	
	/**
	 * The resource from where all the product operations are done
	 */
	@Resource
	private ProductManager productManager;
	
	/**
	 * The endpoint for request GET {url}/products without parameters to retrieve all the products in the database
	 * @return the response entity depending in the content of it (products and status code)
	 */
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = productManager.getProducts();	
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	/**
	 * The endpoint for request GET {url}/products/{id} to retrieve the product in the database with the given id
	 * @param id Product id 
	 * @return the response entity depending in the content of it (product and status code)
	 */
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable(value = "id") long id) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		Optional<Product> product = productManager.getProduct(id);
		
		if (product.isPresent()) {
			responseEntity = new ResponseEntity<>(product.get(), HttpStatus.OK);
		}
		
		return responseEntity;
	}
	
	/**
	 * The end point for GET {url}/products?search={pattern} to find products with an specific pattern
	 * @param search Pattern to search
	 * @return a json list of all the products
	 */
	@GetMapping(value="/products", params="search")
	public ResponseEntity<List<Product>> getProducts(@RequestParam String search) {
		List<Product> products = productManager.getProducts(search);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	
	/**
	 * The end point for POST {url}/products/ to add a new product
	 * @param newProduct specific JSON with the information of a product
	 * @return the response entity depending in the content of it
	 */
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product newProduct) {
		ResponseEntity<Product> responseEntity;
		Product product = productManager.addProduct(newProduct);
		
		responseEntity = new ResponseEntity<>(product, HttpStatus.CREATED);

		return responseEntity;
	}
	
	/**
	 * The end point for PUT {url}/products/{id} to modify specific product
	 * @param id Product id
	 * @param product specific JSON with the information of a product
	 * @return the response entity depending in the content of it
	 */
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") long id, @RequestBody Product modifiedProduct) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		Optional<Product> product = productManager.getProduct(id);
		
		if (product.isPresent()) {
			productManager.updateProduct(id, modifiedProduct);
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
		}
		
		return responseEntity;
	}

	
	/**
	 * The end point for DELETE {url}/products/{id} to delete an specific product
	 * @param id Product id
	 * @return the response entity depending in the content of it
	 */
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable(value = "id") long id) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		Optional<Product> product = productManager.getProduct(id);
		
		if (product.isPresent()) {
			productManager.deleteProduct(product.get());
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
		}
		
		return responseEntity;
	}
	
}

