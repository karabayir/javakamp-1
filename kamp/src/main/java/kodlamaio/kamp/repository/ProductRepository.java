package kodlamaio.kamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.kamp.core.result.DataResult;
import kodlamaio.kamp.dto.ProductWithCategoryDto;
import kodlamaio.kamp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	
	Product findByProductName(String productName);
	
	Product findByProductNameAndCategory(String productName , int categoryId);
	
	List<Product> findByProductNameOrCategory(String productName , int categoryId);
	
	List<Product>findByCategoryIdIn(List<Integer> categories);
	
	List<Product> findByProductNameContains(String productName);
	
	List<Product> findByProductNameStartsWith(String productName);
	
	
	@Query("From Product where productName=:productName and category=:categoryId ")
	List<Product> findByNameAndCategory(String productName, int categoryId);
	
	@Query("Select new kodlamaio.kamp.dto.ProductWithCategoryDto(p.id, p.productName, c.categoryName)"
			+ "From Category c Inner Join c.productList p  ")
	List<ProductWithCategoryDto> findProductWithCategoryDetails();
}
