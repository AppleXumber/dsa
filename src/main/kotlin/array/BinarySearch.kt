package array

class BinarySearch {
  fun binarySearch(array: IntArray, n: Int): Int {
    var low = 0
    var high = array.size
    var steps = 0

    while (low < high) {
      steps += 1
      val mid = (low + high) / 2

      if (array[mid] == n) {
        println(steps)
        return mid
      } else if (array[mid] < n) {
        low = mid + 1
      } else {
        high = mid
      }
    }
    return -1
  }
}