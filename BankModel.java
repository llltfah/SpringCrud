package com.BankLaila.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.springframework.lang.NonNull;

@Entity
@Table(name = "mBank")
public class BankModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "nama", length = 100, nullable = false)
	private String nama;

	@Column(name = "vacode", length = 10, nullable = false)
	private String vacode;
	
	@Column(name = "isdelete", columnDefinition = "boolean default false")
	private boolean isdelete;
	
	@Column(name = "createdby", columnDefinition = "bigint default 1")
	private long createdby;
	
	@Column(name = "createdon", columnDefinition = "timestamp default now()") //audit trail
	private Timestamp createdon;

	@Column(name = "modifiedby", columnDefinition = "bigint default 0")
	private long modifiedby;
	
	@Column(name = "modifiedon", columnDefinition = "timestamp default null")
	private Timestamp modifiedon;
	
	@Column(name = "deletedby", columnDefinition = "bigint default 0")
	private long deletedby;
	
	@Column(name = "deletedon", columnDefinition = "timestamp default null")
	private Timestamp deletedon;

	public long getCreatedby() {
		return createdby;
	}

	public void setCreatedby(long createdby) {
		this.createdby = createdby;
	}

	public Timestamp getCreatedon() {
		return createdon;
	}

	public void setCreatedon(Timestamp createdon) {
		this.createdon = createdon;
	}
	
	public long getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(long modifiedby) {
		this.modifiedby = modifiedby;
	}

	public Timestamp getModifiedon() {
		return modifiedon;
	}

	public void setModifiedon(Timestamp modifiedon) {
		this.modifiedon = modifiedon;
	}

	public long getDeletedby() {
		return deletedby;
	}

	public void setDeletedby(long deletedby) {
		this.deletedby = deletedby;
	}

	public Timestamp getDeletedon() {
		return deletedon;
	}

	public void setDeletedon(Timestamp deletedon) {
		this.deletedon = deletedon;
	}	
	
	public boolean isDelete() {
		return isdelete;
	}

	public void setDelete(boolean isDelete) {
		this.isdelete = isDelete;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getVacode() {
		return vacode;
	}

	public void setVacode(String vacode) {
		this.vacode = vacode;
	}
	
}
