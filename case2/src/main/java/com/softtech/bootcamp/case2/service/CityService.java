package com.softtech.bootcamp.case2.service;

import com.softtech.bootcamp.case2.converter.CityMapper;
import com.softtech.bootcamp.case2.dto.CityDTO;
import com.softtech.bootcamp.case2.enums.DuplicateErrorMessage;
import com.softtech.bootcamp.case2.enums.NotFoundErrorMessage;
import com.softtech.bootcamp.case2.exception.DuplicateException;
import com.softtech.bootcamp.case2.exception.NotFoundException;
import com.softtech.bootcamp.case2.model.City;
import com.softtech.bootcamp.case2.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public CityDTO save(CityDTO cityDTO){
        City city = CityMapper.INSTANCE.toCity(cityDTO);

        duplicateCityPlateNoControl(city.getPlateNo());

        return CityMapper.INSTANCE.fromCity(cityRepository.save(city));
    }

    public CityDTO update(CityDTO cityDTO){
        City city = CityMapper.INSTANCE.toCity(cityDTO);

        duplicateCityPlateNoControl(city.getPlateNo());
        notFoundByIdControl(city.getId());

        return CityMapper.INSTANCE.fromCity(cityRepository.save(city));
    }

    public CityDTO findByPlateNo(String plateNo){
        return CityMapper.INSTANCE.fromCity(findByPlateNoOrElseThrowNotFoundException(plateNo));
    }

    @Transactional
    public void deleteAll(List<Long> idList){
        cityRepository.deleteAll(idList);
    }

    private void duplicateCityPlateNoControl(String plateNo){
        boolean isExistsByPlateNo = cityRepository.existsByPlateNo(plateNo);
        if(isExistsByPlateNo) throw new DuplicateException(DuplicateErrorMessage.PLATE_NO_DUPLICATE_ERROR_MESSAGE);
    }

    private void notFoundByIdControl(Long id){
        boolean isExistsById = cityRepository.existsById(id);
        if(!isExistsById) throw new NotFoundException(NotFoundErrorMessage.CITY_NOT_FOUND_ERROR_MESSAGE);
    }

    private City findByPlateNoOrElseThrowNotFoundException(String plateNo){
        return cityRepository.findByPlateNo(plateNo).orElseThrow(() -> new NotFoundException(NotFoundErrorMessage.CITY_NOT_FOUND_ERROR_MESSAGE));
    }

}
