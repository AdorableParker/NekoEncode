package nekoEncode

class Tree {
    var root: Node? = null
    fun encode() = root?.encode("") ?: mapOf()
}