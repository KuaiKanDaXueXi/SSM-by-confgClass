package com.xian.service.Impl;

import com.xian.mapper.GoodsMapper;
import com.xian.pojo.Good;
import com.xian.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Xian
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<Good> findAll() {
        return goodsMapper.findAll();
    }
}
