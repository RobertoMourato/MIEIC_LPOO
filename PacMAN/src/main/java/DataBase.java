import java.util.ArrayList;
import java.util.List;

public class DataBase {
    Pacman pacman;
    List<Monster> monsterList = new ArrayList<>();
    List<Field> fieldList = new ArrayList<>();
    Field currentField;

    public DataBase(){

        //PacMan
        pacman = new Pacman();

        //Monster
        Monster monster1 = new Monster(20,20);
        Monster monster2 = new Monster(21,20);
        Monster monster3 = new Monster(22,20);
        Monster monster4 = new Monster(20,21);
        monsterList.add(monster1);
        monsterList.add(monster2);
        monsterList.add(monster3);
        monsterList.add(monster4);

        //Field
        Level1Field field = new Level1Field();
        fieldList.add(field);
        currentField = field;

    }

    public List<Field> getFieldList() {
        return fieldList;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public Field getCurrentField() {
        return currentField;
    }

    public void setCurrentField(Field currentField) {
        this.currentField = currentField;
    }

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
    }

    public void setMonsterList(List<Monster> monsterList) {
        this.monsterList = monsterList;
    }
}
