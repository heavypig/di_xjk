package com.ruoyi.project.swagger.mapper;

import com.ruoyi.project.swagger.domain.Subject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SubjectMapper {

    List<Subject> getSubject();
}
