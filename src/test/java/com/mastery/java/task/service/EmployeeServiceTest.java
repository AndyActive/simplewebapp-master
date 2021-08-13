package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.HashMap;
import java.util.Map;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeServiceTest {
    Map<String,String> paramsBad= Map.of(
            "firstName", "Андрей",
            "lastName", "Лихтарович",
            "departmentId", "BAD",
            "jobTitle", "junior",
            "gender", "MALE",
            "dataOfBirth", "19970707"
    );

    Map<String,String> paramsOk= Map.of(
            "firstName", "Андрей",
            "lastName", "Лихтарович",
            "departmentId", "15",
            "jobTitle", "junior",
            "gender", "MALE",
            "dataOfBirth", "1997-07-07"
    );
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void edit() throws Exception {
      EmployeeService employeeService = new EmployeeService(employeeDao);

        Assert.assertEquals(false, employeeService.edit(paramsBad));
        Assert.assertEquals(false, employeeService.edit(paramsOk));
    }
}
