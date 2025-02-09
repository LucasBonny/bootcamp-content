package com.devsuperior.bds01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.entities.Employee;
import com.devsuperior.bds01.repositories.DepartmentRepository;
import com.devsuperior.bds01.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private DepartmentRepository department;
	
	@Transactional
	public Page<EmployeeDTO> findAll(Pageable pageable) {
		PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(), Sort.by("name"));
		Page<Employee> list = repository.findAll(pageRequest);
		return list.map(EmployeeDTO::new);
	}

	@Transactional
	public EmployeeDTO insert(EmployeeDTO obj) {
		Employee entity = new Employee(obj, department.findById(obj.getDepartmentId()).get());
		entity = repository.save(entity);
		return new EmployeeDTO(entity);
	}
	
}
