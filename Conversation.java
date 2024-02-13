import java.util.Scanner;

class Conversation {

  public static void main(String[] arguments) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("How many rounds?");
    //takes user input
    int num_of_rounds = sc.nextInt();
    sc.nextLine();

    System.out.println(num_of_rounds);
    
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
        System.out.println("mmmhmmm");
      }
    }
    
    System.out.println("See ya!");
  
  
  
  
  
  
  
  
  
  
  
  }
}
