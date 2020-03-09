package com.smart.controller;

import com.smart.dao.DepartmentDao;
import com.smart.dao.EmployeeDao;
import com.smart.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class EmployeeController {
    private EmployeeDao employeeDao;
    private DepartmentDao departmentDao;

    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Autowired
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @GetMapping(value = "/emps")
    public String employeeList(Map<String,Object> map) {
        map.put("employees", employeeDao.getAll());
        // classpath:templates/emp/xxx.html
        return "emp/list";
    }

    // 转向添加页面
    @GetMapping(value = "/emp")
    public String toAddPage(Map<String,Object> map) {
        // 查出所有的部门
        map.put("departments",departmentDao.getDepartments());
        return "emp/input";
    }

    @PostMapping(value = "/emp")
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @PutMapping(value = "/emp")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping(value = "/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    // 查出目标员工，转向编辑页面，在页面进行回显
    @GetMapping(value = "/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Map<String,Object> map){
        map.put("emp",employeeDao.get(id));
        map.put("departments",departmentDao.getDepartments());
        return "emp/input";
    }
}
