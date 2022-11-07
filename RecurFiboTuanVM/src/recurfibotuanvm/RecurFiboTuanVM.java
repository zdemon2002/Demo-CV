/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recurfibotuanvm;

import jdk.nashorn.internal.parser.TokenType;

/**
 *
 * @author ADMIN
 */
public class RecurFiboTuanVM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //find the fibonacci sequence needed using recursion
        int array[]=findFibo(45);
        //print out the fibo sequence
        displayArray(array);
    }
    //function to write value of fibo sequence in to the array
    public static void writeFiboArray(int []i,int count)
    {   
        //if count ==0,count ==1   
      while(count<=1)
      {
          i[count]=count;
          count++;
      }
      if(count>1)
      {
          i[count]=i[count-1]+i[count-2];
          count++;
          if(count<i.length)
          writeFiboArray(i, count);
      }
    }
    
    public static int[] findFibo(int i)
    {
        int j[]=new int[i];
        writeFiboArray(j, 0);
        return j;
    }
          
      public static void displayArray(int []i)
      {
          System.out.println("The 45 sequence fibonacci:");
        for(int j=0;j<i.length;j++)
        {
            System.out.print(i[j]);
            if(j==i.length-1)
            {
                System.out.println();
                System.out.println();
            }
            else
                System.out.print(", ");
        }
      }
        
        
    }
            
    
