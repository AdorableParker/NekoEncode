package nekoEncode

class Leaf(private val char: Char, value: Int) : Node(value) {
    override fun encode(index: String) = mapOf(char to index)
}