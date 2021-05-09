package io.lambdaworks.workshop.purity
import java.util.{ArrayList => JList}

import org.joda.time.DateTime

object EitherPureOrNot {

  final case class Todo(id: Int, title: String)

  private var todoList = Seq(Todo(1, "Make a coffee!"), Todo(2, "Clean the house!"))
  private val builder  = new StringBuilder()

  // Either pure or not?

  //This function is not pure, because it has a side effect; appending to the sequence todoList and assigning to it
  def addTodo(todo: Todo): Unit = todoList :+= todo

  //This function is not pure, because the return value depends on the current date and time, which aren't input values
  def currentDate: DateTime = DateTime.now

  //This is a pure function
  def evenNumbers(lowerBound: Int, upperBound: Int): Seq[Int] = {
    var result = Seq[Int]()
    for (index <- lowerBound to upperBound) {
      if (0 == index % 2) result :+= index
    }

    result
  }

  //This function is not pure, it prints to console which is a side effect
  def firstElement(todoList: List[Todo]): Todo = {
    val head = todoList.head
    println(head)

    head
  }

  //This function is not pure, because it mutates the builder member value
  def fullName(firstName: String, lastName: String): String = {
    builder.append(firstName)
    builder.append(lastName)
    builder.mkString(" ")
  }

  //This function is not pure, because it mutates the numbers argument that was passed in
  def square4j(numbers: JList[Int]): JList[Int] = {
    for (index <- 0 until numbers.size()) {
      val number = numbers.get(index)
      numbers.set(index, number * number)
    }

    numbers
  }

  //This is a pure function
  def square4s(numbers: Seq[Int]): Seq[Int] = {
    var result = numbers
    for (index <- numbers.indices) {
      val number = numbers(index)
      result = numbers.updated(index, number * number)
    }

    result
  }

}
