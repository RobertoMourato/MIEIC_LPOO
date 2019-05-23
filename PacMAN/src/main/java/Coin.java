public class Coin {
    Position position;
    public Coin(int x, int y){
        position = new Position(x,y);
    }

    public Position getPosition() {
        return position;
    }
}
