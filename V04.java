/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package v04;

/**
 *
 ** V04 - Grade Student.
 *
 * @author LinhTTMCE181161
 */
public class V04 {

    /**
     * The main method.
     *
     * @param args argument of main method.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GradeStudent input = new GradeStudent();  // Create an instance of the GradeStudent class
        input.begin(); // Start the grading process
        input.midTerm();// Process midterm grades
        input.finalTerm(); // Process finalterm grades 
        input.homework();// Process homework grades
        input.report();  // Generate and display the final report
    }

}
