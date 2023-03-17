package com.halemia.familymanager.service;

import com.halemia.familymanager.dao.pojo.Item;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/2/12 23:45
 */
@Service
public interface ItemService {

    Item getItemById(Long id);

    Long insert(Item item);

    boolean update(Item item);

    boolean delete(Long id);

    List<Item> getList();

}
