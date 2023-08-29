package net.javaguides.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//To create a Table in MySQL
//Below are lombok Annotations to create below @
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity //It specifies this class as a JPA entity and this class can be mapped to a database table.
@Table (name="departments") //If Not given takes class name as TABLE NAME
public class Department {
    @Id    //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_name") //To Specify Col Name
    private String departmentName;

    @Column(name = "department_description")
    private String departmentDescription;
}
//Then Run & check table created in MySQL
