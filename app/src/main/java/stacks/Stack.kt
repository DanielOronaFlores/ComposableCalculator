package stacks

class Stack<T> {
    private val elements: MutableList<T> = mutableListOf()

    override fun toString(): String {
        return elements.joinToString(", ", "[", "]")
    }

    fun push(item: T) {
        elements.add(item)
    }

    fun pop(): T? {
        return if (elements.isNotEmpty()) {
            elements.removeAt(elements.size - 1)
        } else {
            null
        }
    }

    fun peek(): T? {
        return if (elements.isNotEmpty()) {
            elements[elements.size - 1]
        } else {
            null
        }
    }

    fun clear() {
        elements.clear()
    }

    fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    fun size(): Int {
        return elements.size
    }
}
