package com.springboot.springbootstrater.service;

import com.springboot.springbootstrater.entity.Department;
import com.springboot.springbootstrater.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> getDepartmentList();

    public Department getDepartmentById(Long id) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long id);

    public Department updateDepartment(Department department, Long id);
}
