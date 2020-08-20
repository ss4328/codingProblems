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
//
//    }