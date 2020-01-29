//pset3 q1
   //need to find lowest element, then i can find the rotation count
   public static int findRotationCount(int[] arr, int low, int high){

//        if(arr.length<=1){
//            return 0;
//        }

       int mid = low + (high-low)/2;

       if(high>low){
           if(arr[mid]<arr[low]){
               return findRotationCount(arr, low, mid);
           }
           else{
               return findRotationCount(arr,mid+1, high);
           }
       }

       if(high<low){
           return 0;
       }

       return mid;
   }

// Time complexity -> O(n)
// Space -> O(1)

//pset3 q2
public static int BinarySearchInRotated(int []arr, int key){
   int res=-1;
   int div = findRotationCount(arr, 0,arr.length-1);
   if(key>arr[div] && key< arr[0]){        //if(key>arr[div] && key< arr[div-1]){
       res = binarySearch(arr,div,arr.length-1, key);
   }
   else
       res = binarySearch(arr,0,div, key);

   return res;
}

public static int binarySearch(int[]arr, int start, int end, int key) {
   if (arr.length >= 1) {
       int mid = start + (end - start) / 2;
       if (arr[mid] == key) {
           return mid;
       }
       if (key > arr[mid]) {
           return binarySearch(arr, mid + 1, end, key);
       }
           return binarySearch(arr, start, mid, key);
   }
   return -1;
}



// Time complexity->O(logn)
// Space complexity->O(1)










//pset3q3
public static int[] findTwoSumInRotatedArrByPtrs(int[] arr, int sum){
   int[] res = new int[2];
   int r = findRotationCount(arr,0,arr.length-1);

   //ptr1 is at lowest val, ptr2 is at the highest val
   int ptr1=-1;
   int ptr2=-1;

   ptr1 = r;
   if(r!=0){
       ptr2 = ptr1-1;
   }

   while(ptr1!=arr.length-1 && ptr2 !=0){
       int val1 = arr[ptr1];
       int val2 = arr[ptr2];

       if(sum==val1+val2){
           res[0] = val1;
           res[1] = val2;
           return res;
       }
       else if(sum>val1+val2){
           ptr1++;
       }
       else {
           ptr2--;
       }
   }
   return res;
}


// Time:  O(n)
// Space: O(1)







//pset3 q4 bruteforce: 14 mins, 8 mins debugging -> error in reverse (missed end-start>1)

// [3,1,2]
public static int findMaxSumAmongRotations(int[] arr){
   int sum = 0;
   for(int i=1; i<arr.length;i++){ // i=1,2
       int rotatedSum = sumArray(rotateArr(arr,i));  // arr = 1,2,3
       if(rotatedSum>sum){
           sum = rotatedSum;   // 8
       }
   }
   return sum;
}

public static int sumArray(int[] arr){  // [1,2,3]
   int sum = 0;
   for(int i=0;i<arr.length;i++){  //i=0/1/2/3
       sum+=arr[i]*i;  // 0 + 2 +6
   }
   return sum; // 8
}
     
public static int[] rotateArr(int[] arr, int amount){  // [3,1,2]  , 1
   reverse(arr,0,arr.length-1,true);
   reverse(arr,0,arr.length-1-amount,true);
   reverse(arr,arr.length-1-amount, arr.length-1, true);
   return arr;
}
// [start                     end]
public static void reverse(int[] arr,int start, int end, boolean forshow){
      
     if(start <=end){

              while(start < end ){
                    swap(arr, start ,end) ;
                    start ++ ;
                    end -- ;

             }

    }

}


 if(arr.length>1&& end-start>1){
       for(int i=0; i<=(end-start)/2;i++){
           int temp = arr[i];
           arr[i] = arr[end-i];
           arr[end-i] = temp;
       }
   }
}

// Time complexity -> O(n^2)
// Space -> O(1)

// Thoughs: This is a bruteforce solution that checks every possible combination. Which is a really bad thing. Maybe there is a better way? 
// Finding most continuous increasing order integer sequence, then i max is integer max

// Understand the meaning of function you are writing
// Try to check the boundary case/base case in the start itself
// Proper naming of variables
// Check which looping construct will be more clean


// Dry run with small inputs
// Boundary cases

// Then Check in IDE












