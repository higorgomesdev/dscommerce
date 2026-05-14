package com.devsuperior.dacommerce.DTO;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.devsuperior.dacommerce.entities.Order;
import com.devsuperior.dacommerce.entities.OrderItem;
import com.devsuperior.dacommerce.enums.OrderStatus;

import jakarta.validation.constraints.NotEmpty;

public class OrderDTO {
	
	private Long id;
	private Instant moment;
	private OrderStatus status;
	
	private ClientDTO client;
	
	private PaymentDTO payment;
	
	@NotEmpty
	private List<OrderItemDTO> items = new ArrayList<>();
	
	public OrderDTO() {
	}

	public OrderDTO(Long id, Instant moment, OrderStatus status, ClientDTO client, PaymentDTO payment,
			List<OrderItemDTO> items) {
		this.id = id;
		this.moment = moment;
		this.status = status;
		this.client = client;
		this.payment = payment;
	}
	
	public OrderDTO(Order entity) {
		id = entity.getId();
		moment = entity.getMoment();
		status = entity.getStatus();
		client = new ClientDTO(entity.getClient());
		payment = (entity.getPayment() == null) ? null : new PaymentDTO(entity.getPayment());
		for(OrderItem item : entity.getItems()) {
			OrderItemDTO itemDTO = new OrderItemDTO(item);
			items.add(itemDTO);
		}
	}

	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public ClientDTO getClient() {
		return client;
	}

	public PaymentDTO getPayment() {
		return payment;
	}

	public List<OrderItemDTO> getItems() {
		return items;
	}
	
	public Double getTotal() {
		Double Total = 0.0;
		for(OrderItemDTO itemDTO: items) {
			Total += itemDTO.getSubTotal();
		}
		return Total;
	}
}
