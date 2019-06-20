package bo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Student {

	private String name;
	private List<Integer> grades;

	public Student() {
		this.grades = new ArrayList<>();
	}

	public Student(String name, List<Integer> grades) {
		this.name = name;
		this.grades = grades;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getGrades() {
		return grades.stream().sorted((grade1, grade2) -> grade1.compareTo(grade2)).collect(Collectors.toList());
	}

	public void setGrades(List<Integer> grades) {
		this.grades = grades;
	}

	public int getGradeMin() {
		return grades.stream().mapToInt(x -> x).summaryStatistics().getMin();
		// return grades.stream().sorted((grade1, grade2) ->
		// grade1.compareTo(grade2)).collect(Collectors.toList()).get(0);
	}

	public int getGradeMax() {
		return grades.stream().mapToInt(x -> x).summaryStatistics().getMax();
		// return grades.stream().sorted((grade1, grade2) ->
		// -grade1.compareTo(grade2)).collect(Collectors.toList())
		// .get(0);
	}

	public double getAverage() {
		return grades.stream().mapToInt(x -> x).summaryStatistics().getAverage();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student : \n");
		builder.append(" - " + name);
		builder.append("\n - Grades : ");
		builder.append(
				grades.stream().sorted((grade1, grade2) -> grade1.compareTo(grade2)).collect(Collectors.toList()));
		return builder.toString();
	}

}
