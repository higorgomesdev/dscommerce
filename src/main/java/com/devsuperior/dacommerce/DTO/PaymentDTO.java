package com.devsuperior.dacommerce.DTO;

import java.time.Instant;

import com.devsuperior.dacommerce.entities.Payment;

public class PaymentDTO {
	
	private Long id;
	private Instant momemnt;
	
	public PaymentDTO() {
	}
	
	public PaymentDTO(Long id, Instant momemnt) {
		this.id = id;
		this.momemnt = momemnt;
	}
	
	public PaymentDTO(Payment entity) {
		id = entity.getId();
		momemnt = entity.getMoment();
	}

	public Long getId() {
		return id;
	}

	public Instant getMomemnt() {
		return momemnt;
	}

}
