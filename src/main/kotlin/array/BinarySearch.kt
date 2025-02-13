package array

class BinarySearch {
  fun binarySearch(array: IntArray, n: Int, low:Int, high:Int): Int {
    var left = low
    var right = high
    while (left < right) {
      val mid = (left + right) / 2
      if (array[mid] == n) {
        return mid
      } else if (array[mid] < n) {
        left = mid + 1
      } else {
        right = mid
      }
    }
    return -1
  }

  fun exponential_search(array: IntArray, target: Int) : Int {
    if(array[0] == target) return 0
    val n = array.size
    var left = 1

    while (left < n && array[left] < target) {
      left *= 2;
    }

    //if(array[left] == target) return left

    return binarySearch(array, target, left/2, minOf(left, n-1))
  }
}