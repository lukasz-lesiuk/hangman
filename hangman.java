package hangman;
import java.util.Random;
import java.util.Scanner; 


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

    public static void PrintUsedLetters(char[] UsedLetters){
        for (int i = 0; i < UsedLetters.length; i++){
            System.out.print(UsedLetters[i] + " ");
        }
        System.out.println("");
    }

    public static char GetAndValidateInput(){

        char charInputValue = Character.MIN_VALUE;
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        while(true){
            System.out.println("Enter slingle letter");
            String inputValue = scanner.nextLine();  // Read user input
            charInputValue = inputValue.charAt(0);
            if (Character.isLetter(charInputValue) == true) {
                charInputValue = ToUpper(charInputValue);
                break;
            } else {
                System.out.println("Input is not a single letter!");
            }
        }
        // scanner.close();
        return charInputValue;
    }

    public static char ToUpper(char InputChar){
        char OutputChar = Character.MIN_VALUE;
        if (Character.isLowerCase(InputChar) == true){
            OutputChar = Character.toUpperCase(InputChar);
        } else {
            OutputChar = InputChar;
        }

        return OutputChar;
    }


    public static void main(String[] args) { 
        // get capital list 
        // pick capital
        String password = RandomCapital();

        // hash capital
        String hash = GenerateHash(password);

        boolean IsRunning = true;
        char[] UsedLetters = {'A', 'B'};

        // main loop:
        while(IsRunning == true){
            // print hash
            System.out.println(hash);

            // print used letters
            System.out.println("You used following letters already: ");
            PrintUsedLetters(UsedLetters);

            // ask user for input
            char UserInput = GetAndValidateInput();
            System.out.println(UserInput);

            // compare input against password
                //if input is in password fill word in hash..
                //else...
            // if hash == capital 
                // break from loop and print victory
        }

    }


    


}
