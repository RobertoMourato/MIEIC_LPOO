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
        //Aditional Walls
        for(int x = 2; x <= width-10; x++) {
            Position position = new Position(x, 2);
            positions.add(position);
        }
        for(int y = 2; y< height-15; y++)
        {
            Position position = new Position(width-8, y);
            positions.add(position);
        }
        for(int y = 1; y< height-9; y++)
        {
            Position position = new Position(width-6, y);
            Position position2 = new Position(width-5, y);
            positions.add(position);
            positions.add(position2);
        }
        for(int y = 2; y< height-17; y++)
        {
            Position position = new Position(width-3, y);
            Position position2 = new Position(width-2, y);
            Position position3 = new Position(width-1, y);
            positions.add(position);
            positions.add(position2);
            positions.add(position3);
        }
        for(int y = height-16; y< height-9; y++)
        {
            Position position = new Position(width-3, y);
            Position position2 = new Position(width-2, y);
            positions.add(position);
            positions.add(position2);
        }
        for(int y=4; y < height - 15; y++)
        {
            Position position = new Position(width-10, y);
            Position position2 = new Position(width-11, y);
            Position position3 = new Position(width-12, y);

            positions.add(position);
            positions.add(position2);
            positions.add(position3);
        }
        for(int x = 1; x<= width-14; x++)
        {
            Position position = new Position(x, 4);
            positions.add(position);

        }
        for(int x = 2; x <= width-14; x++) {
            Position position = new Position(x, 6);
            Position position2 = new Position(x, 7);
            Position position3 = new Position(x, 8);
            Position position4 = new Position(x, 9);
            Position position5 = new Position(x, 11);

            positions.add(position);
            positions.add(position2);
            positions.add(position3);
            positions.add(position4);
            positions.add(position5);
        }
        for(int y=9; y < height - 5; y++)
        {
            Position position = new Position(18, y);
            Position position2 = new Position(19, y);
            Position position3 = new Position(20, y);
            Position position4 = new Position(17, y);
            Position position5 = new Position(22, y);

            positions.add(position);
            positions.add(position2);
            positions.add(position3);
            positions.add(position4);
            positions.add(position5);
        }
        for(int x = 2; x <= width-15; x++) {
            Position position = new Position(x, 13);
            Position position2 = new Position(x, 14);
            Position position3 = new Position(x, 15);
            Position position4 = new Position(x, 16);


            positions.add(position);
            positions.add(position2);
            positions.add(position3);
            positions.add(position4);
        }
        for(int x = 1; x <= width-15; x++) {
            Position position = new Position(x, 18);
            Position position2 = new Position(x, 19);
            Position position3 = new Position(x, 20);
            Position position4 = new Position(x, 21);
            Position position5 = new Position(x, 22);


            positions.add(position);
            positions.add(position2);
            positions.add(position3);
            positions.add(position4);
            positions.add(position5);
        }
        for(int y=19; y < 22; y++)
        {
            Position position = new Position(17, y);
            Position position2 = new Position(18, y);


            positions.add(position);
            positions.add(position2);

        }
        for(int x = 24; x <30; x++) {
            Position position = new Position(x, 18);
            Position position2 = new Position(x, 19);
            Position position3 = new Position(x, 20);
            Position position4 = new Position(x, 21);
            Position position5 = new Position(x, 22);


            positions.add(position);
            positions.add(position2);
            positions.add(position3);
            positions.add(position4);
            positions.add(position5);
        }
        for(int x = 23; x <29; x++) {
            Position position = new Position(x, 15);
            Position position2 = new Position(x, 16);



            positions.add(position);
            positions.add(position2);

        }

        Power power = new Power(29,1);
        this.powerList.add(power);

        //Until Here
        for(int x = 0; x <= width; x++)
        {
            for(int y = 0; y <= height ; y++)
            {

                if(positions.contains(new Position(x,y)))
                {
                    continue;
                }
                else if((x==10&&y==10)||(x==20&&y==20)||(x==20&&y==21)||(x==21&&y==20)||(x==22&&y==20)||(x==16&&y==15))
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
