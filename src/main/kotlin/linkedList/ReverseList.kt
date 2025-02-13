package linkedList

class SolutionReverseList {
  fun reverseList(head: ListNode?): ListNode? {
    var newList: ListNode? = null
    var current = head

    while (current != null) {
      val nextNode = current.next
      current.next = newList
      newList = current
      current = nextNode
    }

    return newList
  }
}

