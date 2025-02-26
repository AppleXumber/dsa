class ListNode(var value:Int = 0, var next:ListNode?=null)

fun find_middle(head: ListNode?): ListNode? {
  var slow = head
  var fast = head?.next
  while(fast!= null && fast.next != null) {
    slow = slow?.next
    fast = fast.next?.next
  }
  return slow
}

fun merge(l1:ListNode?, l2:ListNode?):ListNode? {
  var head = ListNode()
  var tail = head
  var left = l1
  var right = l2

  while (left != null && right != null) {
    if(left.value < right.value) {
      tail.next = left
      left = left.next
      
    } else {
      tail.next = right
      right = right.next
    }
    tail = tail.next!!
  }
  tail.next = left ?: right
  return head.next
}

fun mergesort(head : ListNode?): ListNode? {
  if(head?.next == null) return head
  
  var middle = find_middle(head)
  var after_middle = middle?.next
  middle?.next = null
  
  val left = mergesort(head)
  var right = mergesort(after_middle)

  val sortedList = merge(left, right)
  return sortedList
}

fun buildLinkedList(values: List<Int>): ListNode? {
  if (values.isEmpty()) return null
  val head = ListNode(values[0])
  var current = head
  for (i in 1 until values.size) {
      current.next = ListNode(values[i])
      current = current.next!!
  }
  return head
}

fun printLinkedList(head: ListNode?) {
  val result = mutableListOf<Int>()
  var current = head
  while (current != null) {
      result.add(current.value)
      current = current.next
  }
  println(result)
}

fun main() {
  val values = listOf(4, 2, 1, 3, 5, 9, 7)
  println("Unsorted Linked List: $values")
  val head = buildLinkedList(values)
  val sortedHead = mergesort(head)
  print("Sorted Linked List: ")
  printLinkedList(sortedHead)
}
