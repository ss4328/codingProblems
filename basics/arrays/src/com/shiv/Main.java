package com.shiv;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Main {
    public static void main(String[] args) {
	// q9
//        int[] arr = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
//        sortElementsByFrequency(arr);
        //q10
        //n^2 complexity brute force solution: in 2 loops we compare  each element with  each  other: if arr[i] > arr[j] we add count
        //mergesort  solution: nlogn. we do a complete merge sort. adding count for each merge operation ran.
        //count+= mergesort()

        //q2
//        int[] arr = {6, 5, 3, 2, 8, 10, 9};
//        sortKSorted(arr,3);

        //q3
//        int[] arr = {10, 5, 3, 9, 2};
//        sortByAbsDifference(arr,7);

        //q5
//        int[]mPlusn = {2,3,5,9,10, -1, -1, -1};
//        int[]n = {1,6,11};
//
//        MergeTwoSortedArrays(mPlusn,n);

        //q9 again
//        int[] arr = {2, 5, 2, 8, 5, 6, 8, 8};
//        sortElementsByFrequency2(arr);

        //q7
//        int array[] = {2, 3, 1, 4, 5, 6};
//        int sorter[] = {0, 1, 1, 1, 1};
//
//        boolean res = verifySorterArr(array,sorter,6);
//        System.out.println(res);

//        //q10
//        int arr[] = {2, 4, 1, 3, 5};
//        countInversions(arr);

        //pset3

//        int[] arr = {3,1,2};
//        int minElem = findRotationCount(arr,0,arr.length-1);
//        System.out.println("Clockwise:"+minElem);
//        System.out.println("ACW: "+ (arr.length-minElem));
//
//        int[] arr2= {5, 6, 7, 8, 9, 10, 1, 2, 3};
//        System.out.println(BinarySearchInRotated(arr2,6));


//        System.out.println(findRotationCount(arr2,0,arr2.length-1));

//        reverse(arr2,0,arr2.length);
//        printArr(arr2);

        int TwoArr[] = {11, 15, 26, 38, 9, 10};
//        int[] res = findTwoSumInRotatedArrByPtrs(TwoArr,35);
//        printArr(res);


//        int[] q4arr = {8, 3, 1, 2};
//        int resq4 = findMaxSumAmongRotations(q4arr);
//        System.out.println(resq4);


        //recursion
        //p1
//        System.out.println(findMax(TwoArr,0, 0));

        //p2
        printArrReverse(TwoArr);
//        towerOfHanoi(3,'A','C','B');
    }

    public static void printArr(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static void sortElementsByFrequency(int[] array){

        //create a frequency hashmap
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for (int i=0; i< array.length;i++){
            if(freqMap.containsKey(array[i])){
                int oldVal = freqMap.get(array[i]);
                oldVal++;
                freqMap.put(array[i], oldVal);
            }
            else{
                freqMap.put(array[i],1);
            }
        }

//        System.out.println(freqMap);

        //populate a arraylist which has the values of frequency, sort it.
        ArrayList<Integer> freqList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            freqList.add(entry.getValue());
        }
        freqList = (ArrayList<Integer>) freqList.stream().distinct().collect(Collectors.toList());
        Collections.sort(freqList);

        for (int i=freqList.size()-1;i>=0;i--){
            Integer frequency = freqList.get(i);
            ArrayList<Integer> values = new ArrayList<>();
            values = (ArrayList<Integer>) getKeysFromValue(freqMap, frequency);

            //if multiple values have same frequency
            for(int k=0;k<values.size();k++){
                //print key frequency times
                for(int j=0;j<frequency;j++){
                    System.out.println(values.get(k).toString());
                }
            }
        }
    }


    public static List<Integer> getKeysFromValue(Map<Integer, Integer> map, Integer value){
        List< Integer > keys = new ArrayList< Integer >();
        for (Integer key : map.keySet() )
        {
            if ( map.get( key ).equals( value ) )
            {
                keys.add( key );
            }
        }
        return keys;
    }

    //question 2            -> O(n)
    //sort nearly sorted array
    public static void sortKSorted(int[] arr, int k){
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        //populate initial pqueue
        int pos;
        for(pos=0;pos<k+1;pos++){
            pQueue.add(arr[pos]);
        }

        //then we iterate over the array to get values from pQueue
        for(int i=0; i<arr.length;i++){
            //array's ith element is acquired from k sized min priority-queue(heap)
            arr[i]=pQueue.poll();

            //with each iteration, we jut add element to priority queue


            if(pos<=arr.length-1){
                pQueue.add(arr[pos]);
                pos++;
            }

        }

//        //debugging to see if this worked
//        for (int j=0;j<arr.length;j++){
//            System.out.println(arr[j]);
//        }
    }

    //question 3
    //sort wrt absolute difference
    public static void sortByAbsDifference(int[] arr, int k){
        //[distance][number]
        int[][] absDiff= new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            absDiff[i][0] = Math.abs(k-arr[i]);
            absDiff[i][1] = arr[i];
        }

        sortbyColumn(absDiff, 0);

        // Display the sorted Matrix
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(arr[i]);
            }
        }
    }

    //sorts the values according to the keys
