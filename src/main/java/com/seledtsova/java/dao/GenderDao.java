
package com.seledtsova.java.dao;

import com.seledtsova.java.entity.Gender;
import com.seledtsova.java.entity.GenderType;

public interface GenderDao extends GenericDao<Long, Gender> {

    Gender findGenderByName(GenderType genderType);
}