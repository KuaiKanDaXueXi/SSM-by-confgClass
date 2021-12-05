package com.xian.service;

import com.xian.pojo.Good;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsService {
    List<Good> findAll();
}
