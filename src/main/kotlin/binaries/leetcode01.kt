fun missingNumber(nums: IntArray): Int {
  var x = 0

  for(num in nums) {
    x = x xor num
  }

  for(i in 0..nums.size) {
    x = x xor i
  }

  return x

}
