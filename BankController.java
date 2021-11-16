package com.BankLaila.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BankLaila.model.BankModel;
import com.BankLaila.service.BankService;

@RestController
@RequestMapping("api/bank")
public class BankController {

	@Autowired
	private BankService bs;
	
	@GetMapping("/listBank")
	public List<BankModel> listBank() {
		return bs.listBank();
	}
	
	@GetMapping("/listBankById/{id}")
	public BankModel listBankiById(@PathVariable long id) {
		return bs.listBankById(id);
	}

	@PostMapping("/addBank")
	public ResponseEntity<?> addBank(@RequestBody List<BankModel> bm, @PathVariable String nama) {
		boolean cekContent = true;
		for (BankModel b:bm) {
			if (b.getNama().equals("") || b.getVacode().equals("")) {
				cekContent=false;
				break;
			}
		}
		boolean cekDuplicate = true;
		for (BankModel b:bm) {
			int cekNama = bs.cekNama(b.getNama(), b.getVacode());
			if (cekNama != 0) {
				cekDuplicate=false;
				break;
			}
		}
		if (cekContent == true && cekDuplicate == true) {
			try {
				for (BankModel b:bm)
					bs.addBank(b.getNama(), b.getVacode());
				return new ResponseEntity<>("Created Bank Success",HttpStatus.CREATED);
			} 
			catch (Exception e) {
				return new ResponseEntity<>("Masalah : " + e,HttpStatus.BAD_REQUEST);
			}
		} 
		else if (cekContent==false)
			return new ResponseEntity<>("Nama atau VaCode kosong!!!",HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>("Nama atau VaCode sudah tercatat!!!",HttpStatus.CONFLICT);
	}
		
//	
//	@PutMapping("/editBank/{id}/{nama}/{vacode}")
//	public int editBank(@PathVariable long id, @PathVariable String nama, @PathVariable String vacode) {
//		return bs.editBank(id, nama, vacode);
//	}
	
	@PutMapping("/editBank")
	public int editBank(@RequestBody List<BankModel> bm) {
		for (BankModel b : bm) {
			bs.editBank(b.getId(), b.getNama(), b.getVacode());
		}
		return 1;
	}
	
	@PutMapping("/deleteBank/{id}")
	public void deleteBank(@PathVariable int id) {
		bs.deleteBank(id);
	}
}
