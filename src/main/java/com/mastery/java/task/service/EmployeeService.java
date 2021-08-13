package com.mastery.java.task.service;


import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class EmployeeService {


    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    public List<Employee> findAll() {
        return new ArrayList<>(employeeDao.findAll());
    }


    public void deleteById(Long id) {
        boolean isExists = employeeDao.existsById(id);
        if (isExists)
            employeeDao.deleteById(id);
    }

    public Optional<Employee> findById(Long id) {
        return employeeDao.findById(id);
    }

    public List<Employee> SearchById(Long id) {
        ArrayList<Employee> result = new ArrayList<>();
        employeeDao.findById(id).ifPresent(result::add);
        return result;
    }

    public boolean edit(Map<String, String> params) {
        if (params.isEmpty()) {
            return false;
        }
        try {
            Employee employee;
            if (params.get("id") != null || validId(params.get("id")) || !findById(Long.parseLong(params.get("id"))).isEmpty()) {
                try {
                    employee = findById(Long.parseLong(params.get("id"))).get();
                } catch (Exception e) {
                    employee = new Employee();
                }
            } else {
                employee = new Employee();
            }
            if (!params.get("firstName").isEmpty())
                employee.setFirstName(params.getOrDefault("firstName", employee.getFirstName()));
            if (!params.get("lastName").isEmpty())
                employee.setLastName(params.getOrDefault("lastName", employee.getLastName()));
            try {
                Long departmentId = Long.parseLong(params.get("departmentId"));
                employee.setDepartmentId(departmentId);
            } catch (NumberFormatException ignored) {

            }
            if (!params.get("jobTitle").isEmpty())
                employee.setJobTitle(params.getOrDefault("jobTitle", employee.getJobTitle()));
            try {
                Gender gender = Gender.valueOf(params.get("gender"));
                employee.setGender(gender);
            } catch (IllegalArgumentException ignored) {
            }
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(params.get("dataOfBirth"));
                employee.setDataOfBirth(date);
            } catch (ParseException ignored) {
            }
            if (chekZeroFields(employee)) {
                employeeDao.save(employee);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public boolean chekZeroFields(Employee employee) {
        return employee.getFirstName() != null && !employee.getFirstName().isEmpty() &&
                employee.getJobTitle() != null && !employee.getJobTitle().isEmpty() &&
                employee.getLastName() != null && !employee.getLastName().isEmpty() &&
                employee.getGender() != null &&
                employee.getDataOfBirth() != null &&
                employee.getDepartmentId() != null;
    }

    public boolean validId(String id) {
        try {
            Long.parseLong(id);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
