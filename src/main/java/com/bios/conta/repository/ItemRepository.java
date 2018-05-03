package com.bios.conta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bios.conta.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
	
	@Query("SELECT i FROM Item i WHERE i.conta.id = :contaId")
	List<Item> getItensPorConta(@Param("contaId") Long contaId);

}
