// Farida Abdelmalek 
// CPT: COLOURMASTER
// Last Edited on April 8th, 2021
// Validated by Elizabeth, Niki, and Claire


package cpt;

import java.util.Scanner;
import java.util.concurrent.TimeUnit; // for time lapses
import java.awt.Color; // for colours 



public class CPT {
    
     public static final String ANSI_BRIGHT_BG_BLACK  = "\u001B[100m"; // colour backgrounds for text 
     public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
     public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
     public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
     public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
     public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
     public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
     public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
     public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
     public static final String ANSI_GREY_BACKGROUND = "\u001B[37m";
     public static final String ANSI_RESET = "\u001B[0m"; // coloured text 
     public static final String ANSI_BLACK = "\u001B[30m";
     public static final String ANSI_RED = "\u001B[31m";
     public static final String ANSI_GREEN = "\u001B[32m";
     public static final String ANSI_YELLOW = "\u001B[33m";
     public static final String ANSI_BLUE = "\u001B[34m";
     public static final String ANSI_PURPLE = "\u001B[35m";
     public static final String ANSI_CYAN = "\u001B[36m";
     public static final String ANSI_WHITE = "\u001B[37m";
     public static final String ANSI_PINK = "\u001B[38m";
     public static final String ANSI_ORANGE = "\u001B[39m";
     public static final String ANSI_GREY = "\u001B[40m";
     static String [] trueColours = new String [4]; // string array that carries the name of the colours for level 1
     static int [] trueColourNumbers = new int [4]; // int array with the corresponding number of each of the colours for level 1
     static int [] trueColourNumbersHard = new int [5]; // int array with the corresponding number of each of the colours for level 2
     static String [] trueColoursHardLevel = new String [5]; // string array that carries the name of the colours for level 2 
     static int colourGuessEasy = 0; // int for the user's input for the easy level
     static int colourGuessHard = 0; // int for the user's input for the hard level
     static int wins = 0; // amount of wins (if user guesses all the correct colours and correct sequences before the attempts are up
     static int totalGames = 0; // amount of total games played 
     static int playAgain = 0; // playAgain feature 
     static boolean playAgainBoolean = true; // boolean for play again (if needed)
    
   
    public static void main(String[] args) throws InterruptedExcpetion, InterruptedException {
       Scanner in = new Scanner (System.in); 
       String userName = ""; 
       
        System.out.println(ANSI_WHITE_BACKGROUND+"Please enter your name..."); // asks for user's name 
        userName = in.next(); 
        
     do {  // do loop for play again feature 
      int [] colours = new int [4]; // array for easy level 
      int [] coloursHardLevel = new int [5]; // array for hard level (one extra colour) 
      int instructionsWish = 0; 
      
     mainPage(userName); // takes user to main page method 
     colourSelection (colours, trueColours, trueColourNumbers); // method to randomize easy level colours 
          
        boolean cont = false; // boolean for try catch 
        
        while (cont == false){
         try{ // try and catch for instruction question 
                 System.out.println("");
                 TimeUnit.MILLISECONDS.sleep(500);
                 System.out.println("Do you wish to go over the instructions " + userName + "?"); // asking user if they would like to go over instructions to clarify rules 
                 System.out.println("\t. 1 - Yes");
                 System.out.println("\t. 2 - No");
                 instructionsWish = in.nextInt();  
                cont = true; 
            
            } // try statement 
            
                catch (Exception e){
                    System.out.println("Error! Please try again using the numbers corresponding with eaach answer :) ");
                    cont = false; 
                    in.nextLine(); 
                } // catch 
        }
        if (instructionsWish == 1){
            gameInstructions(userName); // takes user to instructions method, if they answer "yes"
        }
        if (instructionsWish!=1 && instructionsWish!=2){
            System.out.println("Error! Please enter either 1 for yes, or 2 for no. Please try again :) "); // invalid entry 
            cont = false; 
            
            while (cont == false){
         try{ // try anc catch for invalid entry 
                 System.out.println("");
                 TimeUnit.MILLISECONDS.sleep(400);
                 System.out.println("Do you wish to go over the instructions " + userName + "?");
                 System.out.println("\t. 1 - Yes");
                 System.out.println("\t. 2 - No");
                 instructionsWish = in.nextInt();  
                cont = true; 
            
            } // try statement 
            
                catch (Exception e){
                    System.out.println("Error! Please try again using the numbers corresponding with eaach answer :) ");
                    cont = false; 
                    in.nextLine(); 
                } // catch 
         
        if (instructionsWish == 1){
            gameInstructions(userName);
        } // if statement 
            } // while statement 
        } // if statment for invalid 
        
        
         board (); // takes user to board method (first time board is shown)
         
        int level = 0; // integer for level the user selects 
        boolean cont1 = false; // boolean for try and catch 
         while (cont1 == false){
         try{ // try and catch for asking the user what level 
                 System.out.println("");
                 TimeUnit.MILLISECONDS.sleep(450);
                 System.out.println(ANSI_RESET);
                 System.out.println("");
                 System.out.println(ANSI_WHITE_BACKGROUND+ANSI_GREEN+"Please select the level you wish to play " + userName);
                 System.out.println(ANSI_GREEN_BACKGROUND+ANSI_WHITE+"\t. 1 - Easy");
                 System.out.println(ANSI_GREEN_BACKGROUND+ANSI_WHITE+"\t. 2 - Hard");
                 level = in.nextInt(); 
                 cont1 = true; 
            
            } // try statement 
            
                catch (Exception e){
                    System.out.println("Error! Please try again using the numbers corresponding with each answer :) ");
                    cont1 = false; 
                    in.nextLine(); 
                } // catch 
         }
         if  (level!=1 && level!=2){
             System.out.println("Error! Please enter either 1 for easy, or 2 for hard :) "); // invalid entry 
             cont1 = false; 
             
             while (cont1 == false){
            try{ // try and catch for invalid entry 
                 System.out.println("");
                 System.out.println("");
                 System.out.println(ANSI_RESET);
                 System.out.println(ANSI_WHITE_BACKGROUND+ANSI_GREEN+"Please select the level you wish to play " + userName);
                 System.out.println(ANSI_GREEN_BACKGROUND+ANSI_WHITE+"\t. 1 - Easy");
                 System.out.println(ANSI_GREEN_BACKGROUND+ANSI_WHITE+"\t. 2 - Hard");
                 level = in.nextInt(); 
                 cont1 = true; 
            
            } // try statement 
            
                catch (Exception e){
                    System.out.println("Error! Please try again using the numbers corresponding with each answer :) ");
                    cont1 = false; 
                    in.nextLine(); 
                } // catch 
         }
         }
        
        switch (level){ // switch statement for levels
            case 1: // if they select easy level 
                totalGames++; // adds to total games played 
                easyLevelUser (userName, trueColourNumbers); // sends user to easy level method  
                
                System.out.println(""); // when user finishes the level 
                boolean continuePlaying = true; 
                
                while (continuePlaying == true){
                try{ // try and catch for asking user if they want to play again 
                System.out.println(ANSI_RESET+"");
                System.out.println("Would you like to play again " + userName + "?"); // asks user if they would like to play again 
                System.out.println("\t. 4 - Yes");
                System.out.println("\t. 5 - No");
                playAgain = in.nextInt(); // variable for playing again 
                continuePlaying = false; 
                break; 
            
            } // try statement 
                catch (Exception e){
                    System.out.println("Error! Please try again using the numbers corresponding with each answer :) ");
                    continuePlaying = true; 
                    in.nextLine(); 
                } // catch 
                } // while loop 
                
                if (playAgain!=4 && playAgain!=5){
                    System.out.println("Error! Please enter either 4 for yes, or 5 for no :) ");
                    continuePlaying = true; 
                    
                    while (continuePlaying == true){
                try{ // try and catch for invalid inputs for playing again
                System.out.println(ANSI_RESET+"");
                System.out.println("Would you like to play again " + userName + "?");
                System.out.println("\t. 4 - Yes");
                System.out.println("\t. 5 - No");
                playAgain = in.nextInt(); 
                continuePlaying = false; 
                break; 
            
            } // try statement 
                catch (Exception e){
                    System.out.println("Error! Please try again using the numbers corresponding with each answer :) ");
                    continuePlaying = true; 
                    in.nextLine(); 
                } // catch 
                } // while loop 
                } // if playAgain value is invalid 
                if (playAgain ==5){
                    break; 
                }
                if (playAgain ==4){
                    break; 
                }
                
                
        
            case 2: // if user selects hard level 
                totalGames++; // adds to total games played 
                hardLevelUser (userName, trueColourNumbersHard, coloursHardLevel); // sends user to hard level method 
                System.out.println(""); 
                continuePlaying = true; 
                
                while (continuePlaying == true){
                try{ // try and catch for asking user to play again 
                System.out.println("");
                System.out.println("Would you like to play again " + userName + "?");
                System.out.println("\t. 4 - Yes");
                System.out.println("\t. 5 - No");
                playAgain = in.nextInt(); 
                continuePlaying = false; 
                break; 
            
            } // try statement 
                catch (Exception e){
                    System.out.println("Error! Please try again using the numbers corresponding with each answer :) ");
                    continuePlaying = true; 
                    in.nextLine(); 
                } // catch 
                }
                
                if (playAgain!=4 && playAgain!=5){
                    System.out.println("Error! Please enter either 4 for yes, or 5 for no :) ");
                    continuePlaying = true; 
                    
                    while (continuePlaying == true){
                try{ // try and catch for asking user to play again if they inputed invalid answer 
                System.out.println("");
                System.out.println("Would you like to play again " + userName + "?");
                System.out.println("\t. 4 - Yes");
                System.out.println("\t. 5 - No");
                playAgain = in.nextInt(); 
                continuePlaying = false; 
                break; 
            
            } // try statement 
                catch (Exception e){
                    System.out.println("Error! Please try again using the numbers corresponding with each answer :) ");
                    continuePlaying = true; 
                    in.nextLine(); 
                } // catch 
                } // while loop 
                } // if playAgain value is invalid 
                if (playAgain ==5){
                    break; 
                }
                if (playAgain ==4){
                    break; 
                }
     
                
        } 
        } while (playAgain ==4); // do while loop condition, play Again must be 4, meaning it must be yes
     
     
     if (playAgain == 5){ // if user selects that they do not want to play again 
         System.out.println("Thank you for playing COLOURMASTER " + userName);
         System.out.println("You won " + wins + " games, and played " + totalGames + " games today!"); // provides user with number of wins and total games played
         System.out.println("Have a great day! : ) ");
     } // if statement 
       
    } // main method 
    
    
  public static void mainPage(String userName)throws InterruptedException{ // method dealing with introduction message and main page
      System.out.println("Welcome to...."); 
      TimeUnit.MILLISECONDS.sleep(1500); // time lag 
      String title = "COLOURMASTER"; // string with game name 
      
      for (int i = 0; i <title.length(); i++){ // for loop for the name of the game to be written out, letter by letter
          System.out.print(ANSI_RED+ANSI_WHITE_BACKGROUND+title.substring(i,i+1)+ " ");
          TimeUnit.MILLISECONDS.sleep(400); // time lag for each letter 
      }
      TimeUnit.MILLISECONDS.sleep(200); // time lag before writting user's name 
      System.out.println(ANSI_RESET); // reset colours (user's name written in opposite colour design
      System.out.print("       ");
      for (int i = 0; i < userName.length(); i++){ // for loop for the name of the user to be written out, letter by letter
          System.out.print(ANSI_WHITE+ANSI_RED_BACKGROUND+userName.substring(i,i+1) + " "); 
          TimeUnit.MILLISECONDS.sleep(300); // time lag for each letter 
      }
      System.out.println(ANSI_RESET); // reset colours
      System.out.print("     "); 
  } // mainPage method 
  
