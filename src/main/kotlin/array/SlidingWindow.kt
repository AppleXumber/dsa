package array

import kotlin.math.max

class SlidingWindow {
  fun slidingWindow(s: String): Int {
    var left = 0
    var right = 0
    var max = 1
    val counter = HashMap<Char, Int>()

    counter[s[0]] = 1

    while (right < s.length - 1) {
      right++ // pass through all the array

      if (counter[s[right]] != null) {
        counter[s[right]] = counter[s[right]]!! + 1 // if the value represented on right isn't null on the Hash, add one
      } else {
        counter[s[right]] = 1 // if the value represented on the right is null, add it to Hash
      }

      while (counter[s[right]] == 3) {
        counter[s[left]] = counter[s[left]]!! - 1
        left += 1 // if the window is equal to three, move it to the next value and decrease the value that it was in it before
      }
      max = max(max, right - left + 1)
    }
    return max
  }
}

