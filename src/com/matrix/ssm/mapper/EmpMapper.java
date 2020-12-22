package com.matrix.ssm.mapper;

import com.matrix.ssm.bean.Emp;

import java.util.List;

public interface EmpMapper {

    //获取所有的员工信息
    List<Emp> getAllEmp();

    //根据eid获取员工信息
    Emp getEmpByEid(String eid);

    //修改员工信息
    void updateEmp(Emp emp);

}
