class Solution {
    public int reverse(int x) {
        boolean neg = false;
        //zero
        if(x==0){
            return 0;
        }
        //negative numbers
        if(x<0){
            x=-1*x;
            neg=true;
        }
        //positive numbers
        long xl = x;
        int res = reversePositive(x);
        if (neg){
            res = -1*res;
        }
        return res;
    }
    //function to return reversed positive number 
    public int reversePositive(int x){
        String s = Integer.toString(x);
        String r = "";
        int strlen = s.length()-1;
        for(int i=strlen;i>=0;i--){
            r = r + s.charAt(i);
        }
        int res = Integer.parseInt(r);
        return res;
    }
}
