Given the integers zero, one, low, and high, we can construct a string by starting with an empty string, and then at each 
step perform either of the following:

Append the character '0' zero times.
Append the character '1' one times.
This can be performed any number of times.

A good string is a string constructed by the above process having a length between low and high (inclusive).

Return the number of different good strings that can be constructed satisfying these properties. Since the answer can 
be large, return it modulo 109 + 7.

 // Solution 
  
  class Solution {
public:
    int countGoodStrings(int low, int high, int zero, int one) {
        vector<int> dp(high + 1);
        dp[0] = 1;
        int md = 1e9 + 7;
        for (int i = min(zero, one); i <= high; i++) {
            if(i>=zero){
                dp[i] = (dp[i] + dp[i - zero]) % md;
            }
            if(i>=one){
                dp[i] = (dp[i] + dp[i - one]) % md;
            }
            
        }
        int sum = 0;
        for (int i = low; i <= high; i++) {
            sum = (sum + dp[i]) % md;
        }
        return sum;
    }
};

