package com.softtech.bootcamp.case2.controller;

import com.softtech.bootcamp.case2.dto.CityDTO;
import com.softtech.bootcamp.case2.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cities")
public class CityController {

    private final CityService cityService;

    @PostMapping
    public CityDTO save(CityDTO countryDTO){
        return cityService.save(countryDTO);
    }

    @PutMapping
    public CityDTO update(CityDTO countryDTO){
        return cityService.update(countryDTO);
    }

    @GetMapping("/search")
    public CityDTO findByPlateNo(@RequestParam("plateNo") String plateNo){
        return cityService.findByPlateNo(plateNo);
    }

    @DeleteMapping("/{idList}")
    public void deleteAll(@PathVariable("idList") List<Long> idList){
        cityService.deleteAll(idList);
    }
}
