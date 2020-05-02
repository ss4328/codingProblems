import java.util.*;
import java.lang.Math;

class Solution {
    Stack<Integer> input = new Stack<Integer>();
    public int reverse(int x) {
        if(x==0){
            return 0;
        }
        if(Math.abs(x)>=Integer.MAX_VALUE || x <= Integer.MIN_VALUE){
            return 0;
        }
        int length = String.valueOf(x).length();
        boolean isNeg = false;
        if (x<0){
            isNeg = true;
            x *= -1;
            length -=1;
        }
        
        System.out.println("Digits: " + length);
        //populate stack for each digit of x
        int oldx = 0;
        for(int powerOfTen=1 ; powerOfTen<=length;powerOfTen++){
            input.push((x%(int)Math.pow(10, powerOfTen) - oldx)/(int)Math.pow(10,powerOfTen-1));
            System.out.println("Inserted in stack: " + input.peek());
            oldx = input.peek();
            oldx = oldx*(int)Math.pow(10,powerOfTen-1);
        }
        //create a number from stack
        double res = 0;
        int powerOfTen=0;
        System.out.println("Attempting to create...");
        while(!input.empty()){
            System.out.println(input.peek());
            res = res + (double)input.pop()*(double)Math.pow(10, powerOfTen);
            powerOfTen+=1;
        }
        System.out.println("res: " + res);
        if(res>Integer.MAX_VALUE){
            return 0;
        }
        if(isNeg){
            res = res*-1;
        }
        
        return (int)res;
        //return number
    }
}
