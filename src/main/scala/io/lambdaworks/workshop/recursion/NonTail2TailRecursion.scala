package io.lambdaworks.workshop.recursion

import scala.annotation.tailrec

/**
  * Rewrite below non tail-recursive functions to tail-recursive one.
  * Add @tailrec annotation to prove it.
  */
object NonTail2TailRecursion {

  def factorial(n: Int): Int = {
    @tailrec
    def loop(n: Int, accumulator: Int): Int = {
      if (n <= 0) accumulator else loop(n - 1, accumulator * n)
    }

    loop(n, 1)
  }


  def cubesOfEvens(numbers: List[Double]): List[Double] = {
    @tailrec
    def loop(numbers: List[Double], accumulator: List[Double]): List[Double] =
      numbers match {
        case x :: xs if x % 2 == 0 => loop(xs, accumulator :+ Math.pow(x, 3))
        case _ :: xs => loop(xs, accumulator)
        case Nil     => accumulator
      }

    loop(numbers, List())
  }

}
