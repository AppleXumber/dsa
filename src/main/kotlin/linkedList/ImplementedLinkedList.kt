package linkedList

fun main() {
  runTests()
}

fun runTests() {
  println("===== Testes de Lista Duplamente Encadeada =====")

  // Teste 1: Adicionar elementos na frente
  val list1 = ImplementedLinkedList<Int>()
  list1.addToFront(10)
  list1.addToFront(20)
  list1.addToFront(30)
  println("Teste 1 - Adicionar na frente: ${list1.head?.value} (esperado: 30)")

  // Teste 2: Adicionar elementos no final
  val list2 = ImplementedLinkedList<String>()
  list2.addToBack("A")
  list2.addToBack("B")
  list2.addToBack("C")
  println("Teste 2 - Adicionar no final: ${list2.tail?.value} (esperado: C)")

  // Teste 3: Remover da frente
  val list3 = ImplementedLinkedList<Char>()
  list3.addToFront('X')
  list3.addToFront('Y')
  list3.addToFront('Z')
  val removedFront = list3.removeFromFront()
  println("Teste 3 - Remover da frente: $removedFront (esperado: Z)")

  // Teste 4: Remover do final
  val list4 = ImplementedLinkedList<Double>()
  list4.addToFront(1.1)
  list4.addToFront(2.2)
  list4.addToFront(3.3)
  val removedBack = list4.removeFromBack()
  println("Teste 4 - Remover do final: $removedBack (esperado: 1.1)")

  // Teste 5: Remover de lista vazia
  val list5 = ImplementedLinkedList<String>()
  val removedEmpty = list5.removeFromFront()
  println("Teste 5 - Remover de lista vazia: $removedEmpty (esperado: null)")

  // Teste 6: Adicionar e remover intercalado
  val list6 = ImplementedLinkedList<Int>()
  list6.addToFront(100)
  list6.addToBack(200)
  list6.addToFront(50)
  list6.removeFromFront()
  list6.removeFromBack()
  println("Teste 6 - Elemento restante: ${list6.head?.value} (esperado: 100)")

  println("===== Testes Finalizados =====")
}

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
