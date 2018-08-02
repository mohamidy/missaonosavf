package com.costaismael.missaonos.avf;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.costaismael.missaonos.avf.domain.Usuario;
import com.costaismael.missaonos.avf.repositories.UsuarioRepository;

@SpringBootApplication
public class MissaonosavfApplication implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(MissaonosavfApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Usuario user1 = new Usuario(null, "ismael", "123", sdf.parse("30/04/2018 10:32"), 1);
		Usuario user2 = new Usuario(null, "julio", "123", sdf.parse("30/09/2018 10:32"), 1);
		Usuario user3 = new Usuario(null, "cafu", "123", sdf.parse("30/12/2018 10:32"), 1);
		
		usuarioRepository.save(Arrays.asList(user1,user2,user3));		
	}
}
