package Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bo.Student;

public class Application {

	private static ArrayList<Student> students;

	public static void main(String[] args) {
		students = new ArrayList<Student>();
		mockList(students);

		System.out.println("---------Affichage des notes de chaque élèves---------\n");
		students.stream().forEach(student -> System.out.println(student + "\n - Max grade : " + student.getGradeMax()
				+ "\n - Min grade : " + student.getGradeMin() + "\n - Average : " + student.getAverage() + "\n"));

		System.out.println("\n---------Affichage des statistiques de la classe---------\n");
		System.out.println("La note min. de la classe est de : "
				+ students.stream().mapToInt(student -> student.getGradeMin()).summaryStatistics().getMin());
		System.out.println("La note max. de la classe est de : "
				+ students.stream().mapToInt(student -> student.getGradeMax()).summaryStatistics().getMax());
		System.out.println("La moyenne de la classe est de : "
				+ students.stream().mapToDouble(student -> student.getAverage()).summaryStatistics().getAverage());
	}

	private static void mockList(ArrayList<Student> students) {
		List<Integer> grades = Arrays.asList(19, 12, 8, 10, 4, 11, 15, 20);
		students.add(new Student("Alexei", grades));

		grades = Arrays.asList(11, 12, 15, 13, 18, 19, 16, 14);
		students.add(new Student("Adrien", grades));

		grades = Arrays.asList(8, 11, 9, 10, 13, 14, 10, 9);
		students.add(new Student("Glen", grades));

		grades = Arrays.asList(13, 12, 16, 14, 11, 9, 8, 15);
		students.add(new Student("Mathilde", grades));

		grades = Arrays.asList(18, 17, 16, 18, 14, 13, 15, 14);
		students.add(new Student("Robin", grades));

	}
}
