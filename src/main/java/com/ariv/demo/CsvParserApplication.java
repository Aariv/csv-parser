package com.ariv.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ariv.demo.domain.Category;
import com.ariv.demo.domain.Problem;
import com.ariv.demo.dto.ProblemDto;
import com.ariv.demo.repository.CategoryRepository;
import com.ariv.demo.repository.ProblemRepository;
import com.ariv.demo.repository.SolutionRepository;
import com.ariv.demo.utils.CsvParser;

@SpringBootApplication
public class CsvParserApplication implements CommandLineRunner {
	
	@Autowired
	private ProblemRepository problemRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private SolutionRepository solutionRepository;

	public static void main(String[] args) {
		SpringApplication.run(CsvParserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<ProblemDto> problems = CsvParser.convertCsvToBean("/home/kloudone/Downloads/Problem.csv");
		
		for (ProblemDto problemDto : problems) {
			Problem problem = problemRepository.findByProblem(problemDto.getProblem());
			if(problem == null) {
				problem = new Problem(problemDto.getProblem());
				problemRepository.save(problem);
			}
			
			Category category = categoryRepository.findByCategory(problemDto.getCategory());
			if(category == null) {
				category = new Category(problemDto.getCategory);
				categoryRepository.save(category);
			}
		}
	}

}

