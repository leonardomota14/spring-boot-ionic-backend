package com.leonardomota.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.leonardomota.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
