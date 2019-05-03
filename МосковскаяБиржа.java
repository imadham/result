/*
Инструкция по сборке и запуску
1-й параметр “а” – основание исходной системы счисления 
2-й параметр “b” – основание целевой системы счисления
3-й параметр “x” – число (например 111001 или 57 или 1l ....) 
 */
package московская.биржа;

import java.util.Scanner;

/**
 *
 * @author imad
 */
public class МосковскаяБиржа {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        string array for storing all
//        alphabets for all numbering system
        String[]alphabets = new String[36];
        //build the alphabet
        //string[1] = "01",String[2] = "012"....String[36]="012...xyz"
        for(int i=0;i<36;i++)
        {
            int k=0;
            alphabets[i]="";
            for(int j=48;j<123;j++)
            {
                if(j==58)j=97;
                alphabets[i]+=(char)j;
                if(k==i)break;
                k++;
            }
        }
        
        Scanner input = new Scanner(System.in);
        int a,b;
        String x;
        int temp=0;
        a=input.nextInt();
        b=input.nextInt();
        input.nextLine();
        x=input.nextLine();

        try
        {
            temp = Integer.parseInt(x,a);
        }catch(Exception e)
        {
            System.err.println("you have entered very big number or number in wrong format"
                    + "\nplease enter smaller number and in correct format");
        } 
        String result=recursiveConvert(temp,alphabets[b-1],b);
        System.out.println(result);
    }
    
    private static String recursiveConvert(int number,String alphabet,int base) {
        StringBuilder builder = new StringBuilder();
        if (number > 0) {
            String resultNumber = recursiveConvert(number / base,alphabet,base);
            int digit = number % base;
            builder.append(resultNumber + alphabet.charAt(digit));
        }
        return builder.toString();
    }
    
}
