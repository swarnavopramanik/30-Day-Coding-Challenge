1140. Stone Game II

Alice and Bob continue their games with piles of stones.  There are a number of piles arranged 
in a row, and each pile has a positive integer number of stones piles[i].  
The objective of the game is to end with the most stones. 

Alice and Bob take turns, with Alice starting first.  Initially, M = 1.

On each player's turn, that player can take all the stones in the first 
  X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).

The game continues until all the stones have been taken.

Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.

 

Example 1:

Input: piles = [2,7,9,4,4]
Output: 10
Explanation:  If Alice takes one pile at the beginning, Bob takes two piles, 
then Alice takes 2 piles again. Alice can get 2 + 4 + 4 = 10 piles in total. 
If Alice takes two piles at the beginning, then Bob can take all three piles left. 
In this case, Alice get 2 + 7 = 9 piles in total. So we return 10 since it's larger. 
  
  // Solution 
  
  class Solution {
    
    Integer[][] cache;
    
    public int stoneGameII(int[] piles) {
        
        cache = new Integer[piles.length][piles.length * 2];
        
        int totalStones = 0;
        for(int stones : piles) totalStones += stones;
        
        //(Alice's Stone + Bob's Stone) = totalStones
        //(Alice's Stone - Bob's Stone) = Alice's score
        
        // 2 * Alice's Stone = totalStones + Alice's score
        //Alice's Stone      = (totalStones + Alice's score) / 2
        
        return (totalStones + getAliceScore(piles, 0, 1)) / 2;
    }
    
    private int getAliceScore(int[] piles, int index, int M){
        if(index == piles.length) return 0;
        
        
        if(cache[index][M] != null) return cache[index][M];
        
        int maxScore = Integer.MIN_VALUE;
        
        int stone = 0;
        
        for(int x = 0; x < 2 * M; x++){
            int i = index + x;
            
            if(i >= piles.length) continue;
            
            stone += piles[i];

            //calculate score
            int score = stone - getAliceScore(piles, i + 1, Math.max(x + 1, M));
            
            //update score
            maxScore = Math.max(maxScore, score);
        }
        
        return cache[index][M] = maxScore;
    }
}

