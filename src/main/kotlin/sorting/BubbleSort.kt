package sorting

object BubbleSort {
  fun bubble(nums: IntArray) {
      for(_i in nums) {
        println(nums.asList())
        for(i in 0 until nums.size-1) {
          if(nums[i] > nums[i+1]) {
            val temp = nums[i+1]
            nums[i+1] = nums[i]
            nums[i] = temp
          }
        }
      }
  }
}

fun main() {
  BubbleSort.bubble(intArrayOf(5,4,3,2,1))
}