package com.example.Asm.service;

import com.example.Asm.config.HibernateConfig;
import com.example.Asm.convert.ConvertEntity;
import com.example.Asm.entity.Employee;
import com.example.Asm.repository.EmployeeRepository;
import com.example.Asm.request.EmployeeRequest;
import com.example.Asm.response.EmployeeResponse;
import org.hibernate.Session;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private final EmployeeRepository repository = new EmployeeRepository();
    private final ConvertEntity convert = new ConvertEntity();

    public List<EmployeeResponse> getAll() {
        List<EmployeeResponse> responses = new ArrayList<>();
        List<Employee> employees = repository.getAll();
        for (Employee employee : employees) {
            responses.add(convert.convertEmployeeToEmployeeResponse(employee));
        }
        return responses;
    }

    public EmployeeResponse getOne(int id) {
        EmployeeResponse response = convert.convertEmployeeToEmployeeResponse(repository.getOne(id));
        return response;
    }

    public void create(EmployeeRequest request) throws ParseException {
        Employee employee = convert.convertEmployeeRequestToEmployee(request);
        repository.create(employee);
    }

    public void update(EmployeeRequest request) throws ParseException {
        Employee employee = convert.convertEmployeeRequestToEmployee(request);
        repository.update(employee);
    }

    public void updateEmployeeRoleById(int id, int newRole) {
        repository.updateEmployeeRoleById(id, newRole);
    }

    public void delete(int id) {
        repository.delete(Employee.builder().id(id).build());
    }

    public Integer login(String code, String pass) {
        Session session = HibernateConfig.getFACTORY().openSession();
        ;
        Employee result = (Employee) session.createQuery("from Employee e where  e.code =:code and e.password=:pass").setParameter("code", code).setParameter("pass", pass).getSingleResult();
        return result.getPosition().getId();

    }
}
