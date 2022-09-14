package kodlamaio.kamp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.kamp.core.result.DataResult;
import kodlamaio.kamp.core.result.Result;
import kodlamaio.kamp.core.result.SuccessDataResult;
import kodlamaio.kamp.core.result.SuccessResult;
import kodlamaio.kamp.dto.ProductWithCategoryDto;
import kodlamaio.kamp.model.Product;
import kodlamaio.kamp.repository.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public DataResult<List<Product> >getAllProducts(){
		return new SuccessDataResult<List<Product>>(productRepository.findAll(), "Data Listelendi ");
	}
	
	public Result addProduct(Product product) {
		this.productRepository.save(product);
		
		return new SuccessResult("Ekleme başarılı");
	}
	
	public DataResult<Product> findByProductName(String productName){
		return new SuccessDataResult<Product>(productRepository.findByProductName(productName),"Data getirildi");
		
	}
	
	public DataResult<Product> findByProductNameAndCategory(String productName , int categoryId){
		return new SuccessDataResult<Product>(productRepository.findByProductNameAndCategory(productName, categoryId), "Date getirildi");
	}
	
	public DataResult<List<Product>> findByProductNameOrCategory(String productName , int categoryId){
		return new SuccessDataResult<List<Product>>(productRepository.findByProductNameOrCategory(productName, categoryId), "Data Listelendi ");
	}
	
	public DataResult<List<Product>>findByCategoryId(List<Integer> categories){
		return new SuccessDataResult<List<Product>>(productRepository.findByCategoryIdIn(categories), "Data Listelendi ");

	}
	
	public DataResult<List<Product>> findByProductNameContains(String productName){
		return new SuccessDataResult<List<Product>>(productRepository.findByProductNameContains(productName), "Data Listelendi ");

	}
	
	public DataResult<List<Product>> findByProductNameStartsWith(String productName){
		return new SuccessDataResult<List<Product>>(productRepository.findByProductNameStartsWith(productName), "Data Listelendi ");

	}
	
	public DataResult<List<Product>> findByNameAndCategory(String productName, int categoryId){
		return new SuccessDataResult<List<Product>>(productRepository.findByNameAndCategory(productName, categoryId), "Data Listelendi ");

	}
	
	public DataResult<List<ProductWithCategoryDto>> findProductWithCategoryDetails(){
		return new SuccessDataResult<List<ProductWithCategoryDto>>(productRepository.findProductWithCategoryDetails(),"Data getirildi");
	}
}
