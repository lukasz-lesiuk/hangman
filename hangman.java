package hangman;
import java.util.Random;


public class hangman {
    public static String RandomCapital() {
        // https://stackoverflow.com/questions/21726033/picking-a-random-item-from-an-array-of-strings-in-java
        final String[] capitals = {"TOKYO", "PEKIN", "OSLO", "WARSAW", "CANABERRA"};
        Random random = new Random();
        int index = random.nextInt(capitals.length);
        // System.out.println(capitals[index]);
        return capitals[index];
    }

    public static String GenerateHash(String password){
        String hash = "";
        for (int i = 0; i < password.length(); i++){
            hash = hash + "_";
        }
        return hash;
    }

    public static void main(String[] args) { 
        // get capital list 
        // pick capital
        String password = RandomCapital();

        // hash capital
        String hash = GenerateHash(password);

        boolean IsRunning = true;
        char[] UsedLetters = {'A'};

        // main loop:
        while(IsRunning == true){
            // print hash
            System.out.println(hash);
            System.out.println("You used following letters already" + UsedLetters);

            // print used letters
            // ask user for input
            // compare input against password
                //if input is in password fill word in hash..
                //else...
            // if hash == capital 
                // break from loop and print victory
        }

    }


    


}
