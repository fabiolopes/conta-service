package com.bios.conta.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bios.conta.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{

	@Query("SELECT c FROM Conta c WHERE c.data > CURRENT_DATE - 15")
    List<Conta> getContasQuinzena();

	@Query("SELECT c FROM Conta c WHERE c.data BETWEEN :inicio AND :fim")
	List<Conta> getContasPorFiltroData(@Param("inicio") Date inicio,
			@Param("fim") Date fim);
	
}
