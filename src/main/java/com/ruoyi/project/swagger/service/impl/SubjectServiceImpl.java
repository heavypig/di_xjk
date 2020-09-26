package com.ruoyi.project.swagger.service.impl;

import com.ruoyi.project.swagger.domain.Subject;
import com.ruoyi.project.swagger.mapper.SubjectMapper;
import com.ruoyi.project.swagger.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<Subject> getSubject() {

        return subjectMapper.getSubject();
    }
}
