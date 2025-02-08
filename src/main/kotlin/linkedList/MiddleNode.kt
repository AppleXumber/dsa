package linkedList

class SolutionMiddleNote {
  fun middleNode(head: ListNode?): ListNode? {
    var ahead = head
    var current = head

    while (ahead?.next != null) {
      ahead = ahead.next!!.next
      current = current?.next
    }

    return current

  }
}