package com.leonardomota.cursomc.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private Integer cod;
	private String descricao;	

	private TipoCliente(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return cod;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static TipoCliente toEnum(Integer codigo) {
		if(codigo == null)
			return null;
		
		for(TipoCliente x: TipoCliente.values()) {
			if(codigo.equals(x.getCodigo()))
				return x;
		}
		
		throw new IllegalArgumentException("Código Inválido! " + codigo);
	}
}