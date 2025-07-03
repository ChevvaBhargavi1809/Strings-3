// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Try breaking the number into triplets. For each triplet add suffix, none, thousand, million and billion
// For each triplet, try to make a word char by char. Maintain a list of unique words of multiples of tens and numbers below 20,
// everything else can be computed using these lists

class Solution {
    String suffix[] = new String[]{"", "Thousand", "Million", "Billion"};
    String tens[] = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String below20[] = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public String numberToWords(int num) {
        StringBuilder result = new StringBuilder("");
        String res = "";
        if(num==0){
            return "Zero";
        }
        if(num<0){
            return numberToWords(-1*num);
        }
        int i=0;
        while(num>0){
            int triplet = num%1000;
            System.out.println(triplet);
            if(triplet != 0){
                StringBuilder tripletStr = new StringBuilder(helper(triplet));
                //result = tripletStr.append(new StringBuilder(suffix[i]).append(result);
                res = tripletStr.toString().trim()+" "+suffix[i]+" "+res;
            }
            i++;
            num = num/1000;
        }
        return res.trim();
    }
    String helper(int triplet){
        if(triplet<20){
            return below20[triplet];
        }
        else if(triplet<100){
            return tens[triplet/10] + " " + helper(triplet%10); 
        }
        else if(triplet>=100){
            return below20[triplet/100] + " Hundred " + helper(triplet%100);
        }
        return "";
    }
}