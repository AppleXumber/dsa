package linkedList

class mergeTwoListsSolution {
  fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var op = dummy

    var l1 = list1
    var l2 = list2

    while (l1 != null && l2 != null) {
      if (l1.value <= l2.value) {
        op.next = l1
        l1 = l1.next
      } else {
        op.next = l2
        l2 = l2.next
      }
      op = op.next!!
    }

    op.next = l1 ?: l2
    return dummy.next
  }
}