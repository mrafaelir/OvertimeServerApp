package id.co.mii.overtimeserverapp.controllers;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.mii.overtimeserverapp.models.Employee;
import id.co.mii.overtimeserverapp.services.EmployeeService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
@PreAuthorize("hasRole('ADMIN')")
public class EmployeeController {
    
    private EmployeeService employeeService;

    //memastikan hanya pengguna yang memiliki otorisasi Sebagai "READ_ADMIN" yang dapat mengakses endpoint "/getAll"
    @PreAuthorize("hasAuthority('READ_ADMIN')")
    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    //memastikan hanya pengguna yang memiliki otorisasi Sebagai "READ_ADMIN" yang dapat mengakses endpoint "/getById/{id}"
    @PreAuthorize("hasAuthority('READ_ADMIN')")
    @GetMapping("/{id}")
    public Employee getById(@PathVariable Integer id) {
        return employeeService.getById(id);
    }

    //memastikan hanya pengguna yang memiliki otorisasi Sebagai "CREATE_ADMIN" yang dapat mengakses endpoint "/create"
    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    //memastikan hanya pengguna yang memiliki otorisasi Sebagai "UPDATE_ADMIN" yang dapat mengakses endpoint "/update/{id}"
    @PreAuthorize("hasAuthority('UPDATE_ADMIN')")
    @PutMapping("/{id}")
    public Employee update(
            @PathVariable Integer id,
            @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

    //memastikan hanya pengguna yang memiliki otorisasi Sebagai "DELETE_ADMIN" yang dapat mengakses endpoint "/delete/{id}"
    @PreAuthorize("hasAuthority('DELETE_ADMIN')")
    @DeleteMapping("/{id}")
    public Employee delete(@PathVariable Integer id) {
        return employeeService.delete(id);
    }
}
