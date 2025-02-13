package sorting

object Quicksort {
  fun quicksort(arr: IntArray): IntArray {
    fun partition(low: Int, high: Int): Int {
      val pivot = arr[high]
      var i = low - 1
      for (j in low until high) {
        if (arr[j] <= pivot) {
          i++
          val temp = arr[i]
          arr[i] = arr[j]
          arr[j] = temp
        }
      }
      val temp = arr[i + 1]
      arr[i + 1] = arr[high]
      arr[high] = temp
      return i + 1
    }

    fun quicksortRecursive(left: Int, right: Int) {
      if (left < right) {
        val pi = partition(left, right)
        quicksortRecursive(left, pi - 1)
        quicksortRecursive(pi + 1, right)
      }
    }

    quicksortRecursive(0, arr.size - 1)
    return arr
  }

  fun quickSortListComprehension(arr: Array<Int>): Array<Int> {
    if (arr.size < 2) return arr

    val pivo = arr[0]
    val menores = arr.sliceArray(1 until arr.size).filter { it <= pivo }.toTypedArray()
    val maiores = arr.sliceArray(1 until arr.size).filter { it > pivo }.toTypedArray()

    return quickSortListComprehension(menores) + arrayOf(pivo) + quickSortListComprehension(maiores)
  }
}

fun main() {
  val testArray = intArrayOf(10, 7, 8, 9, 1, 5)
  println("Unsorted array: ${testArray.joinToString(", ")}")
  val sortedArray = Quicksort.quicksort(testArray)
  println("Sorted array: ${sortedArray.joinToString(", ")}")
  val sortedArrayLC = Quicksort.quickSortListComprehension(testArray.toTypedArray())
  println("Sorted array: ${sortedArrayLC.joinToString(", ")}")
}
