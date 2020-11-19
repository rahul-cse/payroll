package com.rahul.ibcsprimax.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rahul.ibcsprimax.entity.Grade;
import com.rahul.ibcsprimax.repository.GradeRepository;

@Component
public class GradeSetup implements CommandLineRunner{

	@Autowired
	GradeRepository gradeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*List<Grade> gradeList = new ArrayList<Grade>();
		
		setGradeList(new Grade(1,"Grade One"),gradeList);
		setGradeList(new Grade(2,"Grade Two"),gradeList);
		setGradeList(new Grade(3,"Grade Three"),gradeList);
		setGradeList(new Grade(4,"Grade Four"),gradeList);
		setGradeList(new Grade(5,"Grade Five"),gradeList);
		setGradeList(new Grade(6,"Grade Six"),gradeList);
		
		gradeRepository.saveAll(gradeList);*/
	}
	
	public void setGradeList(Grade grade, List<Grade> gradeList) {
		gradeList.add(grade);
	}

}
