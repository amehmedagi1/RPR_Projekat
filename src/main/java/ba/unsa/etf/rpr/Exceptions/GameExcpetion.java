package ba.unsa.etf.rpr.Exceptions;

import ba.unsa.etf.rpr.domain.Game;

public class GameExcpetion extends RuntimeException{
    public GameExcpetion(String message) {
        super(message);
    }
}
