package com.costaismael.missaonos.avf;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.costaismael.missaonos.avf.domain.Membro;
import com.costaismael.missaonos.avf.domain.TipoMembro;
import com.costaismael.missaonos.avf.domain.Usuario;
import com.costaismael.missaonos.avf.repositories.MembroRepository;
import com.costaismael.missaonos.avf.repositories.TipoMembroRepository;
import com.costaismael.missaonos.avf.repositories.UsuarioRepository;

@SpringBootApplication
public class MissaonosavfApplication implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private MembroRepository membroRepository;
	@Autowired
	private TipoMembroRepository tipoMembroRepository;


	public static void main(String[] args) {
		SpringApplication.run(MissaonosavfApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Usuario user1 = new Usuario(null, "ismael", "123", sdf.parse("30/04/2018 10:32"), 1);
		Usuario user2 = new Usuario(null, "julio", "123", sdf.parse("30/09/2018 10:32"), 1);
		Usuario user3 = new Usuario(null, "cafu", "123", sdf.parse("30/12/2018 10:32"), 1);
		
		TipoMembro tpMembro = new TipoMembro(null, "Pai");
		TipoMembro tpMembro2 = new TipoMembro(null, "Filho");
		
		Membro mem1 = new Membro(null, "Ismael",sdf.parse("30/04/2018 10:32"),tpMembro,user1);		
		// neste caso o filho não tem login
		Membro mem2 = new Membro(null, "filho de ismael",sdf.parse("30/04/2018 10:32"),tpMembro2,null);
		
		usuarioRepository.save(Arrays.asList(user1,user2,user3));	
		tipoMembroRepository.save(Arrays.asList(tpMembro,tpMembro2));
		membroRepository.save(Arrays.asList(mem1,mem2));
	}
}
