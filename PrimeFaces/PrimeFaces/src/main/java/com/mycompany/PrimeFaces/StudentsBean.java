/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.PrimeFaces;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


/**
 *
 * @author micha
 */
@Named(value = "studentsBean")
@RequestScoped
public class StudentsBean {
    
    private List<Student> students;

    /**
     * Creates a new instance of StudentsBean
     */
    public StudentsBean() {
        students = new ArrayList();
        students.add(new Student("Adam", "Snuszka", 4.55));
        students.add(new Student("Bartek", "Bodak", 4.33));
        students.add(new Student("Krzysztof", "Pol", 4.23));
        students.add(new Student("Natalia", "Sokołowska", 4.78));
        students.add(new Student("Ola", "Stróżyk", 4.46));
        students.add(new Student("Paulina", "Chodyła", 4.35));
        students.add(new Student("Rafał", "Wożniak", 3.84));
        students.add(new Student("Paweł", "Lewicki", 3.81));
        students.add(new Student("Kuba", "Januszewski", 4.11));
        students.add(new Student("Łukasz", "Opel", 3.78));
        students.add(new Student("Jan", "Dachtera", 4.87));
        students.add(new Student("Tomasz", "Kaczmarek", 3.92));
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    
    
}