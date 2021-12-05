package com.xian.mapper;

import com.xian.pojo.Good;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GoodsMapper {
    @Select("select * from tbl_goods")
    List<Good> findAll();
}
