// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : maintain a tail for prev operand (temporary result) and temporary result so far(calc variable) along with last seen sign
/// Process the string one char at a time, if char is not digit (i.e, operator), process calc and curr based on lastSign, 
/// then update tail and reset curr to 0 and lastsign to current character. If char is digit, form a number using it in curr.
/// repeat until the end of string is reached and return calc

class Solution {
    public int calculate(String s) {
        int tail = 0, calc = 0, curr = 0;
        char lastSign = '+';
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                curr = curr *10 + (ch-'0');
            }
            if((!Character.isDigit(ch) && ch!=' ')|| i==s.length()-1){
                if(lastSign == '+'){
                    calc = calc + curr;
                    tail = curr;
                    
                }
                else if(lastSign =='-'){
                    calc = calc - curr;
                    tail = -curr;
                }
                else if(lastSign =='*'){
                    calc = calc-tail+(tail*curr);
                    tail = tail * curr;
                }
                else{
                    calc = calc -tail +(tail/curr);
                    tail = tail/curr;
                }
                curr = 0;
                lastSign = ch;
            }
        }
        return calc;
    }
}