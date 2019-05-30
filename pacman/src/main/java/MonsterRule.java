import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MonsterRule {
    List<Monster> monsterList;
    DataBase dataBase;

    public MonsterRule(DataBase dataBase) {
        this.dataBase = dataBase;
        this.monsterList = dataBase.getMonsterList();
    }

    public void moveMonsters() {
        for (Monster monster : dataBase.getMonsterList()) {
            Position position = move(monster);
            if (canMonsterMove(position))
                monster.setPosition(position);
            else
                monster.setDirection(changeDirection(monster));
        }

    }

    public boolean canMonsterMove(Position position) {
        for (Position wall : dataBase.getCurrentField().getPositions()) {
            if (wall.equals(position)) {
                return false;
            }
        }
        if (0 < position.getX() && position.getX() < dataBase.getCurrentField().getWidth() && 0 < position.getY() && position.getY() < dataBase.getCurrentField().getHeight())
            return true;
        else
            return false;
    }

    public Direction changeDirection(Monster monster) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 3 + 1);
        if (monster.getDirection() == Direction.values()[randomNum]) {
            randomNum = (randomNum + 1) % 3;
        }
        return Direction.values()[randomNum];
    }

    public Position move(Monster monster) {

        int newX = monster.getPosition().getX(), newY = monster.getPosition().getY();
        Direction direction = monster.getDirection();
        switch (direction) {
            case Right:
                newX = monster.getPosition().getX() + 1;
                newY = monster.getPosition().getY();
                break;


            case Left:
                newX = monster.getPosition().getX() - 1;
                newY = monster.getPosition().getY();
                break;

            case Down:
                newX = monster.getPosition().getX();
                newY = monster.getPosition().getY() + 1;
                break;
            case Up:
                newX = monster.getPosition().getX();
                newY = monster.getPosition().getY() - 1;
                break;
            default:
                break;

        }
        return new Position(newX, newY);

    }

    public DataBase getDataBase() {
        return dataBase;
    }
}
