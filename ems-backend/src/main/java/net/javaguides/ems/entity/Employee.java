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
@NoArgsConstructor
@AllArgsConstructor
@Entity //It specifies this class as a JPA entity and this class can be mapped to a database table.
@Table(name="employees") //If Not given takes class name as TABLE NAME
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")//To Specify Col Name
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id", nullable = false, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY) //Whenever we get a employee entity object from the database,
    // then hibernate won't load the dependent object, Immediately we can get this department object lazily or on demand
    @JoinColumn(name = "department_id")
    private  Department department;
}
//Then Run & check table created in MySQL