package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.ComputerDaoSQLImpl;
import ba.unsa.etf.rpr.dao.GameDao;
import ba.unsa.etf.rpr.dao.GameDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Game;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Test da li radi konekcija sa bazom
        GameDao dao = new GameDaoSQLImpl();
        //list of games
        ArrayList<Game> games= new ArrayList<Game>();
        //adding games from database to list
        for(int i = 0; i<3; i++){
            games.add(dao.getById(i+1));
        }
        //writing teams
        System.out.println("Games: ");
        int br=1;
        for(Game g : games) {
            System.out.println(br + ". " + g);
            br++;
        }
    }
}
