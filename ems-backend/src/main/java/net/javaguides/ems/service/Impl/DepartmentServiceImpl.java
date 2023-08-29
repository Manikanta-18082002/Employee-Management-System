package net.javaguides.ems.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.entity.Department;
import net.javaguides.ems.exception.ResourceNotFoundException;
import net.javaguides.ems.mapper.DepartmentMapper;
import net.javaguides.ems.repository.DepartmentRepository;
import net.javaguides.ems.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //This will automatically create a spring bean for this department service class.
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    // inject department repository using constructor based dependency injection.
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapToDepartment(departmentDto); //Now, we have department entity Obj

        //And this savedDepartment basically contains the primary key
        Department savedDepartment = departmentRepository.save(department); //To save this department entity obj

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
     Department department = departmentRepository.findById(departmentId).orElseThrow(
             () ->new ResourceNotFoundException("Department Not exist with given id: " +departmentId));
        return DepartmentMapper.mapToDepartmentDto(department); //converting department entity object into department object.
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments= departmentRepository.findAll();
        return departments.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {

        Department department= departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is Not exist with a given id: " + departmentId)
        );

        department.setDepartmentName(updatedDepartment.getDepartmentName());
        department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());

        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {

        departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exist with given id: " +departmentId)
        );
        departmentRepository.deleteById(departmentId);
    }
}
