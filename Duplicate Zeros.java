
1089. Duplicate Zeros

Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.

 

Example 1:

Input: arr = [1,0,2,3,0,4,5,0]
Output: [1,0,0,2,3,0,0,4]
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:

Input: arr = [1,2,3]
Output: [1,2,3]
Explanation: After calling your function, the input array is modified to: [1,2,3]
 

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 9



// Solution 



class Solution {

    public void duplicateZeros(int[] arr) {

        if (arr == null || arr.length == 0) {

            return;

        }

        int zeroCount = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {

                ++zeroCount;

            }

        }

        for (int i = arr.length - 1, j = arr.length + zeroCount - 1; i < j; i--, j--) {

            if (arr[i] == 0) {

                if (j < arr.length) {

                    arr[j] = 0;

                }

                --j;

                if (j < arr.length) {

                    arr[j] = 0;

                }

            } else {

                if (j < arr.length) {

                    arr[j] = arr[i];

                }

            }

        }

    }

}
        
    
