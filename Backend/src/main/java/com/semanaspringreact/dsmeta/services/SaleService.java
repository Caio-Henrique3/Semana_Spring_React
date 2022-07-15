package com.semanaspringreact.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.semanaspringreact.dsmeta.entities.Sale;
import com.semanaspringreact.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;
	
	public Page<Sale> findSales(Pageable pageable) {
		return saleRepository.findAll(pageable);
	}
	
	public Page<Sale> findSalesDate(Pageable pageable, String dataInicial, String dataFinal) {
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate inicio = dataInicial.equals("") ? today : LocalDate.parse(dataInicial);
		LocalDate fim = dataFinal.equals("") ? today : LocalDate.parse(dataFinal);
		
		return saleRepository.findSalesDate(pageable, inicio, fim);
	}
	
}
