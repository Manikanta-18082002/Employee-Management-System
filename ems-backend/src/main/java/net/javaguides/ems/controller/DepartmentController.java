package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.service.DepartmentService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") //It means all the clients can able to call the rest APIs from this department controller class.
@AllArgsConstructor
@RestController //This controller class becomes a spring MVC controller and it is capable to handle Http request.

//So instead of specifying this same common URL for all the rest APIs we can define in a common place
@RequestMapping("/api/departments") //we need to define the base URL for all the rest APIs that we are going to define within this department controller.
public class DepartmentController {

    private DepartmentService departmentService;

    //Build Create or Add Department REST API
    @PostMapping // to map the incoming http post request to this method
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto department =departmentService.createDepartment(departmentDto);
        return  new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    //Build Get Department REST API
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId){
        DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentDto);
    }

    @GetMapping
    public  ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        List<DepartmentDto> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId,
                                                          @RequestBody DepartmentDto updateDepartment){
        DepartmentDto departmentDto = departmentService.updateDepartment(departmentId, updateDepartment);
        return  ResponseEntity.ok(departmentDto);
    }

    //Build Delete Department REST API
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return  ResponseEntity.ok("Department deleted Successfully :)");
    }

}
