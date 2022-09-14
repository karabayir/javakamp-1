package kodlamaio.kamp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductWithCategoryDto {

	private int id;
	private String productName;
	private String categoryName;
}
