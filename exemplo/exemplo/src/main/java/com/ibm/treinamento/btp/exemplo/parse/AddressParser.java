package com.ibm.treinamento.btp.exemplo.parse;

import com.ibm.treinamento.btp.exemplo.entity.AddressEntity;
import com.ibm.treinamento.btp.exemplo.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressParser {
    public AddressEntity parse(Address address){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setBairro(address.getBairro());
        addressEntity.setCep(address.getCep());
        addressEntity.setCidade(address.getCidade());
        addressEntity.setEstado(address.getEstado());
        addressEntity.setRua(address.getRua());
        addressEntity.setNumero(address.getNumero());
        return addressEntity;
    }

    public Address parse(AddressEntity addressEntity){
        Address address = new Address();
        address.setBairro(addressEntity.getBairro());
        address.setCep(addressEntity.getCep());
        address.setCidade(addressEntity.getCidade());
        address.setEstado(addressEntity.getEstado());
        address.setRua(addressEntity.getRua());
        address.setNumero(addressEntity.getNumero());
        return address;
    }
}
