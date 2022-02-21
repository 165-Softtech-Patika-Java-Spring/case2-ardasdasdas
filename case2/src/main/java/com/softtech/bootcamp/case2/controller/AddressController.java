package com.softtech.bootcamp.case2.controller;

import com.softtech.bootcamp.case2.dto.AddressDTO;
import com.softtech.bootcamp.case2.dto.AddressResultDTO;
import com.softtech.bootcamp.case2.dto.CityDTO;
import com.softtech.bootcamp.case2.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/addresses")
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public AddressDTO save(AddressDTO addressDTO){
        return addressService.save(addressDTO);
    }

    @PutMapping
    public AddressDTO update(AddressDTO addressDTO){
        return addressService.update(addressDTO);
    }

    @GetMapping("/search")
    public AddressResultDTO findById(@RequestParam("id") Long id){
        return addressService.findAddressById(id);
    }

    @DeleteMapping("/{idList}")
    public void deleteAll(@PathVariable("idList") List<Long> idList){
        addressService.deleteAll(idList);
    }
}
