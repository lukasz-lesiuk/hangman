// package hangman;
import java.util.Random;
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.List;

public class hangman {

    // public static String[] GetCapitalList(){

    // }

    public static String RandomCapital() {
        // https://stackoverflow.com/questions/21726033/picking-a-random-item-from-an-array-of-strings-in-java
        // final String[] capitals = {"TOKYO", "PEKIN", "OSLO", "WARSAW", "CANABERRA"};
        final String[] capitals = {"TOKYO"};

        Random random = new Random();
        int index = random.nextInt(capitals.length);
        return capitals[index];
    }

    public static String GenerateHash(String password){
        String hash = "";
        for (int i = 0; i < password.length(); i++){
            hash = hash + "_";
        }
        return hash;
    }

    public static void PrintUsedLetters(List<Character> UsedLetters){
        System.out.println("You used following letters already: ");
        for (int i = 0; i < UsedLetters.size(); i++){
            System.out.print(UsedLetters.get(i) + " ");
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

    public static void PrintSpaces(int qty){
        for (int i = 0; i < qty; i++){
            System.out.println("");
        }
    }

    public static boolean LetterInArray(char CurrentLetter, List<Character> LetterArray){
        boolean IsInArray = false;
        for (int i = 0; i < LetterArray.size(); i++){
            if (LetterArray.get(i) == CurrentLetter) IsInArray = true;
        }
        return IsInArray;
    }

    public static boolean CheckIfWon(String Hash, String Passsword){
        boolean DidWin = false; 
        if (Hash == Passsword) DidWin = true;
        return DidWin;
    }


    public static void main(String[] args) { 

        // get capital list and pick capital
        String password = RandomCapital();

        // hash capital
        String hash = GenerateHash(password);

        boolean IsRunning = true;
        List<Character> UsedLetters = new ArrayList<>();

        // main loop:
        while(IsRunning == true){
            // print hash
            System.out.println(hash);

            // print used letters
            PrintUsedLetters(UsedLetters);

            // ask user for input
            char UserInput = GetAndValidateInput();

            // add letter from user to input list 
            if (LetterInArray(UserInput, UsedLetters) == false)  UsedLetters.add(UserInput);

            // compare input against password
            // MOVE TO METHOD
            String UpdatedHash = "";
            for(int LetterIndex = 0; LetterIndex < password.length(); LetterIndex++){
                //if input is in password fill word in hash..
                // UpdatedHash = "";
                if (password.charAt(LetterIndex) == UserInput){
                    UpdatedHash += UserInput;
                } else if (Character.isLetter(hash.charAt(LetterIndex)) == true){
                    UpdatedHash += password.charAt(LetterIndex);
                } else {
                    UpdatedHash += "_";
                } 
            }
            hash = UpdatedHash.toString();

            // check victory condition
            if (CheckIfWon(hash, password) == true){
                System.out.println("YOU WON");
                IsRunning = false;
            }
            
            PrintSpaces(3);
        }
    }
}
