package com.halemia.familymanager.service;

import com.halemia.familymanager.dao.pojo.Family;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/2/12 23:45
 */
@Service
public interface FamilyService {

    Family getFamilyById(Long id);

    Long insert(Family family);

    boolean update(Family family);

    boolean delete(Long id);

    List<Family> getList();

    String invite();

    boolean join(String code);

}