  public static int [] colourSelection (int [] colours, String [] trueColours, int [] trueColoursNumbers){ // method for randomizing the colours in the easy level 
       for (int i = 0; i < colours.length; i++){
          colours[i] = (int)(11* Math.random ()+ 1); 
          if (colours[i] == 1){
              trueColours[i] = "red"; // adds corresponding name of colour to the String array 
              trueColourNumbers[i] = 1; // adds corresponding number of colour to int array 
          }
          if (colours[i] == 2){
              trueColours[i] = "blue"; 
              trueColourNumbers[i] = 2; 
          }
          if (colours[i] == 3){
              trueColours[i] = "green"; 
              trueColourNumbers[i] = 3; 
          }
          if (colours[i] == 4){
              trueColours[i] = "yellow"; 
              trueColourNumbers[i] = 4; 
          }
          if (colours[i] == 5){
              trueColours[i] = "cyan"; 
              trueColourNumbers[i] = 5; 
          }
          if (colours[i] == 6){
              trueColours[i] = "purple"; 
              trueColourNumbers[i] = 6; 
          }
          if (colours[i] == 7){
              trueColours[i] = "pink";
              trueColourNumbers[i] = 7; 
          }
          if (colours[i] == 8){
              trueColours[i] = "orange"; 
              trueColourNumbers[i] = 8; 
          }
          if (colours[i] == 9){
              trueColours[i] = "grey";
              trueColourNumbers[i] = 9; 
          }
          if (colours[i] == 10){
              trueColours[i] = "black"; 
              trueColourNumbers[i] = 10; 
          }
          if (colours[i] == 11){
              trueColours[i] = "white"; 
              trueColourNumbers[i] = 11; 
          }
       
       }
      return colours; // returns colour array
  } // randomizing colours easy level method 
  
  
  public static void board(){ // method for board (ouputs the board)
      
      System.out.println("");
      System.out.print(ANSI_WHITE+ANSI_BLUE_BACKGROUND+"              Here are the colour options...              ");
      System.out.println("");
      System.out.print(ANSI_RED+ANSI_YELLOW_BACKGROUND+"1 - RED       ");
      System.out.print(ANSI_BLUE+ANSI_WHITE_BACKGROUND+"2 - BLUE    ");
      System.out.print(ANSI_GREEN+ANSI_YELLOW_BACKGROUND+" 3 - GREEN     "); 
      System.out.print(ANSI_YELLOW+ANSI_WHITE_BACKGROUND+"4 - YELLOW       "); 
      System.out.println("");
      System.out.print(ANSI_CYAN+ANSI_WHITE_BACKGROUND+"5 - CYAN      "); 
      System.out.print(ANSI_PURPLE+ANSI_YELLOW_BACKGROUND+"6 - PURPLE  "); 
      System.out.print(ANSI_PINK+ANSI_WHITE_BACKGROUND+" 7 - PINK      "); 
      System.out.print(ANSI_ORANGE+ANSI_YELLOW_BACKGROUND+" 8 - ORANGE      ");
      System.out.println("");
      System.out.print(ANSI_GREY+ANSI_YELLOW_BACKGROUND+"9 - GREY      ");
      System.out.print(ANSI_BLACK+ANSI_WHITE_BACKGROUND+"10 - BLACK  ");
      System.out.print(ANSI_YELLOW_BACKGROUND+ANSI_WHITE+"11 - WHITE     ");
      System.out.print(ANSI_WHITE_BACKGROUND+"                 ");
    
  }

