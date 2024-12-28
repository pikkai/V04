/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package v04;

import java.util.Scanner;

/**
 *
 ** V04 - Grade Student.
 *
 * @author LinhTTMCE181161
 */
public class GradeStudent {

    Data input = new Data();
    Scanner sc = new Scanner(System.in);

    /**
     * Method to begin the program. Displays
     */
    public void begin() {
        System.out.println("This program reads exam/homework scores and reports your overall course grade");
    }

    /**
     * Method to check and validate input within a specified range.
     *
     * @param min The minimum valid value
     * @param max The maximum valid value
     * @return The validated input
     */
    public int checkInput(int min, int max) {
        int number;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String input = sc.nextLine().trim();// Read and trim the input
                if (input.isEmpty()) {// Check if the input is empty
                    System.out.println("Please enter a non-empty value.");
                    continue;
                }
                number = Integer.parseInt(input);// Parse the input to an integer
                if (number < min || number > max) {// Validate the input range
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                    continue;
                }
                break;// Exit the loop if the input is valid
            } catch (NumberFormatException e) {
                System.out.println("The number entered must be an integer!");// Display error message if input is not an integer
            }
        }
        return number;// Return the valid input
    }

    /**
     * Prompts the user to input an integer number that meets a minimum value
     * requirement.
     *
     * @param min The minimum acceptable value for the input number.
     * @param max The maximum acceptable value for the input number.
     * @return The valid integer number entered by the user that is greater than
     * or equal to the specified minimum value and less than the specified
     * maximum value.
     */
    public int CheckAttendance(int min, int max) {
        int number;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String input = sc.nextLine().trim();// Read and trim the input
                if (input.isEmpty()) {// Check if the input is empty
                    System.out.println("Please enter a non-empty value.");
                    continue;
                }
                number = Integer.parseInt(input);// Parse the input to an integer
                if (number < min || number > max) {// Validate the input range
                    System.out.println("Please enter a number greater than or equal " + min + " and less than " + max);
                    System.out.print("Please re-enter. How many sessions have you attended: ");
                    continue;
                }
                break;// Exit the loop if the input is valid
            } catch (NumberFormatException e) {
                System.out.println("The number entered must be an integer!");// Display error message if input is not an integer
            }
        }
        return number;// Return the valid input
    }

    /**
     * Method to handle midterm score input and calculation. Prompts the user
     * for weight, score earned, and optional score shifting.
     */
    public void midTerm() {
        System.out.println("Midterm:");
        System.out.print("Weight (0-99): ");
        this.input.weight = checkInput(0, 99);
        if (this.input.weight > 0) {
            System.out.print("Score earned: ");
            this.input.scoreEarned = checkInput(0, 100);
            System.out.println("Total points = " + this.input.totalPoint() + " / 100");
            System.out.printf("Weighted score: %.1f / %d ", this.input.weightedScore(), this.input.weight);
        }

    }

    /**
     * Method to handle final term score input and calculation. Prompts the user
     * for weight, score earned, and optional score shifting.
     */
    public void finalTerm() {
        System.out.println("\n\nFinal:");
        if ((100 - this.input.totalWeight) > 1) {
            System.out.print("Weight (1-" + (100 - this.input.totalWeight) + "): ");
            this.input.weight = checkInput(1, (100 - this.input.totalWeight));
        } else if ((100 - this.input.totalWeight) == 1) {
            System.out.println("Weight : 1");
            this.input.weight = 1;
        }
        System.out.print("Score earned: ");
        this.input.scoreEarned = checkInput(0, 100);
        System.out.println("Total points = " + this.input.totalPoint() + " / 100");
        System.out.printf("Weighted score: %.1f / %d \n", this.input.weightedScore(), this.input.weight);

    }

    /**
     * Method to handle homework score input and calculation. Prompts the user
     * for weight, number of assignments, and attendance.
     */
    public void homework() {
        if (this.input.totalWeight < 100) {
            System.out.println("\n\nHomework:");
            System.out.print("Weight : " + (100 - this.input.totalWeight));
            this.input.weight = 100 - this.input.totalWeight;
            System.out.print("\nNumber of assignments? ");
            this.input.assignment = checkInput(1, 6);
            this.input.calculateAssignmentPoint();
            this.input.attendance();
            System.out.printf("Weighted score: %.1f / %d \n", this.input.weightedScoreAssignment(), this.input.weight);
        }
    }

    /**
     * Method to generate and display the final report. Calculates and displays
     * the overall percentage and minimum grade.
     */
    public void report() {
        System.out.printf("\nOverall percentage: %.1f \n", this.input.totalWeightedScore);
        System.out.printf("Your grade will be at least: %.1f \n ", this.input.minGrade());
        System.out.println("<< Your custom grade message here >>");
    }
}
