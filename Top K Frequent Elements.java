347. Top K Frequent Elements

Given an integer array nums and an integer k, return the k most frequent elements. 
You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]

// Solution 


class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    var freq = new HashMap<Integer, Integer>();
    var heap = new PriorityQueue<Pair<Integer, Integer>>((a,b) -> Integer.compare(a.getKey(), b.getKey()));
    var ans = new int[k];
    var i = 0;

    for (var n : nums)
      freq.put(n, freq.getOrDefault(n, 0) + 1);
    
    for (var e : freq.entrySet()) {
      heap.offer(new Pair(e.getValue(), e.getKey()));
      if (heap.size() > k) heap.poll();
    }
    while (!heap.isEmpty())
      ans[i++] = heap.poll().getValue();

    return ans;
  }
}

