package br.com.sprj.mvc.mudi.dto;

import br.com.sprj.mvc.mudi.model.Order;
import lombok.Data;

@Data
public class newOrderDto {

    private String productName;
    private String productUrl;
    private String imageUrl;
    private String description;

    public Order toOrder() {
	Order order = new Order();
	order.setProductName(productName);
	order.setProductUrl(productUrl);
	order.setImageUrl(imageUrl);
	order.setDescription(description);
	return order;
    }

}