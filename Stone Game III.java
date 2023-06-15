1406. Stone Game III
Hard

Alice and Bob continue their games with piles of stones. There are several stones arranged in a row, 
and each stone has an associated value which is an integer given in the array stoneValue.

Alice and Bob take turns, with Alice starting first. On each player's turn, that player can take 1, 2, 
  or 3 stones from the first remaining stones in the row.

The score of each player is the sum of the values of the stones taken. The score of each 
player is 0 initially.

The objective of the game is to end with the highest score, and the winner is the player with 
the highest score and there could be a tie. The game continues until all the stones have been taken.

Assume Alice and Bob play optimally.

Return "Alice" if Alice will win, "Bob" if Bob will win, or "Tie" if they will end 
the game with the same score.

 

Example 1:

Input: stoneValue = [1,2,3,7]
Output: "Bob"
Explanation: Alice will always lose. Her best move will be to take three piles and the score 
become 6. Now the score of Bob is 7 and Bob wins.
  
  // Solution 
  
  class Solution {
    Integer[] cache;
    
    public String stoneGameIII(int[] piles) {
        int n = piles.length;
        
        cache = new Integer[n + 1];
        
        //AliceScore = Stone Collected by Alice - Stone Collected by Bob
        int AliceScore = getAliceScore(piles, 0);
        
        if(AliceScore > 0) return "Alice";
        
        if(AliceScore < 0) return "Bob";
        
        return "Tie";
    }
    
    private int getAliceScore(int[] piles, int index){
        if(index == piles.length) return 0;
        
        //reterive from cache
        if(cache[index] != null) return cache[index];
        
        int maxScore = Integer.MIN_VALUE;
        
        int stone = 0;
        
        for(int x = 0; x < 3; x++){
            int i = index + x;
            
            //ignore the invalid index
            if(i >= piles.length) continue;
            
            stone += piles[i];

            //calculate score
            int score = stone - getAliceScore(piles, i + 1);
            
            //update score
            maxScore = Math.max(maxScore, score);
        }
        
        //save in cache
        return cache[index] = maxScore;
    }
    
    
}

