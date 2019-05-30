public class Pacman {
    Position position;

    public Pacman() {
        position = new Position(10, 10);

    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
