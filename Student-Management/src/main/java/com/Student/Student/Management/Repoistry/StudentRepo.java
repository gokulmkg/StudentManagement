package com.Student.Student.Management.Repoistry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Student.Student.Management.StudentEntity.StudentInformation;

public interface StudentRepo extends JpaRepository<StudentInformation, Long>{

}
