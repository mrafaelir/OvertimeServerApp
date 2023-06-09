package id.co.mii.overtimeserverapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.co.mii.overtimeserverapp.models.Employee;
import id.co.mii.overtimeserverapp.models.Reimburse;

@Repository
public interface ReimburseRepository extends JpaRepository<Reimburse, Integer>{
    List<Reimburse> findByEmployee(Employee employee);
}

//digunakan untuk mengelola akses dan Pemrosesan data reimburse ke dalam basis data.
//bertanggung jawab menyediakan antarmuka yang memungkinkan melakukan CRUD.