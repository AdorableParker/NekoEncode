# 猫猫编码

## 一个练习赫夫曼编码的整活作品
[![Kotlin CI with Gradle](https://github.com/AdorableParker/NekoEncode/actions/workflows/Publish_package.yml/badge.svg)](https://github.com/AdorableParker/NekoEncode/actions/workflows/Publish_package.yml)
[![Release](https://jitpack.io/v/AdorableParker/NekoEncode.svg)](https://jitpack.io/#AdorableParker/NekoEncode)

可用于将任意原字符串编码为类似猫叫形式的字符串
### 例子

* 字符串 => 猫码
  ```Kotlin
  val inData = "AF可能缺乏淡水"
  val outData = Huffman.zip(inData)
  println(dutData) // Nya::呼噜喵~呼咪喵~呜呜咪呜咪呼呼~呼喵呼咪喵咪呜~呼喵呼喵呼咪喵~呜呜呼喵呜咪呼~呜咪喵喵喵喵咪~呜噜咪呜噜喵喵~
  ```

* 猫码 => 字符串
    ```Kotlin
    val inData = "噜咪呼~喵~呜呜呼~咪~呼噜呼~呼喵喵~咪咪呜~呼喵呜~咪呼呜~呼喵呼~咪噜呼~呼喵噜~咪噜喵~呼呜喵~咪喵呜~呼呜呜~咪呼咪~呼呜呼~呼呼噜~呼呜噜~噜咪咪~呼呼~咪呼喵~呼噜~Nya~呼喵喵~喵~呼噜~咪~呼喵呜~呼喵呼~呼喵噜~咪~呼呼~喵~呼噜~咪~喵~咪~呼呼~喵~呼噜~咪~喵~呼呜喵~咪~喵~咪~呼呼~喵~呼噜~呼噜~呼呜呜~呼呜呼~咪~呼呼~喵~呼噜~咪~呼呼~喵~呼噜~咪~喵~咪~呼呼~喵~呼噜~呼呜噜~"
    val outData = Huffman.unzip(inData)
    println(dutData)  // Can you can a can as a canner can can a can?
    ```