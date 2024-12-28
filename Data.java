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
public class Data {

    // Variables for grading calculations
    int weight; // Weight of the grade component
    int scoreEarned; // Score earned by the student
    int totalPoints; // Total points after optional shifting
    float weightedScore; // Weighted score calculation
    int assignment; // Number of assignments
    int assignmentScore; // Total assignment score
    int assignmentMax; // Maximum possible score for assignments
    int attendance; // Attendance points
    int totalWeight; // Total weight of all components
    float totalWeightedScore; // Total weighted score of all components
    Scanner sc = new Scanner(System.in); // Scanner object for input

    /**
     * Default constructor
     */
    public Data() {
    }

    /**
     * Parameterized constructor to initialize the Data object with given
     * values.
     *
     * @param weight The weight of the grade component
     * @param scoreEarned The score earned by the student
     * @param totalPoints The total points after optional shifting
     * @param weightedScore The weighted score calculation
     * @param assignment The number of assignments
     * @param assignmentScore The total assignment score
     * @param assignmentMax The maximum possible score for assignments
     * @param attendance The attendance points
     * @param totalWeight The total weight of all components
     * @param totalWeightedScore The total weighted score of all components
     */
    public Data(int weight, int scoreEarned, int totalPoints, float weightedScore, int assignment, int assignmentScore, int assignmentMax, int attendance, int totalWeight, float totalWeightedScore) {
        this.weight = weight;
        this.scoreEarned = scoreEarned;
        this.totalPoints = totalPoints;
        this.weightedScore = weightedScore;
        this.assignment = assignment;
        this.assignmentScore = assignmentScore;
        this.assignmentMax = assignmentMax;
        this.attendance = attendance;
        this.totalWeight = totalWeight;
        this.totalWeightedScore = totalWeightedScore;
    }

    /**
     * Getter for weight.
     *
     * @return The weight of the current component
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Setter for weight.
     *
     * @param weight The weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Getter for scoreEarned.
     *
     * @return The score earned by the student
     */
    public int getScoreEarned() {
        return scoreEarned;
    }

    /**
     * Setter for scoreEarned.
     *
     * @param scoreEarned The score earned to set
     */
    public void setScoreEarned(int scoreEarned) {
        this.scoreEarned = scoreEarned;
    }

    /**
     * Getter for weightedScore.
     *
     * @return The weighted score of the current component
     */
    public float getWeightedScore() {
        return weightedScore;
    }

    /**
     * Setter for weightedScore.
     *
     * @param weightedScore The weighted score to set
     */
    public void setWeightedScore(float weightedScore) {
        this.weightedScore = weightedScore;
    }

    /**
     * Getter for assignment.
     *
     * @return The number of assignments
     */
    public int getAssignment() {
        return assignment;
    }

    /**
     * Setter for assignment.
     *
     * @param assignment The number of assignments to set
     */
    public void setAssignment(int assignment) {
        this.assignment = assignment;
    }

    /**
     * Getter for assignmentScore.
     *
     * @return The total score earned from assignments
     */
    public int getAssignmentScore() {
        return assignmentScore;
    }

    /**
     * Setter for assignmentScore.
     *
     * @param assignmentScore The total score earned to set
     */
    public void setAssignmentScore(int assignmentScore) {
        this.assignmentScore = assignmentScore;
    }

    /**
     * Getter for assignmentMax.
     *
     * @return The maximum possible score from assignments
     */
    public int getAssignmentMax() {
        return assignmentMax;
    }

    /**
     * Setter for assignmentMax.
     *
     * @param assignmentMax The maximum possible score to set
     */
    public void setAssignmentMax(int assignmentMax) {
        this.assignmentMax = assignmentMax;
    }

    /**
     * Getter for attendance.
     *
     * @return The attendance points
     */
    public int getAttendance() {
        return attendance;
    }

    /**
     * Setter for attendance.
     *
     * @param attendance The attendance points to set
     */
    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    /**
     * Getter for totalPoints.
     *
     * @return The total points after considering score shifting
     */
    public int getTotalPoints() {
        return totalPoints;
    }

    /**
     * Setter for totalPoints.
     *
     * @param totalPoints The total points to set
     */
    public void setTotalPoints(int totalPoints) {
        this.totalPoints = this.totalPoint(); // Calculate total points based on score shifting
    }

    /**
     * Getter for totalWeight.
     *
     * @return The cumulative weight of all components
     */
    public int getTotalWeight() {
        return totalWeight;
    }

    /**
     * Setter for totalWeight.
     *
     * @param totalWeight The cumulative weight to set
     */
    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    /**
     * Getter for totalWeightedScore.
     *
     * @return The cumulative weighted score
     */
    public float getTotalWeightedScore() {
        return totalWeightedScore;
    }

