public class LoseCondition {
    DataBase dataBase;

    public LoseCondition(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public boolean verifyMonsterCollisions() {
        for (Monster monster : dataBase.getMonsterList()) {
            if (monster.getPosition().equals(dataBase.getPacman().getPosition())&&(!dataBase.powerfull))
                return true;
        }
        return false;

    }
}
