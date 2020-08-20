
 // Question 9 hashmap approach
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

// Complexity:	time-> O(n^2)		getKeysFromValue is linear search on each element
// 		space->O(1)

//question 2            -> O(n)
//sort nearly sorted array
public static void sortKSorted(int[] arr, int k) {
   PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
   //populate initial pqueue
   int pos;
   for (pos = 0; pos < k + 1; pos++) {
       pQueue.add(arr[pos]);
   }

   //then we iterate over the array to get values from pQueue
   for (int i = 0; i < arr.length; i++) {
       //array's ith element is acquired from k sized min priority-queue(heap)
       arr[i] = pQueue.poll();

       //with each iteration, we jut add element to priority queue


       if (pos <= arr.length - 1) {
           pQueue.add(arr[pos]);
           pos++;
       }

   }
}










Try #3

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

// Complexity:	time-> O(n)		getKeysFromValue is linear search on each element
// 		space->O(??)

//question 5
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


// #9question 9
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
   //Did i 'get' the question?  sorta need clarification here
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
}

