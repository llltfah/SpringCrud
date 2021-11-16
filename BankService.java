package com.BankLaila.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankLaila.model.BankModel;
import com.BankLaila.repository.BankRepository;

@Service
@Transactional
public class BankService {
	
	@Autowired
	private BankRepository br;
	
	public int cekNama(String nama, String vacode) {
		return br.cekNama(nama, vacode);
	}
	
	public List<BankModel> listBank() {
		return br.listBank();
	}

	public BankModel listBankById(long id) {
		return br.listBankById(id);
	}

	public int addBank(String nama,String vacode) {
		return br.addBank(nama, vacode);
		
	}

	public int editBank(long id, String nama, String vacode) {
		return br.editBank(id, nama, vacode);
	}

	public void deleteBank(long id) {
		br.deleteBank(id);
	}

	

}
