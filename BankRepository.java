package com.BankLaila.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.BankLaila.model.BankModel;

public interface BankRepository extends JpaRepository<BankModel, Integer> {

	@Query(value = "select count(nama), count(vacode) from m_bank where nama = :nama, vacode = :vacode limit 1", nativeQuery = true)
	int cekNama(String nama, String vacode);
	
	@Query(value = "select * from m_bank where isdelete = false order by id", nativeQuery = true)
	List<BankModel> listBank();
	
	@Query(value = "select * from m_bank where id = ?1", nativeQuery = true)
	BankModel listBankById(long id);
	
	@Modifying
	@Query(value = "insert into m_bank(nama,vacode,createdby)values(:nama,:vacode,2)", nativeQuery = true)
	int addBank(String nama, String vacode); //void or int/Integer

	@Modifying
	@Query(value = "update m_bank set nama = :nama, vacode = :vacode, modifiedby = 2, modifiedon = now() where id = :id", nativeQuery = true)
	int editBank(long id, String nama, String vacode);
	
	@Modifying
	@Query(value = "update m_bank set isdelete = true, deletedby = 2, deletedon = now() where id = ?1", nativeQuery = true)
	int deleteBank(long id);
}
