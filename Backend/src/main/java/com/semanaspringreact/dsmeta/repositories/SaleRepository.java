package com.semanaspringreact.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.semanaspringreact.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("SELECT s FROM Sale s WHERE s.date BETWEEN :inicio AND :fim ORDER BY s.amount DESC")
	Page<Sale> findSalesDate(Pageable pageable, LocalDate inicio, LocalDate fim);
	
}
