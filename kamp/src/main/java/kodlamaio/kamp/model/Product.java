package kodlamaio.kamp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    private String productName;
    private double unitsPrice;
    private short unitInStock;
    private String quantityPerUnit;
    
    @ManyToOne()
    private Category category;

}
