package br.com.tqi.worldcupmascot.enums;

public enum MascotEnum {

	AMIJUBI(1),
	FULECO(2),
	ZUZECO(3);
	
	private Integer value;
	
	private MascotEnum(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
}