  public static void gameInstructions (String userName) throws InterruptedExcpetion, InterruptedException{ // method explaining the instructions for the user 
      TimeUnit.MILLISECONDS.sleep(450); // sleep time to make instructions come after a few seconds, and make it easy for the user to read instructions and then begin playing 
      System.out.println("Welcome to ColourMaster " + userName + "!");
      TimeUnit.MILLISECONDS.sleep(400);
      System.out.println("If this is your first time playing, do not worry, this game is easy to learn and easy to play...");
      TimeUnit.MILLISECONDS.sleep(400);
      System.out.println("Depending on which level you select, there will either be 4 or 5 randomly seleted colours in a specific order");
      TimeUnit.MILLISECONDS.sleep(400);
      System.out.println("Your job, " + userName + ", is to guess the correct colours in each position!");
      TimeUnit.MILLISECONDS.sleep(400);
      System.out.println("If you guess the correct colour, a message will appear telling you so, and if you guess the correct colour in the correct spot, another message will tell you so (if in easy level)...");
      TimeUnit.MILLISECONDS.sleep(400);
      System.out.println("Good luck " + userName + "!");
  } // sends user back to the top, where they select the level 
   
  
  public static int [] easyLevelUser (String userName, int [] trueColourNumbers)throws InterruptedException{ // method handling the easy level and user's imputs
      Scanner in = new Scanner (System.in); 
      int userAttempts = 0; // attempts the user has had (maximum is 6)
      int colourEasyCorrect1 = 0;  // if they get position 1 correct 
      int colourEasyCorrect2 = 0; // if position 2 correct 
      int colourEasyCorrect3 = 0; 
      int colourEasyCorrect4 = 0; 
      int totalCorrect = 0; // total colours correct (if 4, user has won)
      
      
      String userAttemptsWord = "ATTEMPT"; 
      System.out.println("Welcome to the easy mode " + userName + "!");
      System.out.println("In this level, there are 4 colours, and you will have 6 attempts to guess the colours!"); // simple instructions before game
      
      boolean continueEasy = false; 
      
            
                 while (userAttempts <6 && totalCorrect < 4){ // if total correct are not 4, user has not yet won, and maximum attemots for this round is 6
                     
      board(); 
                    userAttempts++; 
          
          System.out.println("");
          System.out.println("");
            for (int i = 0; i < userAttemptsWord.length(); i++){
          System.out.print(ANSI_BLUE+ANSI_YELLOW_BACKGROUND+userAttemptsWord.substring(i,i+1) + " ");
          TimeUnit.MILLISECONDS.sleep(400); 
          
      } System.out.print(ANSI_YELLOW_BACKGROUND+ " " + userAttempts); 
            
            continueEasy = false; 
            
            while (continueEasy == false){
                
                for (int r = 0; r <4; r++){
                    
            int x = 0; 
            if (r==0 && colourEasyCorrect1 == 1){ // if user previously guessed this position correctly, do not have to guess again
                System.out.println("");
                System.out.println(ANSI_PURPLE+ANSI_WHITE_BACKGROUND+userName + " previously guessed position 1 correctly! Position 1 is " + trueColours[r] + "!");
                r++; // increases r value, to move onto next position 
            }
            if (r==1 && colourEasyCorrect2 == 1){
                System.out.println("");
                System.out.println(ANSI_PURPLE+ANSI_WHITE_BACKGROUND+userName + " previously guessed position 2 correctly! Position 2 is " + trueColours[r] + "!");
                r++; 
            }
            if (r==2 && colourEasyCorrect3 == 1){
                System.out.println("");
                System.out.println(ANSI_PURPLE+ANSI_WHITE_BACKGROUND+userName + " previously guessed position 3 correctly! Position 3 is " + trueColours[r] + "!");
                r++; 
            }
            if (r==3 && colourEasyCorrect4 == 1){
                System.out.println("");
                System.out.println(ANSI_PURPLE+ANSI_WHITE_BACKGROUND+userName + " previously guessed position 4 correctly! Position 4 is " + trueColours[r] + "!");
                r = 4; 
                break; 
            }
            try{ // try and catch for easy level colour selection 
            System.out.println("");
            System.out.println("");
            System.out.println(ANSI_WHITE+ANSI_PURPLE_BACKGROUND+"Please guess the colour in position " +(r+1));
            colourGuessEasy = in.nextInt(); 
            continueEasy = true; 
            
            } // try statement 
            
                catch (Exception e){
                    System.out.println("Error! Please try again using the numbers corresponding with each colour :) ");
                    continueEasy = false; 
                    in.nextLine(); 
                } // catch 
            
            while (colourGuessEasy > 11 || colourGuessEasy < 1){ // if input is integer but invalid 
                System.out.println("Error! The colour range is 1-11! Please try again :) ");
                continueEasy = false; 
                
                while (continueEasy == false){
             try{ // try and catch for invalid entry loop 
            System.out.println("");
             System.out.println("");
            System.out.println(ANSI_WHITE+ANSI_PURPLE_BACKGROUND+"Please guess the colour in position " +(r+1));
            colourGuessEasy = in.nextInt(); 
            continueEasy = true; 
            
            } // try statement 
            
                catch (Exception e){
                    System.out.println("Error! Please try again using the numbers corresponding with each colour :) ");
                    continueEasy = false; 
                    in.nextLine(); 
                } // catch 
            } // while loop 
            } // if statement 
            if (colourGuessEasy == trueColourNumbers[r]){ // if user guesses correct colour in correct position
                System.out.println(ANSI_WHITE+ANSI_PURPLE_BACKGROUND+"You have guessed the correct colour and the correct order of that correct! Good job " + userName + "!");
                if (r==0){
                    colourEasyCorrect1= 1; // changes variable to 1, this way user will not have to guess again
                    totalCorrect = totalCorrect + colourEasyCorrect1; // adds to total correct 
                }
                if (r==1){
                    colourEasyCorrect2 =1; 
                    totalCorrect = totalCorrect + colourEasyCorrect2; 
                }
                if (r==2){
                    colourEasyCorrect3 = 1; 
                    totalCorrect = totalCorrect + colourEasyCorrect3; 
                }
                if (r==3){
                    colourEasyCorrect4 = 1; 
                    totalCorrect = totalCorrect + colourEasyCorrect4; 
                }
            } // if the colour guessed is the correct colour in the correct position
            
            if (r==0){
            if (colourGuessEasy == trueColourNumbers[1] || colourGuessEasy == trueColourNumbers[2] || colourGuessEasy == trueColourNumbers[3]){
                System.out.println(ANSI_WHITE+ANSI_PURPLE_BACKGROUND+"You have guessed a colour which is in this sequence, just not the correct spot! You're on the right track " + userName + "!");
            }
            } // if statement for guess 1, if it is a colour in the sequence, just not in the correct position
            
            if (r==1){
            if (colourGuessEasy == trueColourNumbers[0] || colourGuessEasy == trueColourNumbers[2] || colourGuessEasy == trueColourNumbers[3]){
                System.out.println(ANSI_WHITE+ANSI_PURPLE_BACKGROUND+"You have guessed a colour which is in this sequence, just not the correct spot! You're on the right track " + userName + "!");
            } // if statement for guess 2, if it is a colour in the sequence, just not in the correct position
                }
            
            if (r==2) {
            if (colourGuessEasy == trueColourNumbers[0] || colourGuessEasy == trueColourNumbers[1] || colourGuessEasy == trueColourNumbers[3]){
                System.out.println(ANSI_WHITE+ANSI_PURPLE_BACKGROUND+"You have guessed a colour which is in this sequence, just not the correct spot! You're on the right track " + userName + "!");
            } // if statement for guess 3, if it is a colour in the sequence, just not in the correct position
            }
            
            if (r==3){
            if (colourGuessEasy == trueColourNumbers[0] || colourGuessEasy == trueColourNumbers[1] || colourGuessEasy == trueColourNumbers[2]){
                System.out.println(ANSI_WHITE+ANSI_PURPLE_BACKGROUND+"You have guessed a colour which is in this sequence, just not the correct spot! You're on the right track " + userName + "!");
            } // if statement for guess 2, if it is a colour in the sequence, just not in the correct position
            }
            
            else if (colourGuessEasy!=trueColourNumbers[0] && colourGuessEasy!=trueColourNumbers[1] && colourGuessEasy!=trueColourNumbers[2] && colourGuessEasy!=trueColourNumbers[3] && continueEasy == true) { // if colour is not in sequence (must be continueEasy == true so we can ensure it is an integer)
                System.out.println("This colour is not in the sequence :( ");
                
            }
            
                } // for loop  
                     }// while loop
            if (totalCorrect ==4){
                    System.out.println("Amazing job " + userName + "! You guessed all the colours in the correct order!");
                    wins++; 
                    break; 
                }
                     System.out.println(ANSI_BLUE_BACKGROUND+ANSI_WHITE+userName + " has " + (6-userAttempts) + " attempts left!");
  } // while statement 
                 
                 if (userAttempts == 0){
                 System.out.println(ANSI_BLUE_BACKGROUND+ANSI_WHITE+"Oh no " + userName + "! You are all out of attempts! :( ");
                 }
    
    
    return trueColourNumbers; 
    
  } // easyLevelUser
  
  
  public static int [] hardLevelUser (String userName, int [] trueColourNumbersHard, int [] coloursHardLevel) throws InterruptedException{
      Scanner in = new Scanner (System.in); 
      
      hardLevelColourSelection (coloursHardLevel, trueColoursHardLevel, trueColourNumbersHard);
      
      int cluesUserSelect = 0; 
      int correctColour = 0; 
      int totalCorrect = 0; 
      int userAttempts = 0; 
      int clues = 2; // amount of clues user has
      int colourHardCorrect1 = 0; 
      int colourHardCorrect2 = 0; 
      int colourHardCorrect3 = 0; 
      int colourHardCorrect4 = 0; 
      int colourHardCorrect5 = 0; 
      
      
      String userAttempt = "ATTEMPT"; 
      boolean cont = false; 
       
      System.out.println("Oooooh, there is a brave user today...");
      System.out.println("Welcome to the hard level " + userName + ", do you believe you are up for the challenge?"); // instructions for hard level 
      System.out.println("In this level, there  are 5 colours to guess in the correct positions...");
      System.out.println("But... you will only get a message when you guess the correct colour in the correct order!");
      System.out.println("Throughout the 8 attempts, you can call for clues, you have a total of 2 clues....");
      
      
      
      while (userAttempts <8 && totalCorrect < 5){ // must have less than 5 correct (if 5 correct, user has won) and must have attempts under 8 
          
      board(); 
          userAttempts ++; 
           System.out.println("");
          System.out.println("");
            for (int i = 0; i < userAttempt.length(); i++){
          System.out.print(ANSI_WHITE+ANSI_PURPLE_BACKGROUND+userAttempt.substring(i,i+1) + " ");
          TimeUnit.MILLISECONDS.sleep(400); 
          
      } System.out.print(ANSI_PURPLE_BACKGROUND+ " " + userAttempts); 
      
              cont = false; 
              
          while (cont == false){
              for (int i = 0; i < 5; i++){
                  
              if (i==0 && colourHardCorrect1 == 1){ // if user previously guessed this position correctly, they do not have to guess again
                System.out.println("");
                System.out.println(ANSI_CYAN+ANSI_WHITE_BACKGROUND+userName + " previously guessed position 1 correctly! Position 1 is " + trueColoursHardLevel[i] + "!");
                i++; 
            }
            if (i==1 && colourHardCorrect2 == 1){
                System.out.println("");
                System.out.println(ANSI_CYAN+ANSI_WHITE_BACKGROUND+userName + " previously guessed position 2 correctly! Position 2 is " + trueColoursHardLevel[i] + "!");
                i++; 
            }
            if (i==2 && colourHardCorrect3 == 1){
                System.out.println("");
                System.out.println(ANSI_CYAN+ANSI_WHITE_BACKGROUND+userName + " previously guessed position 3 correctly! Position 3 is " + trueColoursHardLevel[i] + "!");
                i++; 
            }
            if (i==3 && colourHardCorrect4 == 1){
                System.out.println("");
                System.out.println(ANSI_CYAN+ANSI_WHITE_BACKGROUND+userName + " previously guessed position 4 correctly! Position 4 is " + trueColoursHardLevel[i] + "!");
                i++; 
            }
            if (i==4 && colourHardCorrect5 == 1){
                System.out.println("");
                System.out.println(ANSI_CYAN+ANSI_WHITE_BACKGROUND+userName + " previously guessed position 5 correctly! Position 5 is " + trueColoursHardLevel[i] + "!");
                i = 5;
                break; 
            }
            cont = false; 
            while (cont == false){
              try{ // try and catch for user's input for hard level 
                  System.out.println("");
                  System.out.println("");
                  System.out.println("Please enter your guess for the colour in position " + (i+1));
                  colourGuessHard = in.nextInt();
                  cont = true;
              }
              
              catch (Exception e){
                  System.out.println("Error! Please enter the corresponding number for a colour!");
                  cont = false; 
                  in.nextLine(); 
              } // catch 
            }
              while (colourGuessHard > 11 || colourGuessHard < 0){
                  System.out.println("Error! Please enter a number from 1-11! Please try again :) ");
                  cont = false; 
                  
                  while (cont == false)
                  try{
                  System.out.println("");
                  System.out.println("");
                  System.out.println("Please enter your guess for position " + (i+1));
                  colourGuessHard = in.nextInt();
                  cont = true;
              }
              
              catch (Exception e){
                  System.out.println("Error! Please enter the corresponding number for a colour!");
                  cont = false; 
                  in.nextLine(); 
              } // catch 
              } // while for if invalid entry 
              
              if (colourGuessHard == trueColourNumbersHard[i]){ // if user guesses correctly 
                System.out.println(ANSI_BLUE+ANSI_WHITE_BACKGROUND+"You have guessed the correct colour and the correct order of that correct! Good job " + userName + "!");
                if (i == 0){
                    colourHardCorrect1 = 1; 
                    totalCorrect++; 
                }
                if (i == 1){
                    colourHardCorrect2 = 1; 
                    totalCorrect++; // adds to total correct 
                }
                if (i == 2){
                    colourHardCorrect3 = 1; 
                    totalCorrect++; 
                }
                if (i == 3){
                    colourHardCorrect4 = 1; 
                    totalCorrect++; 
                }
                if (i == 4){
                    colourHardCorrect5 = 1; 
                    totalCorrect++; 
                }
            }
              
            if (colourGuessHard == trueColourNumbersHard[0] || colourGuessHard == trueColourNumbersHard[1] || colourGuessHard == trueColourNumbersHard[2] || colourGuessHard == trueColourNumbersHard[3] || colourGuessHard == trueColourNumbersHard[4]){
                correctColour++; 
            }
                 
          } // for loop
              } // while loop
          
            if (totalCorrect == 5){ // if user has guessed all correctly 
                System.out.println(ANSI_WHITE_BACKGROUND+ANSI_BLUE+"You guessed all the correct colours in their correct position! Great Job " + userName + " :) ");
                wins++;  // adds to number of wins 
                break; 
            }
            
            boolean continueClue = false; 
              
              while (continueClue == false){
              try{ // try catch for the clue asking 
                System.out.println("");
               System.out.println(ANSI_CYAN_BACKGROUND+ANSI_BLACK+"Would you like to use one of your clues " + userName + "?");
                  System.out.println(ANSI_CYAN+ANSI_WHITE_BACKGROUND+"\t. 1 - Yes");
                  System.out.println(ANSI_CYAN+ANSI_WHITE_BACKGROUND+"\t. 2 - No");
                  cluesUserSelect = in.nextInt(); 
                  continueClue = true; 
                  
              }
              catch (Exception e) {
                  System.out.println("Error! Please enter 1 for yes, and 2 for no!");
                  continueClue = false; 
                  in.nextLine(); 
              }
              } // while statement 
                  if (clues == 0){ // if there are no more clues avaible to be used 
                      System.out.println("Oh no! " + userName + ", it appears you are all out of clues :( ");
                  }
                  
                  if (cluesUserSelect!=1 && cluesUserSelect!=2){
                      System.out.println("Error! Please enter either 1 for yes, or 2 for no! Please try again :) ");
                      cluesUserSelect = in.nextInt();
              while (continueClue == false){
              try{
               System.out.println(ANSI_CYAN_BACKGROUND+ANSI_BLACK+"Would you like to use one of your clues " + userName + "?"); // asks user again, if they input something invalid 
                  System.out.println(ANSI_CYAN+ANSI_WHITE_BACKGROUND+"\t. 1 - Yes");
                  System.out.println(ANSI_CYAN+ANSI_WHITE_BACKGROUND+"\t. 2 - No");
                  cluesUserSelect = in.nextInt(); 
                  continueClue = true; 
                  
              }
              catch (Exception e) {
                  System.out.println("Error! Please enter 1 for yes, and 2 for no!"); // if user inputs string or something other than integer 
                  continueClue = false; 
                  in.nextLine();
              } // catch statement 
              } // while statement 
                  } // if statement 
                  if (continueClue == true){ // if user choses to use a clue 
                      
                      if (cluesUserSelect==1 && clues!=0){ // ensures that user has clues remaining and selected correct integer 
                          System.out.println("You are about to use one of your clues! You have " + (clues-1) + " clues left " + userName + "!");
                          int clueNumber = (int)(3 * Math.random () + 1); // randomizes which clue is used
                          int i = (int)(5 * Math.random () + 0); // randomizes the position/colour revealed 
                          if (clueNumber == 1 && clues!=0){ 
                              System.out.println(userName + " has guessed " + correctColour + " correct colours so far!"); // first clue: how many colours the user has guessed correct (not in correct position)
                          }
                          if (clueNumber == 2 && clues!=0){
                              System.out.println("One of the colours in this sequence is " + trueColoursHardLevel[i]); // second clue: reveals one colour (not position)
                          }
                          if (clueNumber == 3 && clues!=0){
                              while (i ==0 && colourHardCorrect1 == 1 || i ==1 && colourHardCorrect2 == 1 || i ==2 && colourHardCorrect3 == 1 || i ==3 && colourHardCorrect4 == 1 || i ==4&& colourHardCorrect5 == 1){ // ensures that position revealed the user has not already guessed correctly to make clue fair
                                 i = (int)(5 * Math.random () + 0); // randomizes again, if position already guessed by user 
                              }
                              System.out.println("Colour " + trueColourNumbersHard[i] + " is " + trueColoursHardLevel[i] + "!"); // third clue: reveals both colour and posotion 
                          }
                          clues = clues - 1; 
                      }
                          
                      if (cluesUserSelect==2){
                          System.out.println("You have " + clues + " clues left " + userName + "!");
                      }
                          
                  }
            
            System.out.println(ANSI_WHITE_BACKGROUND+ANSI_BLUE+userName + " has " + (8- userAttempts) + " attempts left!");
      
      } // main while 
      
      if (userAttempts == 0){
          System.out.println("Oh no " + userName + "! You ran out of attempts :( "); // when user attempts are zero and they have not won the game
      }
      
      
      return trueColourNumbersHard; 
  }
  
