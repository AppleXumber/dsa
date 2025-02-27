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

fun numberOfSteps(num: Int): Int {
    var number = num
    var steps = 0

    while(number > 0) {
        if(number and 1 == 1) {
          number -= 1
        } else {
          number = number shr 1
        }
        steps++
    }
    return steps
}

fun hammingWeight(n: Int): Int {
    var res = 0
    for(i in 0 until 32) {
        if((n shr i) and 1 == 1) {
            res += 1
        }
    }
    return res
}

fun countBits(n: Int): IntArray {
  var myArray = IntArray(n + 1)

  for(i in 0..n) {
    myArray[i] = myArray[i shr 1] + (i and 1)
  }
  
  return myArray

}