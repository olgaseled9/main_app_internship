package com.seledtsova.java.service.impl;

import com.seledtsova.java.dao.GenderDao;
import com.seledtsova.java.dto.GenderDTO;
import com.seledtsova.java.entity.Gender;
import com.seledtsova.java.entity.GenderType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GenderServiceImplTest {

    @Mock
    private GenderDao genderDao;
    @InjectMocks
    private GenderServiceImpl genderService;

    @Test
    void shouldFindEmptyListOfGenders() {
        List<Gender> genders = genderDao.findAll();
        assertTrue(genders.isEmpty());
    }

    @Test
    void shouldReturnGendersList() {
        GenderDTO genderDTO = new GenderDTO();
        genderDTO.setName(GenderType.FEMALE);
        Gender gender = new Gender();
        gender.setName(GenderType.FEMALE);
        when(genderDao.findAll()).thenReturn(Collections.singletonList(gender));
        List<GenderDTO> departments = genderService.findAll();
        assertEquals(departments.get(0).getName(), genderDTO.getName());
    }

}
