package nekoEncode

import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class HuffmanTest {

    @Test
    fun shortInputTest() {
        val aTestData = "AF可能缺乏淡水"
        val bTestData = "Nya::呼噜喵~呼咪喵~呜呜咪呜咪呼呼~呼喵呼咪喵咪呜~呼喵呼喵呼咪喵~呜呜呼喵呜咪呼~呜咪喵喵喵喵咪~呜噜咪呜噜喵喵~"
        val cTestData = "A cat may look at a king."

        assertAll("短输入测试",
            { assertEquals(aTestData, Huffman.zip(aTestData).run(Huffman::unzip), "A测试失败") },
            { assertEquals(bTestData, Huffman.unzip(bTestData).run(Huffman::zip), "B测试失败") },
            { assertEquals(cTestData, Huffman.zip(cTestData).run(Huffman::unzip), "C测试失败") })
    }

    @Test
    fun longInputTest() {
        val aTestData =
            "垂帘画阁画帘垂,谁系怀思怀系谁.影弄花枝花弄影,丝牵柳线柳牵丝.脸波横泪横波脸,眉黛浓愁浓黛眉.永夜寒灯寒夜永,期归梦还梦归期." + "垂帘画阁画帘垂,谁系怀思怀系谁.影弄花枝花弄影,丝牵柳线柳牵丝.脸波横泪横波脸,眉黛浓愁浓黛眉.永夜寒灯寒夜永,期归梦还梦归期."
        val bTestData =
            "呼噜喵喵呜噜呼~喵喵~呜噜咪噜咪呼呼~喵呜~呜噜咪呜噜喵咪~喵呼~呜呼呜呼呼呼呼~喵噜~呜呼呼噜喵呜呜~呜喵~呜噜呼呜喵咪咪~呜呜~呜呼咪喵呜喵呼~呜呼~呜噜呼咪呜噜喵~呜噜~呜噜咪~呼喵~呜咪呜~呼呜~呼呼呜呼呜喵呜~呼呼喵~呜呼咪呜咪呜喵~呼呼呜~呜噜呼呼呜喵喵~呼呼呼~呼喵呜咪呼咪呼~呼呼噜~呜噜咪噜喵呜呼~呼噜喵~呜呼咪噜噜呜噜~呼噜呜~呜咪呜喵呜呜噜~呼噜呼~呼呜噜咪呼咪咪~呼噜噜~呜呼喵咪呜喵呼~噜喵喵~呜呼噜呼噜呼噜~噜喵呜~呜咪噜喵喵呼呜~噜喵呼~呼呜呼呜噜噜呜~噜喵噜~呼喵呜喵咪咪喵~噜呜喵~呜呼咪呜噜喵呜~噜呜呜~呜呼咪喵呼呜噜~噜呜呼~呜呼噜咪呼咪咪~噜呜噜~呼喵噜呼噜呜呼~噜呼喵~呜呜呜咪咪咪呼~噜呼呜~呜咪呜咪呼喵呜~噜呼呼~呜噜呼呼咪呼呜~噜呼噜~呼喵呼咪噜呜喵~噜噜喵~呜噜咪呼咪咪咪~噜噜呜~呜噜噜呼呼喵噜~噜噜呼~呜咪噜噜噜咪噜~噜噜噜~Nya~噜喵喵~噜喵呜~噜喵呼~呼呼喵~噜喵呼~噜喵呜~噜喵喵~呼喵~噜喵噜~噜呜喵~噜呜呜~呼呼呜~噜呜呜~噜呜喵~噜喵噜~呼呜~噜呜呼~噜呜噜~噜呼喵~呼呼呼~噜呼喵~噜呜噜~噜呜呼~呼喵~噜呼呜~噜呼呼~噜呼噜~呼呼噜~噜呼噜~噜呼呼~噜呼呜~呼呜~噜噜喵~噜噜呜~噜噜呼~呼噜喵~噜噜呼~噜噜呜~噜噜喵~呼喵~噜噜噜~喵喵~喵呜~呼噜呜~喵呜~喵喵~噜噜噜~呼呜~喵呼~喵噜~呜喵~呼噜呼~呜喵~喵噜~喵呼~呼喵~呜呜~呜呼~呜噜~呼噜噜~呜噜~呜呼~呜呜~呼呜~噜喵喵~噜喵呜~噜喵呼~呼呼喵~噜喵呼~噜喵呜~噜喵喵~呼喵~噜喵噜~噜呜喵~噜呜呜~呼呼呜~噜呜呜~噜呜喵~噜喵噜~呼呜~噜呜呼~噜呜噜~噜呼喵~呼呼呼~噜呼喵~噜呜噜~噜呜呼~呼喵~噜呼呜~噜呼呼~噜呼噜~呼呼噜~噜呼噜~噜呼呼~噜呼呜~呼呜~噜噜喵~噜噜呜~噜噜呼~呼噜喵~噜噜呼~噜噜呜~噜噜喵~呼喵~噜噜噜~喵喵~喵呜~呼噜呜~喵呜~喵喵~噜噜噜~呼呜~喵呼~喵噜~呜喵~呼噜呼~呜喵~喵噜~喵呼~呼喵~呜呜~呜呼~呜噜~呼噜噜~呜噜~呜呼~呜呜~呼呜~"
        val cTestData = "Can you can a can as a canner can can a can?"
        assertAll("长输入测试",
            { assertEquals(aTestData, Huffman.zip(aTestData).run(Huffman::unzip), "A测试失败") },
            { assertEquals(bTestData, Huffman.unzip(bTestData).run(Huffman::zip), "B测试失败") },
            { assertEquals(cTestData, Huffman.zip(cTestData).run(Huffman::unzip), "C测试失败") })
    }

    @Test
    fun errorInputTest() {
        val aTestData = ""
        val bTestData = "呼噜喵~呼咪喵~呜呜咪呜咪呼呼~呼喵呼咪喵咪呜~呼喵呼喵呼咪喵~呜呜呼喵呜咪呼~呜咪喵喵喵喵咪~呜噜咪呜噜喵喵~"
        val errData = "这不是喵语的喵"
        assertAll("异常输入测试",
            { assertEquals(aTestData, Huffman.zip(aTestData).run(Huffman::unzip), "A测试失败") },
            { assertEquals(errData, Huffman.unzip(bTestData).run(Huffman::zip).run(Huffman::unzip), "B测试失败") })
    }
}