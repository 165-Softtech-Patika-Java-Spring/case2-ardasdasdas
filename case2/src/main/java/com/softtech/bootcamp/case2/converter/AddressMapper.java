package com.softtech.bootcamp.case2.converter;

import com.softtech.bootcamp.case2.dto.AddressDTO;
import com.softtech.bootcamp.case2.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    Address toAddress(AddressDTO addressDTO);

    AddressDTO fromAddress(Address address);

    List<Address> toAddressList(List<AddressDTO> addressDTOList);

    List<AddressDTO> fromAddressList(List<Address> addressList);

}
