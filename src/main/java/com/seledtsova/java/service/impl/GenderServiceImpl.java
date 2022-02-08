package com.seledtsova.java.service.impl;

import com.seledtsova.java.dao.GenderDao;
import com.seledtsova.java.dto.GenderDTO;
import com.seledtsova.java.entity.Gender;
import com.seledtsova.java.service.GenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GenderServiceImpl implements GenderService {

    private final GenderDao genderDao;

    @Override
    @Transactional
    public List<GenderDTO> findAll() {
        List<Gender> genders = genderDao.findAll();
        List<GenderDTO> genderDTOS = new ArrayList<>();
        for (Gender gender : genders) {
            genderDTOS.add(convertGenderToDTO(gender));
        }
        return genderDTOS;
    }

    private GenderDTO convertGenderToDTO(Gender gender) {
        GenderDTO genderDTO = new GenderDTO();
        genderDTO.setName(gender.getName());
        return genderDTO;
    }
}

