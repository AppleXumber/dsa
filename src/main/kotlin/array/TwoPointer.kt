package array

class TwoPointer() {
  // This might not be the most efficient implementation, I did it based on the class
  fun reverseWords_manual(s: String): String {
    var res = ""
    var left = 0
    var right = 0 // initiate the values

    while (right < s.length) {
      if (s[right] != ' ') {
        right += 1 // if the value contains a letter, go to the next
      } else { // if it doesn't
        res += s.substring(left, right + 1).reversed() // add all values between right and left to the response
        right += 1
        left = right // move right to the next word and take left with it
      }
    }
    res += ' '
    res += s.substring(left, right).reversed() // reverse the last word
    return res.substring(1)
  }

  // Other implementation I saw on the comments of the class
  fun reverseWords_other(s: String): String {
    val res = ("$s ").toCharArray()
    val response = CharArray(res.size - 1)

    if (res.isNotEmpty()) {
      var cur = 0
      var left = 0
      var right = 1 // initiates the variables

      while (right < res.size) {
        if (res[right] == ' ') { // if the right lands on a blank space
          for (i in right - 1 downTo left) {
            response[cur++] = res[i] // takes all the chars between left and right and add them reversed on the response
          }
          if (right == res.size - 1) break // exit if the response is ended
          response[cur++] = ' ' // adds a blank space to separate the words
          right++
          left = right // moves right one space and drags left with it
        }
        right++
      }
    }
    return String(response)
  }
}
