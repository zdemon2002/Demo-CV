/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixkeanu;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class MatrixKeanu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //step 1 declare option
        int option = 0;
        //step 2 loop till user exit program
        do {
            //step 3 print out interface
            printInterface();
            //step 4 user input option
            option = userInput();
            //step 5 handle the user input and print out the result
            handleUserInput(option);
        } while (option != 4);

    }
//function to print interface

    public static void printInterface() {
        System.out.println("======Calculator Program======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtration Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");

    }

    public static boolean checkInputDouble(String a) {
        double b = 0;
        //check if blank
        if (a.isEmpty() == true) {
            System.out.println("please input number");
            return false;
        } else {
            try {
                b = Double.parseDouble(a);
                return true;
            } catch (Exception e) {
                System.out.println("Value of matrix is digit");
                return false;
            }

        }
    }

    public static boolean checkInputOption(String a) {
        int b = 0;
        //check if user input a blank 
        if (a.isEmpty() == true) {
            System.out.println("please input option");
            return false;
        } else {
            try {
                //check if user input not option from 1 to 4
                b = Integer.parseInt(a);
                if (b < 1 || b > 4) {
                    System.out.println("pls input between 1 and 4");
                    return false;
                } else {
                    return true;
                }
            } catch (Exception e) {
                System.out.println("pls input an integer number based on option");
                return false;
            }
        }
    }

    public static boolean checkInputInt(String a) {
        int b = 0;
        //check if user input blank
        if (a.isEmpty() == true) {
            System.out.println("please input an integer");
            return false;
        } else {
            try {
                b = Integer.parseInt(a);
                //wrong if user input less than 0
                if (b < 1) {
                    System.out.println("pls input larger or equal 1");
                    return false;
                } else {
                    return true;
                }
            } catch (Exception e) {
                System.out.println("value of matrix is digit");
                return false;
            }
        }
    }

    //function to input option
    public static int userInput() {
        Scanner sc = new Scanner(System.in);
        String i;
        int a;
        System.out.print("Your choice:");
        //loop to force user to input valid option
        do {
            i = sc.nextLine().trim();
        } while (checkInputOption(i) == false);
        a = Integer.parseInt(i);
        return a;
    }

    //function to handle the inpiut
    public static void handleUserInput(int a) {
        //option 1 to add matrix
        if (a == 1) {
            additionMatrix();
        } //option 2 to subtract matrix
        else if (a == 2) {
            subtractMatrix();
        } //option 3 to multi matrix
        else if (a == 3) {
            multiMatrix();
        } else {
            return;
        }
    }

    //function to input matrix
    public static double[][] createMatrix(int number) {
        Scanner sc = new Scanner(System.in);
        String a;
        String b;
        System.out.print("Enter Row Matrix " + number + ":");
        do {
            a = sc.nextLine().trim();
        } while (checkInputInt(a) == false);
        int row = Integer.parseInt(a);
        System.out.print("Enter Col Matrix " + number + ":");
        do {
            b = sc.nextLine().trim();
        } while (checkInputInt(b) == false);
        int col = Integer.parseInt(b);
        double[][] c = new double[row][col];
        return c;
    }

    //function to addition matrices
    public static double[][] additionMatrix() {
        System.out.println("-------- Addition --------");
        double[][] a;
        double[][] b;
        //loop until user input valid matrices
        do {
            a = createMatrix(1);
            inputMatrix(a, 1);
            b = createMatrix(2);
            inputMatrix(b, 2);
        } while (checkCanDoAddSub(a, b) == false);

        double[][] c = new double[a.length][a[0].length];
        System.out.println("-------- Result --------");
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        printMatrix(a);
        System.out.println("+");
        printMatrix(b);
        System.out.println("=");
        printMatrix(c);
        return c;
    }

    //function to input matrix
    public static void inputMatrix(double[][] a, int b) {
        Scanner sc = new Scanner(System.in);
        String c;
        //point from first to last row
        for (int i = 0; i < a.length; i++) //point from first col to last col
        {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print("Enter Matrix" + b + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                //force user to input valid value
                do {
                    c = sc.nextLine().trim();
                } while (checkInputDouble(c) == false);
                a[i][j] = Double.parseDouble(c);
            }
        }
    }

    public static double[][] subtractMatrix() {
        System.out.println("-------- Subtraction --------");
        double[][] a;
        double[][] b;
        do {
            a = createMatrix(1);
            inputMatrix(a, 1);
            b = createMatrix(2);
            inputMatrix(b, 2);
        } while (checkCanDoAddSub(a, b) == false);
        double[][] c = new double[a.length][a[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        System.out.println("-------- Result --------");
        printMatrix(a);
        System.out.println("-");
        printMatrix(b);
        System.out.println("=");
        printMatrix(c);
        return c;

    }

    //function to multiply matrices
    public static double[][] multiMatrix() {
        System.out.println("-------- Multiplication --------");
        double[][] a;
        double[][] b;
        do {
            a = createMatrix(1);
            inputMatrix(a, 1);
            b = createMatrix(2);
            inputMatrix(b, 2);
        } while (checkCanDoMul(a, b) == false);
        double[][] c = new double[a.length][b[0].length];
        //go thru the row of 1st matrix
        for (int i = 0; i < a.length; i++) {
            //and thru the column of second matrixes
            for (int j = 0; j < b[0].length; j++) {
                //while thru the column of 1st matrixes and the row of 2nd matrix
                for (int k = 0; k < a[0].length; k++) {
                    c[i][j] = c[i][j] + a[i][k] * b[k][j];
                }
            }

        }
        System.out.println("-------- Result --------");
        printMatrix(a);
        System.out.println("*");
        printMatrix(b);
        System.out.println("=");
        printMatrix(c);
        return c;
    }

    public static boolean checkCanDoAddSub(double[][] a, double[][] b) {
        //to add or subtract the matrices need to have the same row and collumn
        if (a.length != b.length || a[0].length != b[0].length) {
            System.out.println("to add or subtract we need the matrices to have the same row and collumn");
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkCanDoMul(double[][] a, double[][] b) {
        //to multiply matrices we need the row of the 1st matrix to have the same column of the 2nd matrixes
        if (a[0].length != b.length) {
            System.out.println("To multiply we need the first matrix to have the same column as the 2nd matrices have row ");
            return false;
        } else {
            return true;
        }
    }

    public static void printMatrix(double[][] a) {
      
        //move from start to end of row of matrix
        for (int i = 0; i < a.length; i++) {
            //move from start to end of column of matrix
            for (int j = 0; j < a[0].length; j++) {
                //check if value stored in matrix is int or not to print with out decimal
                if (a[i][j] == Math.round(a[i][j])) {
                    System.out.print("[" + (int) a[i][j] + "]");
                } else {
                    System.out.print("[" + a[i][j] + "]");
                }
            }
            System.out.println();
        }
    }

}
