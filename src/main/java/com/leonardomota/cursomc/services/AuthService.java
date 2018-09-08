package com.leonardomota.cursomc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.leonardomota.cursomc.domain.Cliente;
import com.leonardomota.cursomc.repositories.ClienteRepository;
import com.leonardomota.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		Cliente cli = clienteRepo.findByEmail(email);
		if(cli == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		
		String newPass = newPassword();
		cli.setSenha(pe.encode(newPass));
		
		clienteRepo.save(cli);	
		emailService.sendNewPasswordEmail(cli, newPass);
	}
	
	private String newPassword() {
		char vet[] = new char[10];
		for(int i=0; i<10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		char aux;
		switch (opt) {
			case 0:
				aux = (char) (rand.nextInt(10) + 48);
				break;
			case 1:
				aux = (char) (rand.nextInt(26) + 65);
				break;
			default :
				aux = (char) (rand.nextInt(26) + 97);
				break;
		}
		return aux;
	}
}
