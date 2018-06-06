package codeclan.example.javaProject;

import codeclan.example.javaProject.enums.GameGenreTypes;
import codeclan.example.javaProject.models.Game;
import codeclan.example.javaProject.repository.GameRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaProjectApplicationTests {

	Game game;

	@Autowired
	GameRepository repository;

	@Before
	public void before() {
		game = new Game(
				"game2",
				60,
				20,
				45,
				40,
				false,
				GameGenreTypes.TRADING
		);
		repository.save(game);
	}

	@Test
	public void contextLoads() {
	}

}
