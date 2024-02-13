import java.util.Scanner;
import java.util.Random;

class Conversation {

  public static void main(String[] arguments) {
    
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    
    //number of rounds
    System.out.println("How many rounds?");
    //takes user's integer input
    int num_of_rounds = sc.nextInt();
    sc.nextLine();
    System.out.println("\n");
    
    //create an array to store responses
    String[] transcript_responses = new String[num_of_rounds];
    
    //create an array of canned responses
    String[] canned_responses = {"Mmm-hm.", "I see what you mean.", "Wow.", "That's crazy.", "HOT DOG"};
    int canned_responses_length = canned_responses.length;

    //chatbot
    int counter = 0;
    System.out.println("Hi there! What's on your mind?");
    while (counter < num_of_rounds){
      counter += 1;
      String userInput = sc.nextLine();
      //lowercase whole string? need to make upper and lower cases of words work .equalsIgnoreCase
      
      // if userInput does include mirror words repeat with a question
      if (userInput.contains("I") || userInput.contains("me") || userInput.contains("am") || userInput.contains("you") || userInput.contains("my") || userInput.contains("your")){
        // //break userInput into words
        String[] words = userInput.split("\\s");
        int words_length = words.length;
        //iterate through each word
        for (int i = 0; i < words.length; i++){
          if (words[i].contains("I")){
            words[i] = words[i].replace("I","you");
          }
          else if (words[i].contains("me")){
            words[i] = words[i].replace("me", "you");
          }
          else if (words[i].contains("am")){
            words[i] = words[i].replace("am", "are");
          }
          else if (words[i].contains("you")){
            words[i] = words[i].replace("you", "I");
          }
          else if (words[i].contains("my")){
            words[i] = words[i].replace("my", "your");
          }
          else if (words[i].contains("your")){
            words[i] = words[i].replace("your", "my");
          }
          else if (words[i].contains("are")){
            words[i] = words[i].replace("are", "am");
          }
        
        System.out.println(words[i]);
        }

        //upper case first letter in sentence
        words[0] = Character.toUpperCase(words[0].charAt(0)) + words[0].substring(1);
        System.out.println(words[0]);
        
        //add punctuation
        if ((words[words_length-1].contains("."))||(words[words_length-1].contains("!"))||(words[words_length-1].contains("?"))){
          words[words_length-1].replace(".", "?");
          words[words_length-1].replace("!", "?");
        } else {
          words[words_length-1] += "?";
        }

        //put userInput back together
        String result = String.join(" ", words);
        System.out.println(result);

        //if userInput doesn't include any mirror words say random canned response: mmmhmmm, ok, yes, I see what you mean
      } else {
        //chooses a random number between 0 and canned_response_length
        int random_response_number = random.nextInt(canned_responses_length);
        //uses random number to print random response
        System.out.println(canned_responses[random_response_number]);
      }
    }
    
    System.out.println("See ya!");
  
    //transcript: each line add to an array where we can print out them all together?
    System.out.println("\n");
    System.out.println("TRANSCRIPT:");
  
  
  
  
  
  
  
  
  }
}