    /**
     * Setter for totalWeightedScore.
     *
     * @param totalWeightedScore The cumulative weighted score to set
     */
    public void setTotalWeightedScore(float totalWeightedScore) {
        this.totalWeightedScore = totalWeightedScore;
    }

    /**
     * Method to calculate total points with optional score shifting. Prompts
     * the user to choose between score shifting or not.
     *
     * @return total points after optional score shifting
     */
    public int totalPoint() {
        String newString;
        int scoresShifted;
        int n;
        boolean result;
        GradeStudent input = new GradeStudent();
        do {
            if (scoreEarned == 100) {
                totalPoints = scoreEarned;
                result = true;
            } else {
                System.out.print("Were scores shifted (1 = yes, 2=no): ");
                newString = sc.nextLine();  // Prompt user for input
                if (newString.matches("[1]")) { // If user chooses to shift the score
                    System.out.print("Shift amount: ");
                    scoresShifted = input.checkInput(1, 100 - scoreEarned);
                    totalPoints = scoreEarned + scoresShifted; // Ensure the total points do not exceed 100
                    result = true;
                } else if (newString.matches("[2]")) {// If user chooses not to shift the score
                    totalPoints = scoreEarned;
                    result = true;

                } else {  // If user input is invalid
                    System.out.println("Please enter either '1' or '2'.");
                    result = false;
                }
            }
        } while (!result);
        return this.totalPoints;
    }

    /**
     * Method to calculate weighted score based on the weight and total points.
     *
     * @return weighted score
     */
    public float weightedScore() {
        totalWeight += weight;
        weightedScore = weight * ((float) totalPoints / 100);
        totalWeightedScore += this.weightedScore;
        return weightedScore;

    }

    /**
     * Method to calculate total assignment points. Prompts the user to enter
     * scores and max scores for each assignment. Ensures the total scores do
     * not exceed 150.
     */
    public void calculateAssignmentPoint() {
        GradeStudent input = new GradeStudent();
        assignmentScore = 0;
        assignmentMax = 0;
        int score;
        int max;
        for (int i = 1; i < assignment + 1; i++) { // Loop through each assignment
            boolean result;
            do {
                System.out.println("Assignment " + i);
                System.out.print("Score: ");
                score = input.checkInput(0, 100);
                System.out.print("Max score: ");
                max = input.checkInput(0, 100);
                if (score > max) {   // Ensure score does not exceed max score
                    System.out.println("The number of points achieved must be less than or equal to the maximum score!");
                    result = false;
                } else {
                    result = true;
                }
            } while (!result);
            assignmentScore += score;
            assignmentMax += max;
            if (assignmentScore >= 150) {  // Ensure the total assignment scores do not exceed 150
                assignmentScore = 150;
            }
            if (assignmentMax >= 150) {
                assignmentMax = 150;
            }
        }

    }

    /**
     * Method to calculate attendance points. Prompts the user to enter the
     * number of sections attended and calculates points. Ensures the total
     * attendance points do not exceed 30.
     */
    public void attendance() {
        GradeStudent input = new GradeStudent();
        System.out.print("How many sections did you attend: ");
        attendance = input.CheckAttendance(this.assignment, 6);
        attendance = attendance * 5;
        if (attendance >= 30) {      // Ensure the total attendance points do not exceed 30
            attendance = 30;
            System.out.println("Section pointllllls: 30 / 30");
        } else {
            System.out.println("Section points: " + attendance + " / 30");
        }
        assignmentScore += attendance;
        assignmentMax += 30;
        System.out.println("Total Points: " + assignmentScore + " / " + assignmentMax);
    }

    /**
     * Method to calculate the weighted score for assignments.
     *
     * @return weighted score for assignments
     */
    public float weightedScoreAssignment() {

        totalWeight += weight;
        float weightedScoreAssignment = ((float) assignmentScore / assignmentMax) * weight;
        totalWeightedScore += weightedScoreAssignment;
        return weightedScoreAssignment;

    }

    /**
     * Method to calculate the minimum grade based on total weighted score.
     *
     * @return minimum grade
     */
    public float minGrade() {
        float gpa;

        if (totalWeightedScore >= 85) {
            gpa = 3;
        } else if (totalWeightedScore <= 84.99 && totalWeightedScore >= 75) {
            gpa = 2;
        } else if (totalWeightedScore <= 74.99 && totalWeightedScore >= 60) {
            gpa = (float) 0.7;
        } else {
            gpa = 0;
        }
        return gpa;
    }

}
