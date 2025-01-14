package com.behzad.hasani.springboot.toolkit.aerospike.repositories;


import com.behzad.hasani.springboot.toolkit.aerospike.entities.EmployeeEntity;
import org.springframework.data.aerospike.repository.AerospikeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends AerospikeRepository<EmployeeEntity, String>  {
    Optional<List<EmployeeEntity>> findByLastName(String lastName);
    Optional<List<EmployeeEntity>> findByFirstName(String name);
}

