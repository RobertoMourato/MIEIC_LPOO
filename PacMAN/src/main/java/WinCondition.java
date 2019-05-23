public class WinCondition {
    DataBase dataBase;
    public WinCondition(DataBase dataBase)
    {
        this.dataBase = dataBase;
    }

    public boolean NoCoins()
    {
        if(dataBase.getCurrentField().getCoinList().size()==0)
        {
            System.out.println("you Win");
            return true;
        }
        return false;
    }

}
