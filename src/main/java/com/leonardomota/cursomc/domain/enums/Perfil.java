package com.leonardomota.cursomc.domain.enums;

public enum Perfil {
	
	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");
	
	private Integer cod;
	private String descricao;	

	private Perfil(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return cod;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static Perfil toEnum(Integer codigo) {
		if(codigo == null)
			return null;
		
		for(Perfil x: Perfil.values()) {
			if(codigo.equals(x.getCodigo()))
				return x;
		}
		
		throw new IllegalArgumentException("Código Inválido! " + codigo);
	}
}