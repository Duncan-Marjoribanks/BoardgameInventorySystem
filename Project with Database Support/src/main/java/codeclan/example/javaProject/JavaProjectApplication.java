package codeclan.example.javaProject;

import codeclan.example.javaProject.enums.GameGenreTypes;
import codeclan.example.javaProject.models.Game;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaProjectApplication {


	public static void main(String[] args) {
		SpringApplication.run(JavaProjectApplication.class, args);

		// this is where to put all the code and method calling
		Game game = new Game(
				"Name",
				30,
				10,
				35,
				10,
				false,
				GameGenreTypes.TRADING
		);
	}
}
