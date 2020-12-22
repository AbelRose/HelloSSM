package com.matrix.ssm.mapper;

import java.util.List;

import com.matrix.ssm.bean.Dept;

public interface DeptMapper {

	//获取所有的部门信息
	List<Dept> getAllDept();
	
}
