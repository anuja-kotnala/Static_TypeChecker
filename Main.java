import java.util.*;
public class Main{

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        TypeChecker tc= new TypeChecker();

        System.out.println("Enter program (or type END to stop): ");

        while(true){
            String line=sc.nextLine();
            if(line.equals("END"))break;

            tc.process(line);
        }
        sc.close();
    }
}