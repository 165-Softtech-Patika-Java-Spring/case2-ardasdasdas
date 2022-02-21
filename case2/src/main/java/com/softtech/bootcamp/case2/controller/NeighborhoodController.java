package com.softtech.bootcamp.case2.controller;

import com.softtech.bootcamp.case2.dto.NeighborhoodDTO;
import com.softtech.bootcamp.case2.service.NeighborhoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/neighborhoods")
public class NeighborhoodController {

    private final NeighborhoodService neighborhoodService;

    @PostMapping
    public NeighborhoodDTO save(NeighborhoodDTO neighborhoodDTO){
        return neighborhoodService.save(neighborhoodDTO);
    }

    @PutMapping
    public NeighborhoodDTO update(NeighborhoodDTO neighborhoodDTO){
        return neighborhoodService.update(neighborhoodDTO);
    }

    @GetMapping("/search")
    public List<NeighborhoodDTO> findAllByDistrictName(@RequestParam("districtName") String districtName){
        return neighborhoodService.findAllByDistrictName(districtName);
    }

    @DeleteMapping("/{idList}")
    public void deleteAll(@PathVariable("idList") List<Long> idList){
        neighborhoodService.deleteAll(idList);
    }
}
