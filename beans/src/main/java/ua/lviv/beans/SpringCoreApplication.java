package ua.lviv.beans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class SpringCoreApplication {

	static Scanner scan;

	private static void menu() {
		System.out.println("Зроби вибір: ");
		System.out.println("\t1. Вивести всіх студентів");
		System.out.println("\t2. Вивести студента за його id");
		System.out.println("\t3. Додати студента");
		System.out.println("\t4. Видалити студента");
		System.out.println("\t5. Змінити дані студента");
		System.out.println("Введи \"quit\" щоб вийти. ");
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringCoreApplication.class, args);

		StudentDAO bean = run.getBean(StudentDAO.class);

		scan = new Scanner(System.in);
		menu();
		String line = scan.next();
		while (!line.equalsIgnoreCase("quit")) {
			switch (line) {
				case "1":
					System.out.println(bean.getAll());
					break;
				case "2":
					System.out.println("Введи id студента");
					int n = scan.nextInt();
					System.out.println(bean.getById(n));
					break;
				case "3":
					System.out.println("Введи ід студента");
					int id = scan.nextInt();
					System.out.println("Введи ім'я студента");
					String name = scan.next();
					System.out.println("Введи вік студента");
					int age = scan.nextInt();
					bean.insert(id, name, age);
					break;
				case "4":
					System.out.println("Введи id студента");
					int v = scan.nextInt();
					bean.delete(v);
					break;
				case "5":
					System.out.println("Введи ід студента");
					int id2 = scan.nextInt();
					System.out.println("Введи ім'я студента");
					String name2 = scan.next();
					System.out.println("Введи вік студента");
					int age2 = scan.nextInt();
					bean.update(id2, name2, age2);
					break;
			}
			menu();
			line = scan.next();
		}


	}

}
