public class Monster {
    Position position;
    Direction direction;

    public Monster(int x, int y) {
        position = new Position(x, y);
        direction = Direction.Up;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
