package com.silenceonthewire.asseco.services;

import com.silenceonthewire.asseco.annotations.KoliberFieldDescription;
import com.silenceonthewire.asseco.models.Address;
import com.silenceonthewire.asseco.models.Contractor;
import com.silenceonthewire.asseco.models.Currency;
import com.silenceonthewire.asseco.models.Invoice;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class KoliberService {

    public void printData() throws NoSuchFieldException {
        Map<String, Object> invoicesMap = getData();
        invoicesMap.forEach((key, value) -> {
            if(!key.equals("contractor_data") && !key.equals("contractor_address") && !key.equals("currency_data")) {
                System.out.println(key + "-" + value);
            }
            if("currency".equals(key)) {
                Map<String, Object> currency_data = (Map<String, Object>) invoicesMap.get("currency_data");
                currency_data.forEach((currency_key, currency_value) -> {
                    System.out.println("\t" + currency_key + "-" + currency_value);
                });
            }
            if("contractor".equals(key)) {
                Map<String, Object> contractor_data = (Map<String, Object>) invoicesMap.get("contractor_data");
                contractor_data.forEach((contractor_key, contractor_value) -> {
                    System.out.println("\t" + contractor_key + "-" + contractor_value);
                    if("address".equals(contractor_key)){
                        Map<String, Object> contractor_address = (Map<String, Object>) invoicesMap.get("contractor_address");
                        contractor_address.forEach((address_key, address_value) -> {
                            System.out.println("\t\t" + address_key + "-" + address_value);
                        });
                    }
                });
            }
        });
    }

    private Map<String, Object> getData() {
        Map<String, Object> invoicesMap = new HashMap<>();

        Class<?> type = Invoice.class;
        Field[] fields = type.getDeclaredFields();
        for (Field currentField: fields) {
            sotwareDecisionForFieldName(invoicesMap, currentField);
        }
        return invoicesMap;
    }

    private void sotwareDecisionForFieldName(Map<String, Object> invoicesMap, Field currentField) {
        if ("contractor".equals(currentField.getName())) {
            KoliberFieldDescription koliberFieldDescription = currentField.getAnnotation(KoliberFieldDescription.class);
            invoicesMap.put(currentField.getName(), koliberFieldDescription.comment());
            invoicesMap.put("contractor_data", check(Contractor.class));
            invoicesMap.put("contractor_address", check(Address.class));
        } else if ("currency".equals(currentField.getName())){
            KoliberFieldDescription koliberFieldDescription = currentField.getAnnotation(KoliberFieldDescription.class);
            invoicesMap.put(currentField.getName(), koliberFieldDescription.comment());
            invoicesMap.put("currency_data", check(Currency.class));
        } else {
            KoliberFieldDescription koliberFieldDescription = currentField.getAnnotation(KoliberFieldDescription.class);
            invoicesMap.put(currentField.getName(), koliberFieldDescription.comment());
        }
    }

    public Map<String, String> check(Class<?> type) {
        Map<String, String> fieldsMap = new HashMap<>();
        Field[] fields = type.getDeclaredFields();
        for (Field currentField: fields) {
            KoliberFieldDescription koliberFieldDescription = currentField.getAnnotation(KoliberFieldDescription.class);
            fieldsMap.put(Optional.of(currentField.getName()).orElse("Invoice"), koliberFieldDescription.comment());
        }
        return fieldsMap;
    }
}
