package com.softtech.bootcamp.case2.controller;

import com.softtech.bootcamp.case2.dto.DistrictDTO;
import com.softtech.bootcamp.case2.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/districts")
public class DistrictController {

    private final DistrictService districtService;

    @PostMapping
    public DistrictDTO save(DistrictDTO districtDTO){
        return districtService.save(districtDTO);
    }

    @PutMapping
    public DistrictDTO update(DistrictDTO districtDTO){
        return districtService.update(districtDTO);
    }

    @GetMapping("/search")
    public List<DistrictDTO> findAllByCityName(@RequestParam("cityName") String countryName){
        return districtService.findAllByCityName(countryName);
    }

    @DeleteMapping("/{idList}")
    public void deleteAll(@PathVariable("idList") List<Long> idList){
        districtService.deleteAll(idList);
    }
}
