class Q1 {
  def bucketize(arr: Array[Double]): Array[String] = {
    // Map each element in the array to its corresponding bucket range
    arr.map { num =>
      // Compute the bucket start point
      val n = (20 * num).asInstanceOf[Int] / 20.0
      // Format the bucket range as a string
      f"$n%.3f-${n + 0.049}%.3f"
    }
  }
}

object Q1 {
  def main(args: Array[String]): Unit = {
    val q1 = new Q1()
    val inputArray = Array(12.05, 12.03, 10.33, 11.45, 13.50)

    // Print the input array
    println("Input Array: " + inputArray.mkString(", "))

    // Compute and print the bucketized array
    val outputArray = q1.bucketize(inputArray)
    println("Bucketized Array: " + outputArray.mkString(", "))
  }
}
