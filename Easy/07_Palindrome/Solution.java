class Solution {
    public boolean isPalindrome(int x) {
        // Checking for less than 0 and when the number has 0 at the end it cannot be palindrome except 0 so we check !=0 and %10 so directy return
       if(x<0 || (x%10 ==0 && x!=0)) return false; 

// Here initial value 0 so when we iterate half is on one side i.e halfreversed and another be x 
       int halfreversed =0 ; 

// TO enter loop halfreversed is less than x 
       while(x > halfreversed){

        halfreversed = (halfreversed * 10) + (x % 10); 
        x=x/10; 
       }
       // For even and for odd
       return x == halfreversed || x == halfreversed /10; 
    }
}