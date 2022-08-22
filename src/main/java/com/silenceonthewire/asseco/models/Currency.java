package com.silenceonthewire.asseco.models;

import com.silenceonthewire.asseco.annotations.KoliberDescription;
import com.silenceonthewire.asseco.annotations.KoliberFieldDescription;

@KoliberDescription(comment = "Waluta")

public class Currency {

    @KoliberFieldDescription(comment = "Kod")

    private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
