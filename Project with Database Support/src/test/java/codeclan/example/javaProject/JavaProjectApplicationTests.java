package codeclan.example.javaProject;

import codeclan.example.javaProject.enums.GameGenreTypes;
import codeclan.example.javaProject.models.Accessory;
import codeclan.example.javaProject.models.Game;
import codeclan.example.javaProject.repository.AccessoryRepository;
import codeclan.example.javaProject.repository.GameRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Query;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaProjectApplicationTests {

	Game game, game2;
	Accessory accessory;

	@Autowired
	GameRepository repository;
	AccessoryRepository accRepository;

	@Test
	public void contextLoads() {
	}

	@Before
	public void before() {
		game2 = new Game(
				"newGame",
				20,
				10,
				55,
				15,
				false,
				GameGenreTypes.DECK_BUILDER
		);
	}

	@Test
	public void canWriteToGameTable() {
		game = new Game(
				"game2",
				60.00,
				20,
				45.00,
				45,
				false,
				GameGenreTypes.TRADING
		);
		repository.save(game);
	}

//	@Test
//	public void canWriteToAccessoryTable() {
//		accessory = new Accessory(
//				"Dice",
//				2.00,
//				1,
//				1.00,
//				1,
//				false
//		);
//		accRepository.save(accessory);
//	}

	@Test
	public void canReadFromDatabase() {
		game = new Game(
				"game2",
				60.00,
				20,
				45.00,
				45,
				false,
				GameGenreTypes.TRADING
		);
		repository.save(game);
		Game game = repository.getOne(26L);
		System.out.println(game);
		assertEquals("game2", game.getName());
	}

	@Test
	public void canUpdateDatabase() {
		Game game = repository.getOne(1L);
		game.setName("game3");
		repository.saveAndFlush(game);
}

	@Test
	public void canDeleteFromDatabase() {
		game = new Game(
				"game2",
				60.00,
				20,
				45.00,
				45,
				false,
				GameGenreTypes.TRADING
		);
		repository.delete(game);

	}


}
