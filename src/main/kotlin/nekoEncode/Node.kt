package nekoEncode

abstract class Node(val value: Int) {
    abstract fun encode(index: String): Map<Char, String>
}