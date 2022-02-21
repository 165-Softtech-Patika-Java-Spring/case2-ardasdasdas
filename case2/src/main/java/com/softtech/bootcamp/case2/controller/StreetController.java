package com.softtech.bootcamp.case2.controller;

import com.softtech.bootcamp.case2.dto.StreetDTO;
import com.softtech.bootcamp.case2.service.StreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/streets")
public class StreetController {

    private final StreetService streetService;

    @PostMapping
    public StreetDTO save(StreetDTO streetDTO){
        return streetService.save(streetDTO);
    }

    @PutMapping
    public StreetDTO update(StreetDTO streetDTO){
        return streetService.update(streetDTO);
    }

    @GetMapping("/search")
    public List<StreetDTO> findAllByNeighborhoodName(@RequestParam("neighborhoodName") String neighborhoodName){
        return streetService.findAllByNeighborhoodName(neighborhoodName);
    }

    @DeleteMapping("/{idList}")
    public void deleteAll(@PathVariable("idList") List<Long> idList){
        streetService.deleteAll(idList);
    }
}
