package com.epam.rd.autotasks.springemployeecatalog.controller;

import com.epam.rd.autotasks.springemployeecatalog.domain.Employee;
import com.epam.rd.autotasks.springemployeecatalog.domain.Paging;
import com.epam.rd.autotasks.springemployeecatalog.service.implemployeeservice.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @GetMapping("")
    public List<Employee> getAllEmployees(@RequestParam(value = "page", required = false) String page,
                                          @RequestParam(value = "size", required = false) String size,
                                          @RequestParam(value = "sort", required = false) String sort) {
        if (page == null) {
            return employeeService.getAll();
        }
        Paging paging = new Paging(Integer.valueOf(page), Integer.valueOf(size));

        return chooseSortForAll(sort, paging);

    }

    private List<Employee> chooseSortForAll(String sort, Paging paging) {

        switch (sort) {
            case "lastName":
                return employeeService.getAllSortBySurname(paging);
            case "hired":
                return employeeService.getAllSortByHireDate(paging);
            case "position":
                return employeeService.getAllSortByPosition(paging);
            case "salary":
                return employeeService.getAllSortBySalary(paging);

            default:
                throw new IllegalArgumentException("A non-existent sorting was obtained!");
        }
    }

    @GetMapping("/{employee_id}")
    public Employee getEmployeeById(@PathVariable("employee_id") Long employeeId,
                                    @RequestParam(value = "full_chain", defaultValue = "false") Boolean isFullChain) {
        if (isFullChain) {
            return employeeService.getByIdWithFullChain(employeeId);
        } else {
            return employeeService.getById(employeeId);
        }
    }

    @GetMapping("/by_manager/{manager_id}")
    public List<Employee> getEmployeesByManager(@PathVariable("manager_id") Long managerId,
                                                @RequestParam("page") String page,
                                                @RequestParam("size") String size,
                                                @RequestParam("sort") String sort) {
        Paging paging = new Paging(Integer.valueOf(page), Integer.valueOf(size));

        return chooseSortForManager(sort, managerId, paging);
    }

    private List<Employee> chooseSortForManager(String sort, Long managerId, Paging paging) {
        switch (sort) {
            case "lastName":
                return employeeService.getByManagerSortBySurname(managerId, paging);
            case "hired":
                return employeeService.getByManagerSortByHireDate(managerId, paging);
            case "position":
                return employeeService.getByManagerSortByPosition(managerId, paging);
            case "salary":
                return employeeService.getByManagerSortBySalary(managerId, paging);

            default:
                throw new IllegalArgumentException("A non-existent sorting was obtained!");
        }
    }

    @GetMapping("/by_department/{department}")
    public List<Employee> getEmployeesByDepartment(@PathVariable("department") String department,
                                                   @RequestParam("page") String page,
                                                   @RequestParam("size") String size,
                                                   @RequestParam("sort") String sort) {
        Paging paging = new Paging(Integer.valueOf(page), Integer.valueOf(size));

        return chooseSortForDepartment(sort, department, paging);
    }

    private List<Employee> chooseSortForDepartment(String sort, String department, Paging paging) {
        switch (sort) {
            case "lastName":
                return employeeService.getByDepartmentSortBySurname(department, paging);
            case "hired":
                return employeeService.getByDepartmentSortByHireDate(department, paging);
            case "position":
                return employeeService.getByDepartmentSortByPosition(department, paging);
            case "salary":
                return employeeService.getByDepartmentSortBySalary(department, paging);

            default:
                throw new IllegalArgumentException("A non-existent sorting was obtained!");
        }
    }
}
