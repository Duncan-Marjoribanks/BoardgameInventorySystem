package codeclan.example.javaProject;

import codeclan.example.javaProject.enums.GameGenreTypes;
import codeclan.example.javaProject.models.Game;
import codeclan.example.javaProject.repository.GameRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaProjectApplicationTests {

	Game game;

	@Autowired
	GameRepository repository;


	@Test
	public void contextLoads() {
	}

	@Test
	public void canWriteToDatabase() {
		game = new Game(
				"game2",
				60,
				20,
				45,
				45,
				false,
				GameGenreTypes.TRADING
		);
		game.setKeyword("Beginner");
		repository.save(game);
	}

	@Test
	public void canReadFromDatabase() {
		game = repository.findById(Game<1L>1L);
		assertEquals("game2", game.getName());
	}

	@Test
	public void canUpdateDatabase() {
		game = repository.getOne(1L);
		game.setName("game3");
		repository.save(game);
}

	@Test
	public void canDeleteFromDatabase() {
		repository.delete(game);

	}


}
