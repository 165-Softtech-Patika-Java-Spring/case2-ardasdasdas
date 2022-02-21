package com.softtech.bootcamp.case2.controller;

import com.softtech.bootcamp.case2.converter.CountryMapper;
import com.softtech.bootcamp.case2.dto.CountryDTO;
import com.softtech.bootcamp.case2.model.Country;
import com.softtech.bootcamp.case2.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/countries")
public class CountryController {

    private final CountryService countryService;

    @PostMapping
    public CountryDTO save(CountryDTO countryDTO){
        return countryService.save(countryDTO);
    }

    @PutMapping
    public CountryDTO update(CountryDTO countryDTO){
        return countryService.update(countryDTO);
    }

    @GetMapping("/search")
    public CountryDTO findByCode(@RequestParam("code") String code){
        return countryService.findByCode(code);
    }

    @DeleteMapping("/{idList}")
    public void deleteAll(@PathVariable("idList") List<Long> idList){
        countryService.deleteAll(idList);
    }

}
