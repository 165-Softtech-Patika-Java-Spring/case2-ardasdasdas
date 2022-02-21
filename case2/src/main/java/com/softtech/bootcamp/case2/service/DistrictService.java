package com.softtech.bootcamp.case2.service;

import com.softtech.bootcamp.case2.converter.DistrictMapper;
import com.softtech.bootcamp.case2.dto.DistrictDTO;
import com.softtech.bootcamp.case2.enums.NotFoundErrorMessage;
import com.softtech.bootcamp.case2.exception.NotFoundException;
import com.softtech.bootcamp.case2.model.District;
import com.softtech.bootcamp.case2.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictService {

    private final DistrictRepository districtRepository;

    public DistrictDTO save(DistrictDTO districtDTO){
        District district = DistrictMapper.INSTANCE.toDistrict(districtDTO);
        return DistrictMapper.INSTANCE.fromDistrict(districtRepository.save(district));
    }

    public DistrictDTO update(DistrictDTO districtDTO){
        District district = DistrictMapper.INSTANCE.toDistrict(districtDTO);
        notFoundByIdControl(district.getId());
        return DistrictMapper.INSTANCE.fromDistrict(districtRepository.save(district));
    }

    public List<DistrictDTO> findAllByCityName(String cityName){
        return DistrictMapper.INSTANCE.fromDistrictList(districtRepository.findAllByCityName(cityName));
    }

    @Transactional
    public void deleteAll(List<Long> idList){
        districtRepository.deleteAll(idList);
    }

    private void notFoundByIdControl(Long id){
        boolean isExistsById = districtRepository.existsById(id);
        if(!isExistsById) throw new NotFoundException(NotFoundErrorMessage.DISTRICT_NOT_FOUND_ERROR_MESSAGE);
    }
}
