package com.softtech.bootcamp.case2.service;

import com.softtech.bootcamp.case2.converter.StreetMapper;
import com.softtech.bootcamp.case2.dto.StreetDTO;
import com.softtech.bootcamp.case2.enums.NotFoundErrorMessage;
import com.softtech.bootcamp.case2.exception.NotFoundException;
import com.softtech.bootcamp.case2.model.Street;
import com.softtech.bootcamp.case2.repository.StreetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StreetService {

    private final StreetRepository streetRepository;

    public StreetDTO save(StreetDTO streetDTO){
        Street street = StreetMapper.INSTANCE.toStreet(streetDTO);
        return StreetMapper.INSTANCE.fromStreet(streetRepository.save(street));
    }

    public StreetDTO update(StreetDTO streetDTO){
        Street street = StreetMapper.INSTANCE.toStreet(streetDTO);
        notFoundByIdControl(street.getId());
        return StreetMapper.INSTANCE.fromStreet(streetRepository.save(street));
    }

    public List<StreetDTO> findAllByNeighborhoodName(String neighborhoodName){
        return StreetMapper.INSTANCE.fromStreetList(streetRepository.findAllByNeighborhoodName(neighborhoodName));
    }

    @Transactional
    public void deleteAll(List<Long> idList){
        streetRepository.deleteAll(idList);
    }

    private void notFoundByIdControl(Long id){
        boolean isExistsById = streetRepository.existsById(id);
        if(!isExistsById) throw new NotFoundException(NotFoundErrorMessage.STREET_NOT_FOUND_ERROR_MESSAGE);
    }
}
