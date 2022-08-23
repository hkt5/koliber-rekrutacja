package com.silenceonthewire.asseco.services;

import com.silenceonthewire.asseco.models.Address;

public interface AddressFieldGetable {
    void getAddressField(Class<Address> addressClass, String name) throws NoSuchFieldException;
}
