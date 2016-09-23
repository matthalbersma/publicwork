import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by walter on 9/22/16.
 */
public class readTheAnswer {
  public ArrayList<Integer> readIn() {
        File file= new File ("answer.txt");
      ArrayList<Integer> a= new ArrayList<>();
        try {Scanner sc = new Scanner(file);

                while (sc.hasNextInt()){
                    a.add(sc.nextInt());
                }

        }

        catch (FileNotFoundException e){
                System.out.println("error");
            } return a;
    }
}
