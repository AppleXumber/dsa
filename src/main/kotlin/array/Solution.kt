package array

import kotlin.collections.HashMap

class Solution {
  fun twoSum(nums: IntArray, target: Int): IntArray {
      val map = HashMap<Int, Int>()

      for(i in nums.indices) {
        val complement = target - nums[i]
        if(map.contains(complement)) {
          return intArrayOf(map.getOrDefault(complement, 0), i);
        }
        map[nums[i]] = i
      }
    return intArrayOf()
  }

  fun containsNearbyDuplicate(nums: IntArray, k : Int): Boolean {
    val map = mutableMapOf<Int, Int>()
    nums.forEachIndexed { i, num ->
      map[num]?.let {
        j ->
        if(i - j <= k) return true
      }
      map[num] = i
    }
    return false
  }
}