package com.halemia.familymanager.service;

import com.halemia.familymanager.dao.pojo.Position;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/2/12 23:45
 */
@Service
public interface PositionService {

    Position getPositionById(Long id);

    Long insert(Position position);

    boolean update(Position position);

    boolean delete(Long id);

}
