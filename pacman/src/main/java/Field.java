import java.util.ArrayList;
import java.util.List;

public class Field {

    protected List<Position> positions = new ArrayList<>();
    protected List<Coin> coinList = new ArrayList<>();
    protected int width;
    protected int height;
    protected int level;

    public Field() {
        level = 0;
        width = 30;
        height = 23;
        for (int x = 0; x <= width; x++) {

            positions.add(new Position(x, 0));
            positions.add(new Position(x, height));
        }

        for (int y = 1; y < height - 1; y++) {
            positions.add(new Position(0, y));
            positions.add(new Position(width, y));

        }
      /*  for(int x = 0; x < width; x++)
        {
            for(int y = 0; y < height; y++)
            {

                if(positions.contains(new Position(x,y)))
                {
                    break;
                }
                else if(positions.contains(new Position(10,10)))
                {
                    break;
                }
                else if(positions.contains(new Position(20,20))||positions.contains(new Position(20,21))||positions.contains(new Position(21,20))||positions.contains(new Position(22,20)))
                {
                    break;
                }
                else
                {
                    coinList.add(new Coin(x,y));
                }
            }

        }*/
    }

    public int getLevel() {
        return level;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
