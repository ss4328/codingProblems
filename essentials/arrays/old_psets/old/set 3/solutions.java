
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