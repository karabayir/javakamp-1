package kodlamaio.kamp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.kamp.core.result.DataResult;
import kodlamaio.kamp.core.result.Result;
import kodlamaio.kamp.dto.ProductWithCategoryDto;
import kodlamaio.kamp.model.Product;
import kodlamaio.kamp.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public DataResult<List<Product>>  getAllProducts(){
		return productService.getAllProducts();
	}
	
	@PostMapping
	public Result addProduct(@RequestBody Product product){
		return productService.addProduct(product);
	}
	
	@GetMapping("/findByproductName")
	public DataResult<Product> findByProductName(@RequestParam String productName){
		return productService.findByProductName(productName);
	}
	
	@GetMapping("/findByNameAndCategory")
	public DataResult<Product> findByProductNameAndCategory(@RequestParam String productName ,@RequestParam int categoryId){
		return productService.findByProductNameAndCategory(productName, categoryId);
	}
	
	@GetMapping("/findProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> findProductWithCategoryDetails(){
		return productService.findProductWithCategoryDetails();
	}
	
	
}
