import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.time.Instant;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;

public class LanternaView {
    protected Terminal terminal;
    protected Screen screen;
    protected TextGraphics graphics;
    protected DataBase dataBase;
    protected Rule rule;

    public LanternaView() throws IOException {
        try {
            terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(31, 24)).createTerminal();
            screen = new TerminalScreen(terminal);


            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary

            graphics = screen.newTextGraphics();
            dataBase = new DataBase();
            rule = new Rule(dataBase);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    synchronized public void draw() throws IOException {
        try {
            screen.clear();

            // draw here

            //Background
            graphics.setBackgroundColor(TextColor.Factory.fromString("#554444"));
            graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(dataBase.getCurrentField().getWidth(), dataBase.getCurrentField().getHeight()), ' ');

            //Field
            for (Position position : dataBase.getCurrentField().getPositions()) {
                graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
                graphics.enableModifiers(SGR.BOLD);
                graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
            }

            for (Coin coin : dataBase.getCurrentField().getCoinList()) {
                graphics.setForegroundColor(TextColor.Factory.fromString("#FFF000"));
                graphics.enableModifiers(SGR.BOLD);
                graphics.putString(new TerminalPosition(coin.getPosition().getX(), coin.getPosition().getY()), "o");

            }

            for (Power power : dataBase.getCurrentField().getPowerList()){
                graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
                graphics.enableModifiers(SGR.BOLD);
                graphics.putString(new TerminalPosition(power.getPosition().getX(), power.getPosition().getY()), "0");
            }

            //Hero
            graphics.setForegroundColor(TextColor.Factory.fromString("#00F00F"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(dataBase.getPacman().getPosition().getX(), dataBase.getPacman().getPosition().getY()), "P");

            //Monster
            for (Monster monster : dataBase.getMonsterList()) {
                graphics.setForegroundColor(TextColor.Factory.fromString("#0000F0"));
                graphics.enableModifiers(SGR.BOLD);
                graphics.putString(new TerminalPosition(monster.getPosition().getX(), monster.getPosition().getY()), "M");

            }

            // Until this section

            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    synchronized public void processKey(KeyStroke key) throws IOException {

        //HeroMovement.processKey(key);
        /*dataBase =*/
        rule.check(key);
    }

    public void run() throws IOException {
        //Look at Java Thread Daemon
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        draw();
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                    rule.autocheck();

                    if (rule.winCondition.NoCoins()) {
                        System.out.println("You win!!");
                        break;
                    }

                    if (rule.loseCondition.verifyMonsterCollisions()) {
                        System.out.println("You lose!!");
                        break;
                    }

                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                    if (isInterrupted()) {
                        break;
                    }


                }
            }

        };
        t.start();
        while (true) {
            KeyStroke key = screen.readInput();
            processKey(key);

            if (key.getKeyType() == KeyType.EOF) {
                t.interrupt();
                break;
            }
        }
    }
}
