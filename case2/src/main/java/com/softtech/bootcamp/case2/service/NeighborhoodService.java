package com.softtech.bootcamp.case2.service;

import com.softtech.bootcamp.case2.converter.NeighborhoodMapper;
import com.softtech.bootcamp.case2.dto.NeighborhoodDTO;
import com.softtech.bootcamp.case2.enums.NotFoundErrorMessage;
import com.softtech.bootcamp.case2.exception.NotFoundException;
import com.softtech.bootcamp.case2.model.Neighborhood;
import com.softtech.bootcamp.case2.repository.NeighborhoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NeighborhoodService {

    private final NeighborhoodRepository neighborhoodRepository;

    public NeighborhoodDTO save(NeighborhoodDTO neighborhoodDTO){
        Neighborhood neighborhood = NeighborhoodMapper.INSTANCE.toNeighborhood(neighborhoodDTO);
        return NeighborhoodMapper.INSTANCE.fromNeighborhood(neighborhoodRepository.save(neighborhood));
    }

    public NeighborhoodDTO update(NeighborhoodDTO neighborhoodDTO){
        Neighborhood neighborhood = NeighborhoodMapper.INSTANCE.toNeighborhood(neighborhoodDTO);

        notFoundByIdControl(neighborhood.getId());

        return NeighborhoodMapper.INSTANCE.fromNeighborhood(neighborhoodRepository.save(neighborhood));
    }

    public List<NeighborhoodDTO> findAllByDistrictName(String districtName){
        return NeighborhoodMapper.INSTANCE.fromNeighborhoodList(neighborhoodRepository.findAllByDistrictName(districtName));
    }

    @Transactional
    public void deleteAll(List<Long> idList){
        neighborhoodRepository.deleteAll(idList);
    }

    private void notFoundByIdControl(Long id){
        boolean isExistsById = neighborhoodRepository.existsById(id);
        if(!isExistsById) throw new NotFoundException(NotFoundErrorMessage.NEIGHBORHOOD_NOT_FOUND_ERROR_MESSAGE);
    }
}
