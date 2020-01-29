public class Main {

//    There are two sorted arrays. First one is of size m+n containing only m elements.
//    Another one is of size n and contains n elements.
//    Merge these two arrays into the first array of size m+n such that the output is sorted.
//
//            Input: array with m+n elements (mPlusN[]).
//    NA => Value is not filled/available in array mPlusN[]. There should be n such array blocks.
//            Input: array with n elements (N[]).
//    Output: N[] merged into mPlusN[] (Modified mPlusN[])


    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public void sortArrays(int[] m,int[] n){
        int count = 0;
        while (m.length!=count-1){
            //get ith element of m
            for(int i=0; i<m.length; i++){

            }
            //get ith element of n
            for(int j=0;j<n.length;j++){

            }

            //compare

            //plug into m

            count++;
        }

    }

//    1. Alternative Sorting
//    Given an array of integers, print the array in such a way that the first element is first maximum and second element is first minimum and so on.
//            Examples :
//    Input : arr[] = {7, 1, 2, 3, 4, 5, 6}
//    Output : 7 1 6 2 5 3 4
//
//    Input : arr[] = {1, 6, 9, 4, 3, 7, 8, 2}
//    Output : 9 1 8 2 7 3 6 4

    public void printMinMax(int[] arr){

//        if(arr.length<=1){
//            break;
//        }

        int lowptr = 0;
        int highPtr = arr.length-1;

        //if all elements are same
        while(lowptr<highPtr){
            System.out.println(arr[highPtr]);
            System.out.println(arr[lowptr]);
            lowptr++;
            highPtr--;
        }

    }

}
