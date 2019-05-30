import com.googlecode.lanterna.input.KeyStroke;

public class Rule {
    DataBase dataBase;
    HeroRule hero_rule;
    Monster_Rule monster_rule;
    WinCondition winCondition;
    LoseCondition loseCondition;

    public Rule(DataBase dataBase) {
        this.dataBase = dataBase;
        this.hero_rule = new HeroRule(dataBase);
        this.monster_rule = new Monster_Rule(dataBase);
        this.winCondition = new WinCondition(dataBase);
        this.loseCondition = new LoseCondition(dataBase);
    }

    public DataBase check(KeyStroke key) {
        hero_rule.heroMovement(key);
        /*dataBase = hero_rule.getDataBase();*/


        return dataBase;
    }

    public DataBase autocheck() {

        monster_rule.moveMonsters();
        /* dataBase = monster_rule.getDataBase();*/

        return dataBase;

    }

}
