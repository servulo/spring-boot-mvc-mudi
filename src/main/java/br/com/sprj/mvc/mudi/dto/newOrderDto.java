package br.com.sprj.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.sprj.mvc.mudi.model.Order;
import br.com.sprj.mvc.mudi.model.OrderStatus;
import lombok.Data;

@Data
public class NewOrderDto {

    @NotBlank
    private String productName;
    
    @NotBlank
    private String productUrl;
    
    @NotBlank
    private String imageUrl;
    
    
    private String description;

    public Order toOrder() {
	Order order = new Order();
	order.setProductName(productName);
	order.setProductUrl(productUrl);
	order.setImageUrl(imageUrl);
	order.setDescription(description);
	order.setOrderStatus(OrderStatus.WAITING);
	return order;
    }

}