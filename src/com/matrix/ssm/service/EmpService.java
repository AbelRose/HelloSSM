package com.matrix.ssm.service;

import com.matrix.ssm.bean.Dept;
import com.matrix.ssm.bean.Emp;

import java.util.List;

public interface EmpService {

    List<Emp> getAllEmp();

    Emp getEmpByEid(String eid);

    void updateEmp(Emp emp);

    List<Dept> getAllDept();
}
