package com.springboot.springbootstrater.service;

import com.springboot.springbootstrater.entity.Department;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> getDepartmentList();

    public Department getDepartmentById(Long id);

    public void deleteDepartmentById(Long id);
}
