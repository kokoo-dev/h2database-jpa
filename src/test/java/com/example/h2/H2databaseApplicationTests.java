package com.example.h2;

import com.example.h2.domain.exam.Exam;
import com.example.h2.domain.exam.ExamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class H2databaseApplicationTests {

	@Autowired
	ExamRepository examRepository;

	@Test
	void testH2Jpa() {
		System.out.println("start!!");

		List<Exam> insertDatas = new ArrayList<>();
		for(int i=0; i<10; i++){
			Exam exam = new Exam();
			exam.setExamName("test_data_" + i);
			insertDatas.add(exam);
		}

		examRepository.saveAll(insertDatas);

		List<Exam> examList = examRepository.findAll();
		examList.stream().forEach(d -> {
			System.out.println(d.getExamSeq() + " " + d.getExamName() + " " + d.getExamDate());
		});

		examRepository.deleteAll();

		long count = examRepository.count();
		System.out.println("count:: " + count);

		System.out.println("end!!");
	}

}
