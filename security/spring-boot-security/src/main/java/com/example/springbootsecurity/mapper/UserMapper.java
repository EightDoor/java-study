package com.example.springbootsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootsecurity.domain.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author zhoukai
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
