package com.costaismael.missaonos.avf;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		TipoMembro tpMembro4 = new TipoMembro(null, "Tio");
		
		List<Familia> familias = new ArrayList<>();
		List<Familia> familias2 = new ArrayList<>();
		
		Familia fam1 = new Familia(null, "Antiqueira Costa");
		Familia fam2 = new Familia(null, "Castro Silveira");

		
		familias.addAll(Arrays.asList(fam1));
		familias2.addAll(Arrays.asList(fam2));
				
		Membro mem1 = new Membro(null, "Ismael",sdf.parse("30/04/2018 10:32"),tpMembro,user1,familias);
		Membro mem2 = new Membro(null, "Camilla",sdf.parse("30/04/2018 10:32"),tpMembro2,user2,familias);
		// neste caso o gato não tem login
		Membro mem3 = new Membro(null, "missy",sdf.parse("30/04/2018 10:32"),tpMembro3,null,familias);
		// Ismael tio da familai castro silveira
		Membro mem4 = new Membro(null, "Ismael",sdf.parse("30/04/2018 10:32"),tpMembro4,user1,familias2);
		
		fam1.getMembros().addAll(Arrays.asList(mem1,mem2,mem3,mem4));		
		
		usuarioRepository.save(Arrays.asList(user1,user2,user3));	
		tipoMembroRepository.save(Arrays.asList(tpMembro,tpMembro2, tpMembro3,tpMembro4));
		familiaRepository.save(Arrays.asList(fam1,fam2));
		membroRepository.save(Arrays.asList(mem1,mem2,mem3,mem4));		
		
		System.out.println(fam1.toString());
	}
}