//    public static void sortByCol(int[] arr, int col){
//        Arrays.sort(arr, new Comparator<Integer[]>(){
//           public int compare(final Integer[] v1, final Integer[] v2){
//               if (v1[col] > v2[col])
//                   return 1;
//               else
//                   return -1;
//           }
//        });
//    }

    public static void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // To sort in descending order revert the '>' Operator
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });  // End of function call sort().
    }

    //5 try#2
    public static void MergeTwoSortedArrays(int[] mPlusN, int[] n){
        int nLastElem=n.length-1;
        int mLastElem=mPlusN.length-n.length-1;
        for (int i=mPlusN.length-1; i>0;i--){
            if(mLastElem!=0 && nLastElem!=0) {
                if (mPlusN[mLastElem] > n[nLastElem]) {
                    mPlusN[i] = mPlusN[mLastElem];
                    mLastElem--;
                } else {
                    mPlusN[i] = n[nLastElem];
                    nLastElem--;
                }
            }
        }

        //handle last element
        if(mPlusN[mLastElem]<n[nLastElem]){
            mPlusN[0]=mPlusN[0];
        }
        else
            mPlusN[0]=n[nLastElem];

        for(int i=0;i<mPlusN.length;i++){
            System.out.println(mPlusN[i]);
        }
    }

    public static void sortElementsByFrequency2(int[] arr){
        Arrays.sort(arr);

        Set<Integer> numSet = new HashSet<Integer>();
        for(int i=0;i<arr.length;i++){
            numSet.add(arr[i]);
        }

        int[][] freqArr = new int[numSet.size()][2];

        //prepare 1st column
        int i=0;
        Iterator<Integer> itr = numSet.iterator();
        while(itr.hasNext()){
            freqArr[i][0] = itr.next();
            i++;
        }
        //populate second column
        i=0;
        for(int j=0;j<arr.length; j++){
            if(arr[j]==freqArr[i][0]){
                freqArr[i][1]++;
            }
            else{
                i++;
                freqArr[i][1]++;
            }
        }

        //sort by frequency
        sortBiggestByColumn(freqArr, 1);

        //print
        for(int j=0; j<numSet.size();j++){
            for (int k=0;k<freqArr[j][1];k++){
                System.out.println(freqArr[j][0]);
            }
        }
    }

    public static void sortBiggestByColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // To sort in ascending order revert the '>' Operator
                if (entry1[col] < entry2[col])
                    return 1;
                else
                    return -1;
            }
        });
    }

    //sort 1 To N by swapping adjacent elements
    public static boolean verifySorterArr(int[] arr, int[] sorterSeq, int n){
        int i=0;
        int j=0;

        // find longest swap
        for (i = 0; i < n - 1; i++) {
            if (sorterSeq[i]==1) {
                j = i;
                while (sorterSeq[j]==1) {
                    //till we find a continuous swap interval
                    if(j<sorterSeq.length-1){
                        j++;
                    }
                    else
                        break;
                }
                // Sort array A from i to j
                Arrays.sort(arr, i, 1 + j);
                i = j;      //to move farther into the array
            }
        }

        // array must be sorted by now. If not, Array B was a scam so we return false
        for (i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return false;
            }
        }

        return true;
    }

    //q10
    //bro kehna kya chahte ho???!???!??! tf is this question man?
    public static void countInversions(int[] arr){
        int count =0;
        for(int i=0; i<arr.length;i++){
            for (int j=0;j<arr.length; j++) {
                if (arr[i] > arr[j] && i < j) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    //okay this is n^2 complexity. Can I improve it anyhow? There must be a better way
    //is there any relationship between the indexes, and the result?
    //does hashing it help?

    public static void countInversions2(int[] arr){
        int count = 0;
        int[][] elemIndex = new int[arr.length][2];
        for(int i=0; i< arr.length;i++){
            elemIndex[i][0] = arr[i];
            elemIndex[i][1] = i;
        }
        //now we have a 2-d array with array element, and its index. Everytime there's a swap, we increase the count

    }

//    public static int findInversionsBySortingCols(int[] arr){
//        int count =0;
//        // Using built-in sort function Arrays.sort
//        Arrays.sort(arr, new Comparator<int[]>() {
//
//            @Override
//            // Compare values according to columns
//            public int compare(final int[] entry1,
//                               final int[] entry2) {
//
//                // To sort in descending order revert the '>' Operator
//                if (entry1[col] > entry2[col])
//                    return 1;
//                else
//                    return -1;
//            }
//        });  // End of function call sort().
//    }



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

    //pset3 q2
//    public static int findElementBrute(int[] arr, int key){
//
//        int r = findRotationCount(arr,0,arr.length-1);
//        //reverse whole arr
//        arr = reverse(arr,0,arr.length-1);
//        //reverse until smallest
//        arr = reverse(arr,0,r);
//        //reverse after smallest
//        arr = reverse(arr,r,arr.length-1);
//
//        //binary search
//        int res = binarySearch(arr,0,arr.length-1,key);
//
//
//        return res;
//    }

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


    public static int[] reverse(int[] arr,int start, int end){
        if(arr.length<1){
            return arr;
        }

//        boolean isEven=false;
//        if (arr.length%2==0){
//            isEven=true;
//        }

//        if(isEven){
            for(int i=0; i<=(end-start)/2;i++){
                int temp = arr[i];
                arr[i] = arr[end-i];
                arr[end-i] = temp;
            }
//        }
        return arr;
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

    //pset3 q3
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

    public static int[] findTwoSumInRotatedArr(int[]arr, int sum){

        int[] res = new int[2];

        int r = findRotationCount(arr,0,arr.length-1);

        //find sibling elemtn k=8, e=1, SE=>7       best solution
    //r->ptr        l                               okayish but inefficient


        //worst solution
        //reverse whole arr
        arr = reverse(arr,0,arr.length-1);
        //reverse until smallest
        int[] arrp1 = reverse(arr,0,r);
        //reverse after smallest
        int[] arrp2 = reverse(arr,r,arr.length-1);

        //merge arrp1, arrp2 then run method on it.
        res = find2SumElements(arr, sum);

        return res;



//        int div = findRotationCount(arr, 0,arr.length-1);
//        if(key>arr[div] && key< arr[0]){        //if(key>arr[div] && key< arr[div-1]){
//            res = binarySearch(arr,div,arr.length-1, key);
//        }
//        else
//            res = binarySearch(arr,0,div, key);

    }

    static int[] findArrayMult(int arr[], int prevRes){
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        left[0]=1;
        for(int i=1; i<left.length;i++){
            left[i] = left[i-1] * arr[i-1];
        }

        right[arr.length-1]=1;
        for(int i=right.length-2; i>=0;i--){
            right[i] = right[i+1]*arr[i+1];
        }

        for(int i=0; i<arr.length-1;i++){
            arr[i] = left[i]*right[i];
        }
        return arr;
    }


    public static int[] find2SumElements(int[]arr, int sum){
        int[] res = new int[2];
        int ptr1 = 0;
        int ptr2 = arr.length-1;


        while(ptr1<ptr2){
            if(sum==arr[ptr1]+arr[ptr2]){
                res[0] = arr[ptr1];
                res[1] = arr[ptr2];
                return res;
            }
            else if(sum>arr[ptr1]+arr[ptr2]){
                ptr2--;
            }
            else {
                ptr1++;
            }
        }

        return res;
    }

    //pset3 q4 bruteforce: 14 mins
    public static int findMaxSumAmongRotations(int[] arr){
        int sum = 0;
        for(int i=1; i<arr.length;i++){
            int rotatedSum = sumArray(rotateArr(arr,i));
            if(rotatedSum>sum){
                sum = rotatedSum;
            }
        }
        return sum;
    }

    public static int sumArray(int[] arr){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i]*i;
        }
        return sum;
    }

    public static int[] rotateArr(int[] arr, int amount){
        reverse(arr,0,arr.length-1,true);
        reverse(arr,0,arr.length-1-amount,true);
        reverse(arr,arr.length-1-amount, arr.length-1, true);
        return arr;
    }

    public static void reverse(int[] arr,int start, int end, boolean forshow){
        if(arr.length>1&& end-start>1){
            for(int i=0; i<=(end-start)/2;i++){
                int temp = arr[i];
                arr[i] = arr[end-i];
                arr[end-i] = temp;
            }
        }
    }
























    //pset4 searching
    public static int findDuplicate(int[] arr, int n){
  //correct      //approach 1 -> sort, then find the largest continuous sequence     ->nlogn for sorting, n for iterating. therefore nlogn
        //approach 2 -> hashmap     ->memory usage O(n)
        //approach 3 -> 2d array    ->memory usage
        //approach 4 -> sort, then in a loop, find an element, if found, the number it is -> largest count wins
        //-> sometimes read only array is given, then what?? what happens for unsorted?? n logn
        //are all the numbers between 1 and n? find sum, find actual sum from 1 to n: decrease it -> that's the answer
        //-> n complexity

        //approach 4
//        Arrays.sort(arr);
//        for(int i=0; i<arr.length-2;i++){
//
//            if (arr[i+1]==arr[i]){
//                return arr[i];
//            }
//
//        }
//        return -1;
        //not using the n info here :/


        if(arr.length<=1){
            return(-1);
        }
        Arrays.sort(arr);

        for(int i=1; i<arr.length-1;i++){
            if(arr[i-1]==arr[i]){
                return arr[i];
            }
        }
        return -1;
    }

    //[1,2,3,3,4,5,6,7] n=8         8 numbers
    //pset4 q2
    public static int findDuplicateOneToN(int[] arr, int n){
        //maintain sum of all the nums

        int sum = 0;
        int assumed = 0;
        for(int j=0;j<n;j++){assumed+=j;}
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }

        return assumed - sum;

    }

    //pset4 q3
    public static int findMostFreq(int[]arr, int n){
        if(arr.length<=1){
            return(-1);
        }
        Arrays.sort(arr);

        int firstOccurance=arr[0];
        int mostFreq = 0;
        int res = 0;
        int currentFreq = 0;


        int currentNum=0;
        for(int i=1; i<arr.length-1;i++){
            currentNum = arr[i];
            //same number running
            if(firstOccurance == currentNum){
                if(currentFreq > mostFreq) {
                    currentFreq++;
                    res = currentNum;
                    mostFreq = currentFreq;
                }
                else{

                }
            }
            //diff number occured
            else{
                firstOccurance = arr[i];
                currentFreq=1;
            }
        }

        return res;
    }


    //pset4 q4              ===??????????       solve 2 in a another way ->q4
    //approach 1 -> sort, then find the largest continuous sequence     ->nlogn for sorting, n for iterating. therefore n
//    public static int findMostFreq(int[] arr, int n){
//
//    }

    //wrong solution
//    //pset4 q5
//    public static int repeatsFirst(int[] arr){
//        //load numbers one-by-one to set, return first element which returns false
//        Set<Integer> numSet = new HashSet<Integer>();
//
//        for(int i=0;i<numSet.size();i++){
//            if(!numSet.contains(arr[i])){           //O(n)??
//                numSet.add(arr[i]);                 //log n
//            }
//            else return arr[i];
//        }
//        return -1;
//    }

    public static int repeatsFirst(int[] arr){

        //approach 1
        //2 ptr: 1st on elem 0th, 2nd in last
        //move ptr 2-- till it reaches 1, if pair found return elem, else ptr1++
        // O((n^2-n)/2)

//        int low = 0;
//        int high = arr.length-1;
//
//
//        for(low=0; low<arr.length;low++){
//            while(low!=high){
//                if(arr[low]==arr[high]){
//                    return arr[low];
//                }
//            }
//
//        }
//        return -1;

        //approach 2

        //add all to set
        //add duplicate(not being added) elements to a list. dupl.sort()
        //iterate on arr array, try to find elem in dupl, if found? -> ans
        //time complexity -> n + mlogm

//        load numbers one-by-one to set, return first element which returns false
        Set<Integer> numSet = new HashSet<Integer>();
        ArrayList dupl = new ArrayList<Integer>();

        for(int i=0;i<numSet.size();i++){
            if(!numSet.contains(arr[i])){           //O(n)??
                numSet.add(arr[i]);                 //log n
            }
            else dupl.add(arr[i]);
        }

        Collections.sort(dupl);

        for(int i=0;i<arr.length;i++){
            if(dupl.contains(arr[i])){
                return arr[i];
            }
        }

        return -1;


    }

    //pset4 q6
    public static int findMissingOneToN(int[] arr, int num){
        //Approach 1
        //find actual sum till num
        //find sum from array
        //substract 2 from 1 -> ans
        //complexity of O(n)

        int hypoSum=0,actualSUm =0;
        for (int i=0;i<num;i++){
            hypoSum+=i;
            actualSUm+=arr[i];
        }
        return actualSUm-hypoSum;

        //Approach 2
        //
    }

    //pset4 q7
    public static int findOddNumber(int[] arr, int n){
        //multiply each number by 2??? even doesn't mean two and add them together
        //like approach 1 we find missing

        //sort -> nlogn
        //then find sequence count: -> even ignore; odd return  n
        //nlogn + n = nlogn

        //add the integers together. pairing reduces to 0;
        //left out element is the answer?

        int hypoSum=0,actualSUm =0;
        for (int i=0;i<n;i++){
            hypoSum+=i;
            actualSUm+=arr[i];
        }
        return actualSUm-hypoSum;
    }

    //pset4 q8
    //numbers not in range of 1 to n??
    //sort then find largest continous window
    //sort, look for elem again while making 1st as -1; do this again for second elem nlogn
    //add everything together recording the sum; find 2sum


    //pset4 q9
    //sort then 2sum        ???
    public static int[] twoSum(int[] arr, int target){
        int[] res = new int[2];
        Arrays.sort(arr);
        int ptr1 = 0;
        int ptr2 = arr.length-1;

        while(ptr1!=ptr2){
            int val1 = arr[ptr1];
            int val2 = arr[ptr2];

            if(val1+val2==target){
                res[0]=val1;
                res[1]=val2;
                return res;
            }
            else if(val1+val2<target){
                ptr1++;
            }
            else
                ptr2--;
        }
        res[0]=-1;
        res[1]=-1;
        return res;
    }

    //pset4 q10 ==>?????
    public static int[] findThreeSquaredNums(int arr[]){

        //Sometimes this can overflow integer value though
        for(int i=0;i<arr.length;i++){
            arr[i] = arr[i]*arr[i];
        }

        int[] res = new int[3];
        Arrays.sort(arr);
        int i = 0;
        int k = arr.length-1;
        int j =k-1;

        while(k!=0){
            while(i!=j){
                int val1 = arr[i];
                int val2 = arr[j];

                if(val1+val2==arr[k]){
                    res[0]= (int) Math.sqrt(val1);
                    res[1]= (int) Math.sqrt(val2);
                    res[3]=(int) Math.sqrt(arr[k]);
                    return res;
                }
                else if(val1+val2<arr[k]){
                    i++;
                }
                else
                    j--;
            }
            k--;
            j =k-1;
            i = 0;
        }
        res[0]=-1;
        res[1]=-1;
        return res;
    }


    //pset4 q11
    public static int[] findClosestToZeroSum(int[] arr){
        //sort array
        //2 pointer approach; we store the closest we get in a counter
        //if the sum result is smaller, we update counter and save values
        //return in the end

        Arrays.sort(arr);
        int[] res = new int[2];
        int smallestDiff = Integer.MAX_VALUE;

        int low = 0;
        int high = arr.length-1;

        while(low<high){
            int lowVal = arr[low];
            int highVal = arr[high];
            int currentDiff = Math.abs(highVal+lowVal);

            //if closest
            if(currentDiff<smallestDiff){
                res[0]=lowVal;
                res[1]=highVal;
                if(Math.abs(arr[low+1]+arr[high])<currentDiff){
                    low++;
                }
                else if(Math.abs(arr[low]+arr[high-1])<currentDiff){
                    high--;
                }
                else{
                    return res;
                }
            }

            //can we get a yet smaller res?


        }

        return res;

    }

    //pset4 q12 -> 3 sum
    public static int[] threeSum(int[]arr, int target){
        //3 pointers: 2 pointers on left and rightmost values: 1 as close to target as possible
        //we offset the diff between target and 3rd ptr by using 1 and 2
        //if diff is positive, we move r to l; negative? move l towards r
        //stop when l, r meet
        // do these steps for all values, moving alternatively from 3rd pointer

        int[] res = new int[3];
        for(int i=0;i<arr.length-3;i++){
            int fix = i;
            int low = fix++;
            int high = arr.length-1;


            int target2 = -1*arr[fix];
            while(low!=high){
                int val1 = arr[low];
                int val2 = arr[high];

                if(val1+val2==target2){
                    res[0]=val1;
                    res[1]=val2;
                    res[3]=arr[fix];
                    return res;
                }
                else if(val1+val2<target){
                    low++;
                }
                else
                    high--;
            }
        }
        return res;
    }

    //pset4 q13 How to use the n information?
    //q12 with just target =0

    //pset4 q14
//    public static int findRotatedCountSorta(int[]arr){
//        //did this before by binary search
//    }

    //data set too big to find last element     q15











    //recursion psets

    //pset5 q1
    public static int findMax(int[] arr, int index, int max){
        if(arr[index]>max){
            max=arr[index];
        }
        //base case
        if(index == arr.length-1){
            if(arr[index]>max){
                max = arr[index];
            }
            return max;
        }
        //recursive case
        else return findMax(arr,index+=1, max);

    }

    public static void printArrReverse(int[]arr){
        printReverse(arr, 0);
    }

    //pset5 q2
    public static void printReverse(int[] arr, int index){

        //base = terminate
        if(index==arr.length){
            return;
        }

        System.out.println(arr[arr.length-index]);
        //recursive
        printReverse(arr, index+=1);

        //explain why this print opposite? prints in order
//        System.out.println(arr[index]);

    }

    //pset5 q3
    public static int findLength(String str){

        //base
        if(str.equals("")){
            return 0;
        }

        //recursive
        else return findLength(str.substring(1))+1;

    }

    //pset5 p4
    //hints used: arguments, problem statement -> print instructions, saw output

    //thought process: from is always sorted so we can place stuff here without worrying
    //process is move all n-1 disks to aux, last to to; then move n-1 from aux to to
    //requirements: small above top; move only one; move topmost only
    //towerOfHanor(64,'A','C','B')
    public static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod){
        //base case: if one disk
        if(n==1){
            //move to the destination stack
            System.out.println("Moved "+n+" from "+from_rod+" to "+to_rod);
            return;
        }


        //recursive case
        else{
            towerOfHanoi(n-1,from_rod, aux_rod,to_rod);
            towerOfHanoi(n-1,aux_rod,to_rod,from_rod);        //?
//            System.out.println("Moved "+n+" from "+from_rod+" to "+to_rod);

        }
//        System.out.println("Moved coin" + " from "+from_rod+" to "+to_rod);
    }

