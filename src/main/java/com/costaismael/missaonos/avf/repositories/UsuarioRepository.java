package com.costaismael.missaonos.avf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.costaismael.missaonos.avf.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Usuario  findByLoginAndSenha(String login, String senha);
	Usuario  findByEmailAndSenha(String email, String senha);
}
