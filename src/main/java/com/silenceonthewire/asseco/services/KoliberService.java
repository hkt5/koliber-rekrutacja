package com.silenceonthewire.asseco.services;

import com.silenceonthewire.asseco.annotations.KoliberFieldDescription;
import com.silenceonthewire.asseco.models.Address;
import com.silenceonthewire.asseco.models.Contractor;
import com.silenceonthewire.asseco.models.Currency;
import com.silenceonthewire.asseco.models.Invoice;

import java.lang.reflect.Field;

public class KoliberService {

    public void printData() throws NoSuchFieldException {
        printCurrency();
        printCurrencyCode();
        printAmount();
        printContractor();
        printContractorData();
        printAddressData();
        printNumber();
    }

    private void printCurrency() throws NoSuchFieldException {
        Class<Invoice> invoiceClass = Invoice.class;
        Field currencyField = invoiceClass.getDeclaredField("currency");
        KoliberFieldDescription koliberFieldDescription = currencyField.getAnnotation(KoliberFieldDescription.class);
        System.out.println(currencyField.getName() +" - "+ koliberFieldDescription.comment());
    }

    private void printCurrencyCode() throws  NoSuchFieldException {
        Class<Currency> currencyClass = Currency.class;
        Field codeField = currencyClass.getDeclaredField("code");
        KoliberFieldDescription koliberFieldDescription = codeField.getAnnotation(KoliberFieldDescription.class);
        System.out.println("\t" + codeField.getName() +" - "+ koliberFieldDescription.comment());
    }

    private void printAmount() throws NoSuchFieldException {
        Class<Invoice> invoiceClass = Invoice.class;
        Field currencyField = invoiceClass.getDeclaredField("amount");
        KoliberFieldDescription koliberFieldDescription = currencyField.getAnnotation(KoliberFieldDescription.class);
        System.out.println(currencyField.getName() +" - "+ koliberFieldDescription.comment());
    }

    private void printContractor() throws NoSuchFieldException {
        Class<Invoice> invoiceClass = Invoice.class;
        Field currencyField = invoiceClass.getDeclaredField("contractor");
        KoliberFieldDescription koliberFieldDescription = currencyField.getAnnotation(KoliberFieldDescription.class);
        System.out.println(currencyField.getName() +" - "+ koliberFieldDescription.comment());
    }

    private void printContractorData() throws NoSuchFieldException {
        Class<Contractor> contractorClass = Contractor.class;
        getContractorField(contractorClass, "name");
        getContractorField(contractorClass, "nip");
        getContractorField(contractorClass, "address");
    }

    private void printAddressData() throws NoSuchFieldException {
        Class<Address> addressClass = Address.class;
        getAddressField(addressClass, "city");
        getAddressField(addressClass, "postalCode");
        getAddressField(addressClass, "street");
    }

    private void printNumber() throws NoSuchFieldException {
        Class<Invoice> invoiceClass = Invoice.class;
        Field currencyField = invoiceClass.getDeclaredField("number");
        KoliberFieldDescription koliberFieldDescription = currencyField.getAnnotation(KoliberFieldDescription.class);
        System.out.println(currencyField.getName() +" - "+ koliberFieldDescription.comment());
    }

    private void getContractorField(Class<Contractor> contractorClass, String name) throws NoSuchFieldException {
        Field currencyField = contractorClass.getDeclaredField(name);
        KoliberFieldDescription koliberFieldDescription = currencyField.getAnnotation(KoliberFieldDescription.class);
        System.out.println("\t" + currencyField.getName() +" - "+ koliberFieldDescription.comment());
    }

    private void getAddressField(Class<Address> addressClass, String name) throws NoSuchFieldException {
        Field currencyField = addressClass.getDeclaredField(name);
        KoliberFieldDescription koliberFieldDescription = currencyField.getAnnotation(KoliberFieldDescription.class);
        System.out.println("\t\t" + currencyField.getName() +" - "+ koliberFieldDescription.comment());
    }
}
