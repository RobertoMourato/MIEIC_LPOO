import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

public class Display extends JPanel implements KeyListener, ActionListener {
    Rule rule;
    DataBase dataBase;
    Timer t = new Timer(100,this);

    public Display(Rule rule, DataBase dataBase){
        this.rule = rule;
        this.dataBase = dataBase;
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setLayout(null);
        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e){
        rule.autocheck();
        repaint();
        if (rule.winCondition.NoCoins()) {
            System.out.println("You win!!");
            ((Timer)e.getSource()).stop();
        }

        if (rule.loseCondition.verifyMonsterCollisions()) {
            System.out.println("You lose!!");
            ((Timer)e.getSource()).stop();
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        if (!rule.winCondition.NoCoins()&&!rule.loseCondition.verifyMonsterCollisions()){
        if(key == KeyEvent.VK_RIGHT){

            moveRight();
        }
        else if(key == KeyEvent.VK_LEFT)
        {
            moveLeft();
        }
        else if(key == KeyEvent.VK_UP)
        {
            moveUp();
        }
        else if(key == KeyEvent.VK_DOWN)
        {
            moveDown();
        }}
    }

    @Override
    public void keyReleased(KeyEvent e) {


    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped");

    }
    public void moveRight(){
        KeyStroke key = new KeyStroke(KeyType.ArrowRight);
        rule.check(key);

        repaint();
    }
    public void moveLeft(){
        KeyStroke key = new KeyStroke(KeyType.ArrowLeft);
        rule.check(key);

        repaint();
    }
    public void moveUp(){
        KeyStroke key = new KeyStroke(KeyType.ArrowUp);
        rule.check(key);

        repaint();
    }

    public void moveDown(){
        KeyStroke key = new KeyStroke(KeyType.ArrowDown);
        rule.check(key);

        repaint();
    }

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        /*setBackground(Color.BLACK);
        graphics.setColor(Color.WHITE);*/
        graphics.drawRect(0, 0, 930, 750);
        graphics.setColor(Color.BLACK);

        graphics.fillRect(0,0,930,750);
        for (Position position : dataBase.getCurrentField().getPositions()) {
            graphics.drawRect(position.getX()*30,position.getY()*30,30,30);
            graphics.setColor((Color.WHITE));
        }
        for (Coin coin : dataBase.getCurrentField().getCoinList()) {
            graphics.setColor(Color.YELLOW);
            graphics.fillRect(coin.getPosition().getX()*30,coin.getPosition().getY()*30,30,30);

        }

        //PacMan
        graphics.setColor(Color.GREEN);
        graphics. fillRect(dataBase.getPacman().getPosition().getX()*30,dataBase.getPacman().getPosition().getY()*30,30,30);

        //Monsters
        for (Monster monster : dataBase.getMonsterList()) {
            graphics.setColor(Color.BLUE);
            graphics.fillRect(monster.getPosition().getX()*30, monster.getPosition().getY()*30,30,30);

        }

    }

}
