package ua.lviv.dataJpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringJpaApplication.class, args);

		UniverService univerService = applicationContext.getBean(UniverService.class);
		Univer univer1 = new Univer("Polytex", 5, 35, 3450, "Bandera, xxx");
		Univer univer2 = new Univer("National", 5, 25, 2753, "qwe, xxx");
		univerService.insert(univer1);
		univerService.insert(univer2);

		List<Univer> univerList = univerService.findByName("Polytex");
		System.out.println(univerList);

		Univer byId = univerService.findById(2);
		System.out.println(byId);

		univerService.update(2, "qwe", 3, 33, 333, "new address");

		univerService.delete(2);

		Univer byId2 = univerService.findById(2);
		System.out.println(byId2);

	}

}
