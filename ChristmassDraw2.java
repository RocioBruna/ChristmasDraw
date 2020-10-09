/*import java.util.Arrays;
import java.util.Random;

public class ChristmassDraw2 {
    public static void main (String[] args){
        String[][] couples = {{"x1" , "y1"}, {"x2" , "y2"}, {"x3" , "y3"}, {"x4" , "y4"}, {"x5" , "y5"}};
        String[] individualA = {"x1", "x2", "x3", "x4", "x5", "y1", "y2", "y3", "y4", "y5"};
        String[] individualB = {"x1", "x2", "x3", "x4", "x5", "y1", "y2", "y3", "y4", "y5"};

        Random rand = new Random();
        String[][] randomList = new String[10][2];
// for loop to get 10 results. first and second used as indexes will be random numbers from 0-9)
        for (int i = 0; i < 10; i++){
            int first = rand.nextInt(9); //previous mistake, rand.nextInt(10);
            int second = rand.nextInt(9); //previous mistake, rand.nextInt(10);
            // if elements in random location of individualA and B are allowed results,
            // while indiA & B are null, randomise index values again until the elements are not null.
            if(permited(couples, individualA[first], individualB[second], individualA, individualB));{
                    while(individualA[first] == null ||
                       individualB[second] == null) {
                        if (individualA[first] == null){
                            first = rand.nextInt(10);
                        }
                        if (individualB[second] == null) {
                            second = rand.nextInt(10);
                        }
                    }
                    // once they're not null (aka, when it leaves the loop) once more we check if they're permited results.
                // if they are, and they are definitely not null, then put those values in randomList.
                     if(permited(couples, individualA[first], individualB[second], individualA, individualB) &&
                             individualA[first] != null &&
                             individualB[second] != null){

                        randomList[i][0] = individualA[first];
                        randomList[i][1] = individualB[second];
                    //nullify those elements used, to avoid some people not receiving or not buying.
                        individualA[first] = null;
                        individualB[second] = null;
                     }
            }
        }

        System.out.println("A: " + Arrays.toString(individualA) + " B: " + Arrays.toString(individualB));
        System.out.println("Xmas Draw 2019: ");
        for (int j = 0; j < randomList.length; j++){
            if(randomList[j][0] != null || randomList[j][1] != null){
            System.out.println (j+1 + " " + randomList[j][0] + " buys for " + randomList[j][1]);}
        }
        System.out.println("A: " + Arrays.toString(individualA) + " B: " + Arrays.toString(individualB));

    }

    public static boolean permited(String[][] array2D, String a, String b, String[] A, String[] B){
        // arguments: A 2D array (couples and then 2019 list) and a or b (element from individualA or individualB).
        // for look checks what pairings are allowed and returns false if it meets any of the exceptions.
        // including for checking that the element is not null.
        for (int i = 0; i < array2D.length; i++){
            if ((a == b)|| (array2D[i][0] == a && array2D[i][1] == b) &&
                    (A[i] != null) && (B[i] != null)){
                return false;
            }
        }
        //true if it's not part of exceptions.
        return true;
    }
}
*/