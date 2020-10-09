import java.util.ArrayList;
import java.util.Random;

public class XmasDraw3 {
    public static void main (String[] args){
        String[] needGift  = {"x1", "x2", "x3", "x4", "x5", "y1", "y2", "y3", "y4", "y5"};
        String[] mustBuyGift = {"x1", "x2", "x3", "x4", "x5", "y1", "y2", "y3", "y4", "y5"};

        ArrayList<ArrayList<String>> thisYearDraw = fillDrawList(mustBuyGift, needGift);
        ArrayList<ArrayList<String>> nextYearDraw = nextYearFinal(thisYearDraw, mustBuyGift, needGift);

        System.out.println("2020 Draw: " + thisYearDraw);
        System.out.println("2021 Draw: " + nextYearDraw);

    }


   //checks that match is neither the same person nor their partner.
    public static boolean isValid(String a, String b){
        if (a.charAt(1) == b.charAt(1)){
            return false;
        }
        else if (a == b){
            return false;
        }
        return true;
    }


    //checks that match hasn't already received a gift from someone else
    public static boolean receivedGift(String a, ArrayList<ArrayList<String>> b){
        for (int i = 0; i < b.size(); i++){
            if(a == b.get(i).get(1)){
                return true;
            }
        }
        return false;
    }

    //populates the pairs of buyer and receiver of gift.
     public static ArrayList<ArrayList<String>> fillDrawList(String[] buyer, String[] receiver){
         Random rand = new Random();
         ArrayList<ArrayList<String>> thisYearsDraw = new ArrayList<>(10);
         //creates 2D ArrayList to have gift giver and gift receiver.
         // for loop iterates through 0-9 to iterate through the buyers'(mustBuyGift) list
         for (int i = 0; i < buyer.length; i++){
             int randomIndex = rand.nextInt(10);
             //while loop checks that the random person chosen from the receivers'(needGift) list is neither...
             //...the same person buying the gift, nor their partner, nor already getting a gift from someone else.
             while ((receivedGift(receiver[randomIndex], thisYearsDraw) == true)
                     || (isValid(buyer[i], receiver[randomIndex]) == false)){
                 randomIndex = rand.nextInt((10));
             }

             thisYearsDraw.add(new ArrayList());
             thisYearsDraw.get(i).add(buyer[i]);
             thisYearsDraw.get(i).add(receiver[randomIndex]);
         }
         return thisYearsDraw;
     }

    // checks that nextYear's Draw doesn't have anyone buying the same person, as last year, a present.
    public static ArrayList<ArrayList<String>> nextYearFinal (ArrayList<ArrayList<String>> lastYear,
                                                         String[] buyer, String[] receiver){

        ArrayList<ArrayList<String>> nextYear = fillDrawList(buyer, receiver);
        for (int i = 0; i < nextYear.size(); i++){
            // while the giver is the same, if the receiver is also the same, return i to 0...
            //...and get another list.
            while ((nextYear.get(i).get(0) == lastYear.get(i).get(0))
                    && (nextYear.get(i).get(1) == lastYear.get(i).get(1))){
                i = 0;
                nextYear = fillDrawList(buyer, receiver);
            }
        }
        return nextYear;
    }
}
