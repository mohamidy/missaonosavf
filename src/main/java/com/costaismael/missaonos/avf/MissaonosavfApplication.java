package com.costaismael.missaonos.avf;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.costaismael.missaonos.avf.domain.Familia;
import com.costaismael.missaonos.avf.domain.Membro;
import com.costaismael.missaonos.avf.domain.TipoMembro;
import com.costaismael.missaonos.avf.domain.Usuario;
import com.costaismael.missaonos.avf.repositories.FamiliaRepository;
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
	@Autowired
	private FamiliaRepository familiaRepository;


	public static void main(String[] args) {
		SpringApplication.run(MissaonosavfApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Usuario user1 = new Usuario(null, "ismael", "123", sdf.parse("30/04/2018 10:32"), 1);
		Usuario user2 = new Usuario(null, "camilla", "123", sdf.parse("30/09/2018 10:32"), 1);
		Usuario user3 = new Usuario(null, "cafu", "123", sdf.parse("30/12/2018 10:32"), 1);
		
		TipoMembro tpMembro = new TipoMembro(null, "Pai");
		TipoMembro tpMembro2 = new TipoMembro(null, "Mãe");
		TipoMembro tpMembro3 = new TipoMembro(null, "Gato");
		
		Familia fam1 = new Familia(null, "Antiqueira Costa");
				
		Membro mem1 = new Membro(null, "Ismael",sdf.parse("30/04/2018 10:32"),tpMembro,user1,fam1);		
		Membro mem2 = new Membro(null, "Camilla",sdf.parse("30/04/2018 10:32"),tpMembro2,user2,fam1);
		// neste caso o gato não tem login
		Membro mem3 = new Membro(null, "missy",sdf.parse("30/04/2018 10:32"),tpMembro3,null,fam1);
		
		fam1.getMembros().addAll(Arrays.asList(mem1,mem2,mem3));		
		
		usuarioRepository.save(Arrays.asList(user1,user2,user3));	
		tipoMembroRepository.save(Arrays.asList(tpMembro,tpMembro2, tpMembro3));
		familiaRepository.save(Arrays.asList(fam1));
		membroRepository.save(Arrays.asList(mem1,mem2,mem3));		
		
		System.out.println(fam1.toString());
	}
}
