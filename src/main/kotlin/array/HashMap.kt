package array

class HashMap {
  fun firstUniqChar(s: String) : Int {
    val d = mutableMapOf<Char, Pair<Int, Int>>()
    for ((idx, ch) in s.withIndex()) {
      if (d.containsKey(ch)) {
        d[ch] = Pair(d[ch]!!.first, d[ch]!!.second + 1)
      } else {
        d[ch] = Pair(idx, 1)
      }
    }

    for((_, value) in d) {
      if(value.second == 1) {
        return value.first
      }
    }
    return -1
  }
}