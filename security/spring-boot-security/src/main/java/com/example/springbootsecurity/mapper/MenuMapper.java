package com.example.springbootsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootsecurity.domain.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhoukai
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectPermByUserId(@Param("userId") Long userId);
}
