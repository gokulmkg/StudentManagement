package com.Student.Student.Management.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Student.Student.Management.Exception.StudentNotFoundException;
import com.Student.Student.Management.Repoistry.StudentRepo;
import com.Student.Student.Management.StudentEntity.StudentInformation;

@Service
public class StudentService {

	   @Autowired
	   StudentRepo studentrepo;
	 
	public List<StudentInformation> getAllStudent() {
	        return studentrepo.findAll();
	}

	public String AddnewStudent(StudentInformation student) {
		studentrepo.save(student);
		return "Student Added successfully the name of the Student is: " + student.getName() + " student id is: " + student.getId();
		}

	
	public StudentInformation updateStudentDetail(Long id, StudentInformation student) {
		StudentInformation   updateData =  studentrepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student is not found for this Id: " + student.getId()));    
		 updateData.setName(student.getName());
		 updateData.setEmail(student.getEmail());
		 updateData.setGender(student.getGender());
		 updateData.setAddress(student.getAddress());
		 updateData.setPhNo(student.getPhNo());
		
	          return studentrepo.save(updateData);
	}


	public StudentInformation getStudentById(Long id) {
		return studentrepo.findById(id).orElseThrow(() -> new StudentNotFoundException("User not found for this id: " + id));
	}

	public String deleteStuden(Long id) {
	 StudentInformation student =  studentrepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student is not found for this Id: " + id));
		studentrepo.delete(student);
		
		return "Student Succesfully Deleted ";
		 
	
	}

	

	

}
