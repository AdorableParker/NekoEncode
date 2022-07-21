package nekoEncode

class Child(
    value: Int,
    private val leftPlus: Node = Nya,
    private val left: Node = Nya,
    private val right: Node = Nya,
    private val rightPlus: Node = Nya
) : Node(value) {
    override fun encode(index: String): Map<Char, String> {
        return leftPlus.encode("${index}喵") + left.encode("${index}呜") + right.encode("${index}呼") + rightPlus.encode("${index}噜")
    }
}
