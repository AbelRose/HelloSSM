package com.matrix.ssm.service.impl;

import com.matrix.ssm.bean.Dept;
import com.matrix.ssm.bean.Emp;
import com.matrix.ssm.mapper.DeptMapper;
import com.matrix.ssm.mapper.EmpMapper;
import com.matrix.ssm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Emp> getAllEmp() {
        return empMapper.getAllEmp();
    }

    @Override
    public Emp getEmpByEid(String eid) {
        return empMapper.getEmpByEid(eid);
    }

    @Override
    public void updateEmp(Emp emp) {
        empMapper.updateEmp(emp);
    }

    @Override
    public List<Dept> getAllDept() {
        return deptMapper.getAllDept();
    }
}
