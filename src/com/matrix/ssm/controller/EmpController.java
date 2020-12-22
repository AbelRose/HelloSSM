package com.matrix.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.matrix.ssm.bean.Dept;
import com.matrix.ssm.bean.Emp;
import com.matrix.ssm.service.EmpService;
import com.matrix.ssm.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmpController {

    @Autowired
    private EmpService service;

    @RequestMapping(value="/emps/{pageNum}", method= RequestMethod.GET)
    public String getAllEmp(Map<String, Object> map, @PathVariable("pageNum")Integer pageNum, HttpServletRequest request) {
        //通过PageHelper设置页面信息，第一个参数为页数，第二个参数为每页显示的条数
        PageHelper.startPage(pageNum, 4);
        List<Emp> empList = service.getAllEmp();
        //PageInfo中封装了分页相关的所有信息，当前页的页数，上一页的页数，下一页的页数，总页数，总条数...
        PageInfo<Emp> pageInfo = new PageInfo<>(empList, 5);
        String page = PageUtil.getPageInfo(pageInfo, request);
        map.put("empList", empList);
        map.put("page", page);
        return "list";
    }

    @RequestMapping(value="/emp/{eid}", method=RequestMethod.GET)
    public String toUpdate(@PathVariable("eid") String eid, Map<String, Object> map) {
        //要修改的员工信息
        Emp emp = service.getEmpByEid(eid);
        //所有的部门信息
        List<Dept> deptList = service.getAllDept();
        //获取存储性别的map
        Map<String, String> sex = new HashMap<>();
        sex.put("0", "女");
        sex.put("1", "男");

        map.put("emp", emp);
        map.put("deptList", deptList);
        map.put("sex", sex);

        return "update";
    }

    @RequestMapping(value="/emp", method=RequestMethod.PUT)
    public String updateEmp(Emp emp) {
        service.updateEmp(emp);
        return "redirect:/emps/1";
    }

    @RequestMapping(value="/emps", method=RequestMethod.DELETE)
    public String deleteMore(String[] eid) {
        //获取客户端name属性相同的多个元素的值，可以通过字符串字节或去，每个值中间以逗号分隔，也可以以数组直接获取
        System.out.println(Arrays.toString(eid));

        return "";
    }

}
