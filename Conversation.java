import java.util.stream.IntStream;
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
        String[] transcript_responses = new String[num_of_rounds + num_of_rounds];

        //create an array of canned responses
        String[] canned_responses = {
            "Mmm-hm.",
            "I see what you mean.",
            "Wow.",
            "That's crazy.",
            "HOT DOG"
        };

        //chatbot
        int counter = 0;
        //tcount = transcript counter
        int tcount = -1;
        System.out.println("Hi there! What's on your mind?");
        while (counter < num_of_rounds) {
            counter += 1;
            String userInput = sc.nextLine();
            //put user response in the transcript
            tcount += 1;
            transcript_responses[tcount] = userInput;

            // if userInput does include mirror words repeat with a question
            if (userInput.contains("I ") || userInput.contains("me ") || userInput.contains("am ") || userInput.contains("you ") || userInput.contains("my ") || userInput.contains("your ")) {
                //break userInput into words
                String[] words = userInput.split("\\s");
                int words_length = words.length;
                //iterate through each word
                for (int i = 0; i < words.length; i++) {
                    if (words[i].equals("I")) {
                        words[i] = words[i].replace("I", "you");
                    } else if (words[i].equals("me")) {
                        words[i] = words[i].replace("me", "you");
                    } else if (words[i].equals("am")) {
                        words[i] = words[i].replace("am", "are");
                    } else if (words[i].equals("you")) {
                        words[i] = words[i].replace("you", "I");
                    } else if (words[i].equals("my")) {
                        words[i] = words[i].replace("my", "your");
                    } else if (words[i].equals("your")) {
                        words[i] = words[i].replace("your", "my");
                    } else if (words[i].equals("are")) {
                        words[i] = words[i].replace("are", "am");
                    }
                }

                //upper case first letter in sentence
                words[0] = Character.toUpperCase(words[0].charAt(0)) + words[0].substring(1);

                //add punctuation
                if ((words[words_length - 1].contains(".")) || (words[words_length - 1].contains("!")) || (words[words_length - 1].contains("?"))) {
                    words[words_length - 1] = words[words_length - 1].replace(".", "?");
                    words[words_length - 1] = words[words_length - 1].replace("!", "?");
                } else {
                    words[words_length - 1] += "?";
                }

                //put userInput back together
                String result = String.join(" ", words);

                //capitalizes letters after punctuation
                boolean periodCheck = result.contains(". ");
                if (periodCheck){
                  int index_num = result.indexOf(".");
                  char capital_char = Character.toUpperCase(result.charAt(index_num+2));
                  result = result.substring(0,index_num + 2) + capital_char + result.substring(index_num + 3);
                }
                
                // if (result.contains(". ")||result.contains("! ")||result.contains("? ")){
                //   int index_num = result.indexOf(".");
                //   char capital_char = Character.toUpperCase(result.charAt(index_num+2));
                //   result = result.substring(0,index_num + 2) + capital_char + result.substring(index_num + 3);
                // }

                //print result
                System.out.println(result);
                tcount += 1;
                transcript_responses[tcount] = result;

                //if userInput doesn't include any mirror words say random canned response: mmmhmmm, ok, yes, I see what you mean
            } else {
                //chooses a random number between 0 and canned_response_length
                int random_response_number = random.nextInt(canned_responses.length);
                //uses random number to print random response
                String result = canned_responses[random_response_number];
                System.out.println(result);
                tcount += 1;
                transcript_responses[tcount] = result;
            }
        }

        System.out.println("See ya!");

        String line = sc.nextLine();

        //transcript: add each line add to an array where we can print out them all together
        System.out.println("\n");
        System.out.println("TRANSCRIPT:");
        System.out.println("Hi there! What's on your mind?");
        for (String response: transcript_responses) {
            System.out.println(response);
        }
        System.out.println("See ya!");
    }
}




