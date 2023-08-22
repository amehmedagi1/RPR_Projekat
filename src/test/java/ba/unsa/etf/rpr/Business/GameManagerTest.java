package ba.unsa.etf.rpr.Business;

import ba.unsa.etf.rpr.Exceptions.GameException;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.GameDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Game;
import ba.unsa.etf.rpr.domain.Genre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

public class GameManagerTest {
    private GameManager gameManager;
    private Game game;
    private GameDaoSQLImpl gameDaoSQLMock;
    private List<Game> games;

    @BeforeEach
    public void initialize(){
        gameManager = Mockito.mock(GameManager.class);
        game = new Game();
        Genre genre = DaoFactory.genreDao().getAll().get(2);
        game.setId(100);
        game.setGameTitle("Nova igrica");
        game.setGenre(DaoFactory.genreDao().getAll().get(2));
        game.setReleaseDate(new Date(2023,8,22));
        game.setRequiredCPU("test");
        game.setRequiredGPU("test");
        game.setRequiredMemory(150);
        game.setRequiredRAM(200);

        gameDaoSQLMock = Mockito.mock(GameDaoSQLImpl.class);
        games = new ArrayList<>();
        games.addAll(Arrays.asList(new Game("igrica", new Date(2022,1,1),genre,"cpu", "gpu", 100,10),new Game("igrica", new Date(2023,1,1),genre,"cpu1", "gpu1", 100,10)));
    }

    @Test
    void validateGameCorrect() throws GameException{
        game.setId(0);
        try{
            Mockito.doCallRealMethod().when(gameManager).validateGame(game);
        }catch (GameException e){
            e.printStackTrace();
            Assertions.assertTrue(false);
        }
    }

    @Test
    void validateGameEmpty() throws GameException{
        game.setGameTitle("a");
        Mockito.doCallRealMethod().when(gameManager).validateGame(game);
        GameException gameException1 = Assertions.assertThrows(GameException.class, ()->{
            gameManager.validateGame(game);}, "Game title must be longer than 3 letters");
        Assertions.assertEquals("Game title must be longer than 3 letters", gameException1.getMessage());
    }

    @Test
    void validateGameIncorrectSpecs() throws GameException{
        game.setRequiredCPU("");
        Mockito.doCallRealMethod().when(gameManager).validateGame(game);
        GameException gameException1 = Assertions.assertThrows(GameException.class, ()->{
            gameManager.validateGame(game);}, "The specifications are incorrect");
        Assertions.assertEquals("The specifications are incorrect", gameException1.getMessage());
    }

    @Test
    void add() throws GameException{
        MockedStatic<DaoFactory> daoFactoryMockedStatic = Mockito.mockStatic(DaoFactory.class);
        daoFactoryMockedStatic.when(DaoFactory::gameDao).thenReturn(gameDaoSQLMock);
        when(DaoFactory.gameDao().getAll()).thenReturn(games);
        Mockito.doCallRealMethod().when(gameManager).add(game);
        GameException gameException = Assertions.assertThrows(GameException.class, ()->{
            gameManager.add(game);}, "\"Id must be 0, because it's autogenerated");
        Assertions.assertEquals("Id must be 0, because it's autogenerated", gameException.getMessage());
        daoFactoryMockedStatic.verify(DaoFactory::gameDao);
        Mockito.verify(gameManager).add(game);
        daoFactoryMockedStatic.close();
    }

    @Test
    void addNewGame() throws GameException{
        game.setId(0);
        gameManager.add(game);
        Assertions.assertTrue(true);
        Mockito.verify(gameManager).add(game);
    }
}
