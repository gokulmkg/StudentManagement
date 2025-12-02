package com.Student.Student.Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.Student.Student.Management.Service.StudentService;
import com.Student.Student.Management.StudentEntity.StudentInformation;

@RestController
@RequestMapping("/api/students")
public class StudentController {
 
	 @Autowired
	StudentService studentservive;
	 
	 @GetMapping
	 public List<StudentInformation> getAllStudent() {
		 
		 return studentservive.getAllStudent();
      }
	 
	 @PostMapping
	 public String addNewStudent(@RequestBody StudentInformation student) {
		 return studentservive.AddnewStudent(student);
	 }
	 
	 @PutMapping("/{id}")
	 public StudentInformation updateStudent(@PathVariable Long id,@RequestBody StudentInformation student) {
		 return studentservive.updateStudentDetail(id,student);
	 }
	 
	 @GetMapping("/{id}")
	 public StudentInformation getStudentById(@PathVariable Long id) {
	   return studentservive.getStudentById(id);
	 }
	 
	 @DeleteMapping("/{id}")
	 public String deleiteStudentById(@PathVariable Long id) {
		 return studentservive.deleteStuden(id);
	 }
}
