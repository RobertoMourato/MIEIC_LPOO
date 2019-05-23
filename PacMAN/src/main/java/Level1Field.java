public class Level1Field  extends Field{
    public Level1Field(){
        level = 1;
        width = 30;
        height = 23;

        for(int x = 0; x<= width; x++){

            positions.add(new Position(x,0));
            positions.add(new Position(x,height));
        }

        for(int y = 1; y< height; y++){
            positions.add(new Position(0,y));
            positions.add(new Position(width,y));

        }
        Position position = new Position(12,10);
        positions.add(position);

        for(int x = 0; x <= width; x++)
        {
            for(int y = 0; y <= height ; y++)
            {

                if(positions.contains(new Position(x,y)))
                {
                    continue;
                }
                else if((x==10&&y==10)||(x==20&&y==20)||(x==20&&y==21)||(x==21&&y==20)||(x==22&&y==20))
                {
                    continue;
                }
                else
                {
                    coinList.add(new Coin(x,y));
                }
            }

        }
    }
}
