package com.sophos.dev.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class CapturaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String codigo;
	@NotNull
	private String nombre;

	private Integer edad;

	public CapturaDTO() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "CapturaDTO [codigo=" + codigo + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	
}
