package nekoEncode

object Huffman {
    private fun addNode(nodeList: List<Node>): Node {
        val lp = nodeList.getOrElse(0) { Nya }
        val l = nodeList.getOrElse(1) { Nya }
        val r = nodeList.getOrElse(2) { Nya }
        val rp = nodeList.getOrElse(3) { Nya }
        return when (nodeList.size) {
            1 -> nodeList.first()
            2, 3, 4 -> addNode(listOf(Child(lp.value + l.value + r.value + rp.value, lp, l, r, rp)))
            else -> addNode(
                (nodeList.drop(4) + Child(
                    lp.value + l.value + r.value + rp.value,
                    lp, l, r, rp
                )).sortedBy { it.value })
        }
    }

    private fun Int.switchBase(): String {
        return this.toString(5).fold("") { r, c ->
            r + when (c) {
                '0' -> "喵"
                '1' -> "呜"
                '2' -> "呼"
                '3' -> "噜"
                else -> "咪"
            }
        }
    }

    private fun String.switchBase(): Char {
        return this.fold("") { r, c ->
            r + when (c) {
                '喵' -> "0"
                '呜' -> "1"
                '呼' -> "2"
                '噜' -> "3"
                else -> "4"
            }
        }.toInt(5).toChar()
    }

    fun zip(input: String): String {
        val entropyList = input.groupBy { it }.toList()
        val codeString = StringBuilder()
        if (entropyList.size * 2 > input.length) {
            codeString.append("Nya::")
            input.forEach { char -> codeString.append("${char.code.switchBase()}~") }
            return codeString.toString()
        } else {
            val nodeList = List(entropyList.size) { Leaf(entropyList[it].first, entropyList[it].second.size) }
            if (nodeList.isEmpty()) return "Nya~"
            val tree = Tree()
            tree.root = addNode(nodeList.sortedBy { it.value })
            val codeMap: Map<Char, String> = tree.encode()
            codeMap.forEach { (char, code) -> codeString.append("${char.code.switchBase()}~$code~") }
            codeString.append("Nya~")
            return input.fold(codeString.toString()) { result, next ->
                "$result${codeMap[next]}~"
            }
        }
    }

    fun unzip(input: String): String {
        return when {
            input.startsWith("Nya::") -> input.drop(5).split("~").fold("") { result, next ->
                if (next.isNotEmpty()) "$result${next.switchBase()}" else result
            }
            input.contains("Nya~") -> {
                val (codeList, text) = input.split("Nya~")
                val codeM = mutableMapOf<String, String>()
                val cache = codeList.split("~")
                if (cache.size >= 2) {
                    for (i in 0 until cache.lastIndex step 2) {
                        codeM[cache[i + 1]] = cache[i].switchBase().toString()
                    }
                }
                text.split("~").fold("") { result, next ->
                    "$result${codeM.getOrDefault(next, "")}"
                }
            }
            else -> "这不是喵语的喵"
        }
    }
}