//    public static int[] replaceWithOthersProduct(int[] arr){
//      need to paste python code here -_-
//    }




    //pset searching set2

    //q1
    public static int findMedian(int[] arr){
        Arrays.sort(arr);       //lnogn

        return (arr[arr.length/2]);

    }

    //q2
//    public static int findMedianOfTwoArrays(int[] arr){
//        //approach 1: Space needed -> m+n
//        //create new array of m+n, copy elements from m, n to m+n sized arr
//        //arr m+n sort
//        //median is middle element
//
//        //approach 2:
//    }
//
//    //q3
    public static int existInBitonicArr(int[] arr){
        //find inflection point
        //binary search in incr order arr part,
        //reverse bin search in decr order arr part

    }

    //q4



    //19


    //q20
    public static void printFrequenciesWithoutSpaceUse(int[] arr){
        Arrays.sort(arr);                                   //nlogn
        //approach: print(element -> window length)         n now
        //approach 2: keep binary searching, found? replace by -n element until not found

        //sort and then iterate over the list, printing each element's frequency
        //nlogn + n -> nlogn
        int currentElement = arr[0];
        int count = 0;
        for(int i=1; i< arr.length;i++)
        {
            int ielement = arr[i];
            if (currentElement != ielement){
                System.out.println("Number: "+arr[i]+ ": " + " times");
                count = 0;
            }
            else{
                count++;
            }
        }

    }

    //q21
    //pc1's 5 instructions = pc2's 1 instruction
    //in 5 secs pc1 is moved to 50th element comparison, pc2 has reduced search dataset to 32k elements
    //in next 5, pc1 has moved to 100th element, pc2 is now searching 1000 elements
    //in next 5, pc1 moved to 150th, pc2 is now searching 32 elements
    //in nexr 5, pc1 moved to 200th, pc2 has now reduced search to 1 element -> search completed



}