package com.costaismael.missaonos.avf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.costaismael.missaonos.avf.domain.TipoMembro;

@Repository
public interface TipoMembroRepository extends JpaRepository<TipoMembro, Integer>{

}
