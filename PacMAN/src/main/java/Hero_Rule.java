import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.List;

public class Hero_Rule {
    Pacman pacman;
    DataBase dataBase;
    private List<Coin> coinsToRemove;

    public Hero_Rule(DataBase dataBase)
    {
        this.dataBase = dataBase;
        this.pacman = dataBase.getPacman();
        this.coinsToRemove = new ArrayList<Coin>();
    }
    public Position moveUp() {
        return new Position(pacman.getPosition().getX(), pacman.getPosition().getY() - 1);
    }

    public Position moveDown(){
        return new Position(pacman.getPosition().getX(), pacman.getPosition().getY() + 1);
    }
    public Position moveLeft(){
        return new Position(pacman.getPosition().getX()-1, pacman.getPosition().getY());
    }
    public Position moveRight(){
        return new Position(pacman.getPosition().getX()+1, pacman.getPosition().getY());
    }
    public void heroMovement(KeyStroke key)
    {
        switch(key.getKeyType()){

            case ArrowUp:
                moveHero(moveUp());
                break;

            case ArrowDown:
                moveHero(moveDown());
                break;

            case ArrowLeft:
                moveHero(moveLeft());
                break;

            case ArrowRight:
                moveHero(moveRight());
                break;

        }

    }

    public void moveHero(Position position) {


        if (canHeroMove(position))
            pacman.setPosition(position);

        for(Coin coin: dataBase.getCurrentField().getCoinList())
        {
            if(coin.getPosition().equals(position))
                coinsToRemove.add(coin);

        }
        if(!coinsToRemove.isEmpty())
            retrieveCoins();

    }

    private void retrieveCoins(){
        dataBase.getCurrentField().getCoinList().removeAll(coinsToRemove);

    }

    public boolean canHeroMove(Position position)
    {
        for(Position wall: dataBase.getCurrentField().getPositions()) {
            if (wall.equals(position))
                return false;
        }
        if(0 < position.getX() && position.getX() < dataBase.getCurrentField().getWidth() && 0 < position.getY() && position.getY() < dataBase.getCurrentField().getHeight())
            return true;
        else
            return false;
    }

    public DataBase getDataBase() {
        return dataBase;
    }
}
