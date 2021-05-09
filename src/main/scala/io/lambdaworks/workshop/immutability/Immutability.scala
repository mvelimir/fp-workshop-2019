package io.lambdaworks.workshop.immutability

import scala.collection.mutable.ArrayBuffer

object Immutability {

  final case class Employee(firstName: String, lastName: String)

  final case class Task(var title: String, description: Option[String] = None)
  //Immutable version:
  //final case class Task(title: String, description: Option[String] = None)

  final case class Point(x: Double, y: Double)

  final case class Polygon(arrayBuffer: ArrayBuffer[Point])

  def main(args: Array[String]): Unit = {
    val employee = Employee("John", "Doe")

    // Will not compile
    // employee.firstName = "Peter"

    val updatedEmployee = employee.copy(firstName = "Mike")

    // Will produce false value
    println(updatedEmployee == employee)

    val task = Task("FP", Some("Learn immutability!"))
    // This will compile and successfully update title attribute value
    task.title = "Functional programming"

    // Is the List[Task] type mutable?
    // The List type is Conditionally Deeply immutable, and because the Task type argument is mutable,
    // the List[Task] type will be Shallow immutable
    val tasks = List[Task](task)
    tasks.foreach { task =>
      task.title = task.title.toLowerCase
    }

    tasks.foreach(println)

    // Is the Polygon type mutable?
    // The Polygon type is Shallow immutable, because it contains a field of type ArrayBuffer, which is mutable
    val polygon = Polygon(ArrayBuffer(Point(5, 5), Point(10, 10)))
    polygon.arrayBuffer += Point(15, 15)

    println(polygon)
  }
}
