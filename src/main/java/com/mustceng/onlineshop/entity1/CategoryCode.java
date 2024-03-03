package com.mustceng.onlineshop.entity1;

import com.mustceng.onlineshop.enums.EnumInterface;

import java.util.Objects;

public enum CategoryCode implements EnumInterface {
	AUTOMATIVE("Automotive"),
	BOOKS("Books"),
	CD_DVD("CD_DVD"),
	CLOTHES("Clothes"),
	ELECTRONICS("Electronics"),
	KITCHEN("Kitchen"),
	SPORTS("Sports");

	private String value;

	CategoryCode(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static CategoryCode fromValue(String v) {
		for (CategoryCode o : CategoryCode.values()) {
			if (Objects.equals(o.value, v)) {
				return o;
			}
		}
		return null;
	}
}
