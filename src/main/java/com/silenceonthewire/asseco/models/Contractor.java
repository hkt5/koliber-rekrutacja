package com.silenceonthewire.asseco.models;

import com.silenceonthewire.asseco.annotations.KoliberDescription;
import com.silenceonthewire.asseco.annotations.KoliberFieldDescription;

import java.util.Optional;

@KoliberDescription(comment = "Kontrahent")

public class Contractor {

    @KoliberFieldDescription(comment = "Nazwa")

    private String name;

    @KoliberFieldDescription(comment = "NIP")

    private String nip;

	@KoliberFieldDescription(comment = "Faktura")
	private Invoice invoice;
    @KoliberFieldDescription(comment = "Adres")

    private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
