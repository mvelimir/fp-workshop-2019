package io.lambdaworks.workshop.functions
import com.lightbend.emoji.ShortCodes.Defaults._
import com.lightbend.emoji.ShortCodes.Implicits._

import scala.util.Try

object EmojifyText {

  def emojify(sentence: String): String =
    sentence.filter(x => isLetter(x) || x == ' ').split(" ").map(emojiOrWord).reduce(_ + " " + _)

  private def emojiOrWord(word: String): String =
    Try(word.toLowerCase.emoji.toString).getOrElse(word)

  private def isLetter(char: Char) = char.isLetter

}
