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
    System.out.println(num_of_rounds);
    
    //create an array of canned responses
    String[] canned_responses = {"Mmm-hm.", "I see what you mean.", "Wow.", "That's crazy.", "HOT DOG"};
    int canned_responses_length = canned_responses.length;

    //chatbot
    int counter = 0;
    System.out.println("Hi there! What's on your mind?");
    while (counter < num_of_rounds){
      counter += 1;
      String userInput = sc.nextLine();
      
      // if userInput does include mirror words repeat with a question
      if (userInput.contains("I") || userInput.contains("me") || userInput.contains("am") || userInput.contains("you") || userInput.contains("my") || userInput.contains("your")){
        System.out.println(userInput + "?");
      
        //if userInput doesn't include any mirror words say random canned response: mmmhmmm, ok, yes, I see what you mean
      } else {
        //chooses a random number between 0 and canned_response_length
        int random_response_number = random.nextInt(canned_responses_length);
        //uses random number to print random response
        System.out.println(canned_responses[random_response_number]);
      }
    }
    
    System.out.println("See ya!");
  
  
  
  
  
  
  
  
  
  
  
  }
}
