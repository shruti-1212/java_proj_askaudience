package java_proj;
import java.util.*;

public class askTheAudience {

	public askTheAudience(Question currentQuestion) throws InterruptedException {

	    System.out.println("Audience is getting ready to vote...");
	    Thread.sleep(1000);

	    System.out.println("Audience is thinking...");
	    Thread.sleep(1500);

	    System.out.println("Audience is submitting their votes...");
	    Thread.sleep(2000);

	    // Simulate audience votes
	    Random random = new Random();
	    int correctAnswerPercentage = random.nextInt(31) + 50; // Correct answer gets 50% to 81%
	    int remainingPercentage = 100 - correctAnswerPercentage;
	    // Generate percentages for incorrect options
	    int option1 = random.nextInt(remainingPercentage - 2); // Ensure at least 2% left for others
	    int option2 = random.nextInt(remainingPercentage - option1 - 1);
	    int option3 = remainingPercentage - option1 - option2;

	    // Store options in a list
	    List<String> options = new ArrayList<>(List.of("A", "B", "C", "D"));

	    // Get the correct answer letter
	    String correctAnswerLetter = currentQuestion.getAnswerLetter().toUpperCase();
	    // Variables to store the percentages for each option
	    int percentA = 0, percentB = 0, percentC = 0, percentD = 0;

	    // Assign the correct answer percentage to the correct option
	    if (correctAnswerLetter.equals("A")) {
	        percentA = correctAnswerPercentage;
	    } else if (correctAnswerLetter.equals("B")) {
	        percentB = correctAnswerPercentage;
	    } else if (correctAnswerLetter.equals("C")) {
	        percentC = correctAnswerPercentage;
	    } else if (correctAnswerLetter.equals("D")) {
	        percentD = correctAnswerPercentage;
	    }
	 // Remove the correct answer letter from the options list
	    options.remove(correctAnswerLetter);
	    
	    // Assign remaining percentages to the other options
        int[] remainingPercentages = {option1, option2, option3};
        int index = 0;

        // Use while loop to assign remaining percentages to the options
        while (!options.isEmpty()) {
            String letter = options.remove(0); // Get the next option from the list
            if (letter.equals("A") && percentA == 0) {
                percentA = remainingPercentages[index];
            } else if (letter.equals("B") && percentB == 0) {
                percentB = remainingPercentages[index];
            } else if (letter.equals("C") && percentC == 0) {
                percentC = remainingPercentages[index];
            } else if (letter.equals("D") && percentD == 0) {
                percentD = remainingPercentages[index];
            }
            index++;
        }
	    
	    System.out.println("<<------Audience Votes are as follows------>>");
	    System.out.println("A -->> " + percentA + "%");
        System.out.println("B -->> " + percentB + "%");
        System.out.println("C -->> " + percentC + "%");
        System.out.println("D -->> " + percentD + "%");
}}


