package coisasemprestadas.models;

import java.util.Calendar;

import coisasemprestadas.models.Emprestimo;
import coisasemprestadas.models.Usuario;

public class Emprestimo {
	private Long id;
	private Calendar dataEmp;
	private Calendar dataDev;
	private Usuario usuario;
	private String coisas;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Calendar getDataEmp() {
		return dataEmp;
	}
	public void setDataEmp(Calendar dataEmp) {
		this.dataEmp = dataEmp;
	}
	public Calendar getDataDev() {
		return dataDev;
	}
	public void setDataDev(Calendar dataDev) {
		this.dataDev = dataDev;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getCoisas() {
		return coisas;
	}
	public void setCoisas(String coisas) {
		this.coisas = coisas;
	}
	
	
	
}