package com.silenceonthewire.asseco.services;

import com.silenceonthewire.asseco.models.Contractor;

public interface ContractorFieldGetable {
    void getContractorField(Class<Contractor> contractorClass, String name) throws NoSuchFieldException;
}
