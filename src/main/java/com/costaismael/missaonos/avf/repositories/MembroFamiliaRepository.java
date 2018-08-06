package com.costaismael.missaonos.avf.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.costaismael.missaonos.avf.domain.MembroFamilia;

@Repository
public interface MembroFamiliaRepository extends JpaRepository<MembroFamilia, Integer>{

	List<MembroFamilia> findByFamiliaId(Integer familiaId);
	MembroFamilia  findByMembroIdAndFamiliaId(Integer membroId, Integer familiaId);
}
