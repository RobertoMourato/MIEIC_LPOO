import java.io.IOException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws IOException {

        int scan;
        Scanner S = new Scanner(System.in);


        boolean runMenu=true;

        while(runMenu) {
            System.out.println("Menu:");
            System.out.println("1: Use Lanterna");
            System.out.println("2: Use Swing View");
            System.out.println("3: Quit");
            scan = S.nextInt();

            switch (scan) {
                case 1:

                    LanternaView a = new LanternaView();
                    a.run();
                    break;
                case 2:
                    SwingView b = new SwingView();

                    b.start();
                    break;

                case 3:
                    System.out.println("Bye");
                    runMenu=false;

                    break;
                default:
                    System.out.println("Invalid");
                    break;


            }
        }



    }
}