  public static int [] hardLevelColourSelection (int [] coloursHardLevel, String [] trueColoursHardLevel, int [] trueColourNumbersHard){ // method for randomizing the colours in the hard level 
       for (int i = 0; i < coloursHardLevel.length; i++){ // for loop random number generator, ensures it loops enough times to fill array 
          coloursHardLevel[i] = (int)(11* Math.random ()+ 1); 
          if (coloursHardLevel[i] == 1){ 
              trueColoursHardLevel[i] = "red"; // sets corresponding names of colours with their corresponding colours 
              trueColourNumbersHard[i] = 1; // gives the trueColourNumberHard array (array that user's inputs are compared with) the appropriate values 
          }
          if (coloursHardLevel[i] == 2){
              trueColoursHardLevel[i] = "blue"; 
              trueColourNumbersHard[i] = 2; 
          }
          if (coloursHardLevel[i] == 3){
              trueColoursHardLevel[i] = "green"; 
              trueColourNumbersHard[i] = 3; 
          }
          if (coloursHardLevel[i] == 4){
              trueColoursHardLevel[i] = "yellow"; 
              trueColourNumbersHard[i] = 4; 
          }
          if (coloursHardLevel[i] == 5){
              trueColoursHardLevel[i] = "cyan"; 
              trueColourNumbersHard[i] = 5; 
          }
          if (coloursHardLevel[i] == 6){
              trueColoursHardLevel[i] = "purple"; 
              trueColourNumbersHard[i] = 6; 
          }
          if (coloursHardLevel[i] == 7){
              trueColoursHardLevel[i] = "pink";
              trueColourNumbersHard[i] = 7; 
          }
          if (coloursHardLevel[i] == 8){
              trueColoursHardLevel[i] = "orange"; 
              trueColourNumbersHard[i] = 8; 
          }
          if (coloursHardLevel[i] == 9){
              trueColoursHardLevel[i] = "grey";
              trueColourNumbersHard[i] = 9; 
          }
          if (coloursHardLevel[i] == 10){
              trueColoursHardLevel[i] = "black"; 
              trueColourNumbersHard[i] = 10; 
          }
          if (coloursHardLevel[i] == 11){
              trueColoursHardLevel[i] = "white"; 
              trueColourNumbersHard[i] = 11; 
          }
       
       }
      
      return coloursHardLevel; 
  }  
  
  
} // class 
