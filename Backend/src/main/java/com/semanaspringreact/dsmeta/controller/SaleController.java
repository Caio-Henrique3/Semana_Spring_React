package com.semanaspringreact.dsmeta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.semanaspringreact.dsmeta.entities.Sale;
import com.semanaspringreact.dsmeta.services.SaleService;
import com.semanaspringreact.dsmeta.services.SmsService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService saleService;
	@Autowired
	private SmsService smsService;

	@GetMapping
	public Page<Sale> findSales(Pageable pageable) {
		return saleService.findSales(pageable);
	}
	
	@GetMapping("/date")
	public Page<Sale> findSalesDate(Pageable pageable,
			@RequestParam(value = "dataInicial", defaultValue = "") String dataInicial,
			@RequestParam(value = "dataFinal", defaultValue = "") String dataFinal) {
		return saleService.findSalesDate(pageable, dataInicial, dataFinal);
	}
	
	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}

}
