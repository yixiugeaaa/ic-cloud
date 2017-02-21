package com.iot.dao;

import com.iot.model.CourseUserKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseUserMapper {
    int deleteByPrimaryKey(CourseUserKey key);

    int insert(CourseUserKey record);

    int insertSelective(CourseUserKey record);
}