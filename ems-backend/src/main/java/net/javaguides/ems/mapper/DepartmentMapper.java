package net.javaguides.ems.mapper;

import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.entity.Department;

public class DepartmentMapper {

    //TO Convert Department JPA Entity into department Dto
    public static DepartmentDto mapToDepartmentDto(Department department){
        return  new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
    }

    //TO Convert Department DTO into department JPA Entity
    public static Department mapToDepartment(DepartmentDto departmentDto){
        return  new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
        );
    }
}
