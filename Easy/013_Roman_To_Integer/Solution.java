import java.util.HashMap;
class Solution {
    public int romanToInt(String s) {

        // Map each Roman symbol to its integer value
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;        // Final result
        int prevValue = 0;    // Value of the previous character (to the right)

        // Traverse from right to left
        for (int i = s.length() - 1; i >= 0; i--) {

            int currentValue = map.get(s.charAt(i));

            // If current value is smaller than previous, subtract it
            if (currentValue < prevValue) {
                total -= currentValue;
            } 
            // Otherwise, add it
            else {
                total += currentValue;
            }

            // Update previous value for next iteration
            prevValue = currentValue;
        }

        return total;
    }
}
