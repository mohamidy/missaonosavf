package com.costaismael.missaonos.avf;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.costaismael.missaonos.avf.domain.Familia;
import com.costaismael.missaonos.avf.domain.Membro;
import com.costaismael.missaonos.avf.domain.MembroFamilia;
import com.costaismael.missaonos.avf.domain.TipoMembro;
import com.costaismael.missaonos.avf.domain.Usuario;
import com.costaismael.missaonos.avf.repositories.FamiliaRepository;
import com.costaismael.missaonos.avf.repositories.MembroFamiliaRepository;
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
	@Autowired
	private MembroFamiliaRepository membroFamiliaRepository;


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
		TipoMembro tpMembro5 = new TipoMembro(null, "Avó");	

		usuarioRepository.save(Arrays.asList(user1,user2,user3));	
		tipoMembroRepository.save(Arrays.asList(tpMembro,tpMembro2, tpMembro3,tpMembro4,tpMembro5));
		
		Familia fam1 = new Familia(null, "Antiqueira Costa");
		Familia fam2 = new Familia(null, "Castro Silveira");
		
		Membro mem1 = new Membro(null, "Ismael",sdf.parse("30/04/2018 10:32"),tpMembro,user1);
		Membro mem2 = new Membro(null, "Camilla",sdf.parse("30/04/2018 10:32"),tpMembro2,user2);
		// neste caso o gato não tem login
		Membro mem3 = new Membro(null, "missy",sdf.parse("30/04/2018 10:32"),tpMembro3,null);
		// Ismael tio da familai castro silveira
		Membro mem4 = new Membro(null, "Ismael",sdf.parse("30/04/2018 10:32"),tpMembro4,user1);
		Membro mem5 = new Membro(null, "Maria",sdf.parse("30/04/2018 10:32"),tpMembro5,null);
		
		MembroFamilia memf1 = new MembroFamilia(mem1, fam1, 1);
		MembroFamilia memf2 = new MembroFamilia(mem2, fam1, 1);
		MembroFamilia memf3 = new MembroFamilia(mem3, fam1, 1);
		MembroFamilia memf4 = new MembroFamilia(mem4, fam2, 1);
		// Maria é avó da familai costa e silveira
		MembroFamilia memf5 = new MembroFamilia(mem5, fam1, 0);
		MembroFamilia memf6 = new MembroFamilia(mem5, fam2, 0);
		
        fam1.getMembrosFamilias().addAll(Arrays.asList(memf1,memf2,memf3,memf5));
        fam2.getMembrosFamilias().addAll(Arrays.asList(memf4,memf6));
        
        mem1.getMembrosFamilias().addAll(Arrays.asList(memf1));
        mem2.getMembrosFamilias().addAll(Arrays.asList(memf2));
        mem3.getMembrosFamilias().addAll(Arrays.asList(memf3));
        mem4.getMembrosFamilias().addAll(Arrays.asList(memf4));
        mem5.getMembrosFamilias().addAll(Arrays.asList(memf5,memf6));
		
		familiaRepository.save(Arrays.asList(fam1,fam2));
		membroRepository.save(Arrays.asList(mem1,mem2,mem3,mem4,mem5));		
		membroFamiliaRepository.save(Arrays.asList(memf1,memf2,memf3,memf4,memf5,memf6));
		
		System.out.println(fam1.toString());
	}
}
