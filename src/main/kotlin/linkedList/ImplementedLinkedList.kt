package linkedList

class ImplementedLinkedList<Type>(var head: Node<Type>? = null, var tail: Node<Type>? = null) {

  fun addToFront(value: Type) {
    val newNode = Node(value)
    newNode.right = this.head

    if (this.head != null) {
      this.head!!.left = newNode
    } else {
      this.tail = newNode
    }

    this.head = newNode
  }

  fun addToBack(value: Type) {
    val newNode = Node(value)
    newNode.left = this.tail

    if (this.tail != null) {
      this.tail!!.right = newNode
    } else {
      this.head = newNode
    }

    this.tail = newNode
  }

  fun removeFromFront(): Type? {
    if (this.head == null) {
      return null
    }
    val removedValue = this.head!!.value
    this.head = this.head?.right

    if (this.head != null) {
      this.head!!.left = null
    } else {
      this.tail = null
    }

    return removedValue
  }

  fun removeFromBack(): Type? {
    if (this.tail == null) {
      return null
    }
    val removedValue = this.tail?.value ?: return null
    this.tail = this.tail?.left

    if (this.tail != null) {
      this.tail!!.right = null
    } else {
      this.tail = null
    }

    return removedValue
  }
}

data class Node<Type>(val value: Type, var right: Node<Type>? = null, var left: Node<Type>? = null)
