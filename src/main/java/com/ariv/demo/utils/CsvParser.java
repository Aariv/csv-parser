/**
 * 
 */
package com.ariv.demo.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ariv.demo.dto.ProblemDto;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

/**
 * @author kloudone
 *
 */
@Component
public class CsvParser {

	public static void main(String[] args) throws FileNotFoundException {
		List<ProblemDto> problems = convertCsvToBean("/home/kloudone/Downloads/Problem.csv");
		//singleLevelGrouping(problems);
		//twoLevelGrouping(problems);
		int i = 0;
		for (ProblemDto problemDto : problems) {
			System.out.println(" :"+ i++ +""+problemDto.toString());
			if(problemDto.getProblem() != null) {

			}
		}
	}

	@SuppressWarnings("deprecation")
	public static List<ProblemDto> convertCsvToBean(String path) throws FileNotFoundException {

		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("problem", "problem");
		mapping.put("categories", "categories");
		mapping.put("solution", "solution");

		HeaderColumnNameTranslateMappingStrategy<ProblemDto> strategy = new HeaderColumnNameTranslateMappingStrategy<ProblemDto>();
		strategy.setType(ProblemDto.class);
		strategy.setColumnMapping(mapping);

		CSVReader csvReader = new CSVReader(new FileReader(path));
		CsvToBean<ProblemDto> csvToBean = new CsvToBean<ProblemDto>();
		List<ProblemDto> list = csvToBean.parse(strategy, csvReader);
		return list;
	}

	public static void singleLevelGrouping(List<ProblemDto> problems) {
		final Map<String, List<ProblemDto>> recordsByProblems = problems.stream()
				.collect(Collectors.groupingBy(ProblemDto::getProblem));
		System.out.println("Recover from Previous Versions in Windows: "
				+ recordsByProblems.get("Recover from Previous Versions in Windows").size());
	}

	public static void twoLevelGrouping(List<ProblemDto> problemDtos) {
		final Map<String, Map<String, List<ProblemDto>>> problemDtosByCountryAndCity = problemDtos.stream().collect(
				Collectors.groupingBy(ProblemDto::getProblem, Collectors.groupingBy(ProblemDto::getCategories)));

		problemDtosByCountryAndCity.forEach((k, v) -> System.out.println((k + ":" + v)));
//		System.out.println("Recover from Previous Versions in Windows in HP : "
//				+ problemDtosByCountryAndCity.get("Recover from Previous Versions in Windows").get("HP").size());
	}
}
