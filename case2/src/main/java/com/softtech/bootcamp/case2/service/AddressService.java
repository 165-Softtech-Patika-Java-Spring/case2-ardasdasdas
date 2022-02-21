package com.softtech.bootcamp.case2.service;

import com.softtech.bootcamp.case2.converter.AddressMapper;
import com.softtech.bootcamp.case2.converter.StreetMapper;
import com.softtech.bootcamp.case2.dto.AddressDTO;
import com.softtech.bootcamp.case2.dto.AddressResultDTO;
import com.softtech.bootcamp.case2.enums.NotFoundErrorMessage;
import com.softtech.bootcamp.case2.exception.NotFoundException;
import com.softtech.bootcamp.case2.model.Address;
import com.softtech.bootcamp.case2.model.Country;
import com.softtech.bootcamp.case2.model.Street;
import com.softtech.bootcamp.case2.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressDTO save(AddressDTO addressDTO){
        Address address = AddressMapper.INSTANCE.toAddress(addressDTO);
        return AddressMapper.INSTANCE.fromAddress(addressRepository.save(address));
    }

    public AddressDTO findById(Long id){
        return AddressMapper.INSTANCE.fromAddress(findByIdOrElseThrowNotFoundException(id));
    }

    public AddressDTO update(AddressDTO addressDTO) {
        Address address = AddressMapper.INSTANCE.toAddress(addressDTO);
        notFoundByIdControl(address.getId());
        return AddressMapper.INSTANCE.fromAddress(addressRepository.save(address));
    }

    public AddressResultDTO findAddressById(Long id){
        notFoundByIdControl(id);
        return addressRepository.findAddressById(id);
    }

    @Transactional
    public void deleteAll(List<Long> idList){
        addressRepository.deleteAll(idList);
    }

    private Address findByIdOrElseThrowNotFoundException(Long id){
        return addressRepository.findById(id).orElseThrow(() -> new NotFoundException(NotFoundErrorMessage.ADDRESS_NOT_FOUND_ERROR_MESSAGE));
    }

    private void notFoundByIdControl(Long id){
        boolean isExistsById = addressRepository.existsById(id);
        if(!isExistsById) throw new NotFoundException(NotFoundErrorMessage.ADDRESS_NOT_FOUND_ERROR_MESSAGE);
    }

}
