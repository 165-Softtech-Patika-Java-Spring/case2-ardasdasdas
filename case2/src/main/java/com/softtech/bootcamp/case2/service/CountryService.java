package com.softtech.bootcamp.case2.service;

import com.softtech.bootcamp.case2.converter.CountryMapper;
import com.softtech.bootcamp.case2.dto.CountryDTO;
import com.softtech.bootcamp.case2.enums.DuplicateErrorMessage;
import com.softtech.bootcamp.case2.enums.NotFoundErrorMessage;
import com.softtech.bootcamp.case2.exception.DuplicateException;
import com.softtech.bootcamp.case2.exception.NotFoundException;
import com.softtech.bootcamp.case2.model.Country;
import com.softtech.bootcamp.case2.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryDTO save(CountryDTO countryDTO){
        Country country = CountryMapper.INSTANCE.toCountry(countryDTO);

        duplicateCountryCodeControl(country.getCode());

        return CountryMapper.INSTANCE.fromCountry(countryRepository.save(country));
    }

    public CountryDTO update(CountryDTO countryDTO){
        Country country = CountryMapper.INSTANCE.toCountry(countryDTO);

        duplicateCountryCodeControl(country.getCode());
        notFoundByIdControl(country.getId());

        return CountryMapper.INSTANCE.fromCountry(countryRepository.save(country));
    }

    public CountryDTO findByCode(String code){
        return CountryMapper.INSTANCE.fromCountry(findByCodeOrElseThrowNotFoundException(code));
    }

    @Transactional
    public void deleteAll(List<Long> idList){
        countryRepository.deleteAll(idList);
    }

    private void duplicateCountryCodeControl(String code){
        boolean isExistsByCode = countryRepository.existsByCode(code);
        if(isExistsByCode) throw new DuplicateException(DuplicateErrorMessage.COUNTRY_CODE_DUPLICATE_ERROR_MESSAGE);
    }

    private void notFoundByIdControl(Long id){
        boolean isExistsById = countryRepository.existsById(id);
        if(!isExistsById) throw new NotFoundException(NotFoundErrorMessage.COUNTRY_NOT_FOUND_ERROR_MESSAGE);
    }

    private Country findByCodeOrElseThrowNotFoundException(String code){
        return countryRepository.findByCode(code).orElseThrow(() -> new NotFoundException(NotFoundErrorMessage.COUNTRY_NOT_FOUND_ERROR_MESSAGE));
    }
}
