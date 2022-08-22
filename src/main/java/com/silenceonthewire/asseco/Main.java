package com.silenceonthewire.asseco;

import com.silenceonthewire.asseco.services.KoliberService;

public class Main {

	public static void main(String[] args) throws Exception {

		KoliberService koliberService = new KoliberService();
		koliberService.printData();
	}
}
