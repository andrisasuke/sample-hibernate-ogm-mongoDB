package com.andri.hibernate.sample;

import com.andri.hibernate.sample.persistence.dao.EmployeeDao;
import com.andri.hibernate.sample.persistence.domain.Employee;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by andri.khrisharyadi@gmail.com
 * on 6/16/14.
 */
public class EmployeeDaoTest {

    private EmployeeDao employeeDao = new EmployeeDao();

    @Test
    public void testInsert(){

        Employee employeeFirst = new Employee();
        employeeFirst.setFirstname("Andri");
        employeeFirst.setLastname("Sasuke");
        employeeFirst.setPhone("0817777");

        Employee employeeSecond = new Employee();
        employeeSecond.setFirstname("Budi");
        employeeSecond.setLastname("Ini");
        employeeSecond.setPhone("081888");

        //employeeDao.save(employeeFirst);
        employeeDao.save(employeeSecond);

        //Assert.assertTrue(employeeFirst.getId()!=null && employeeSecond.getId()!=null);

    }

}
