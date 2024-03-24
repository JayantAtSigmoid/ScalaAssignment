import scala.util.Random

// Define a case class to represent player statistics
case class Player(year: Int,
                  pName: String,
                  country: String,
                  matches: Int,
                  runs: Int,
                  wickets: Int
                 )

class Q2 {
  // Sample player data
  val data: Vector[Player] = Vector(
    //Year, PlayerName, Country, Matches, Runs, Wickets
    Player(2021, "Sam", "India", 23, 800, 3),
    Player(2021, "Ram", "India", 23, 300, 30),
    Player(2021, "Mano", "India", 23, 300, 13),
    Player(2021, "John", "Australia", 20, 500, 10),
    Player(2021, "David", "Australia", 22, 800, 20),
    Player(2021, "Chris", "England", 25, 1000, 15),
    Player(2021, "Steve", "England", 21, 600, 25)
  )

  // Method to retrieve top N players by runs scored
  // Method to retrieve top N players by runs scored
  def topNScorers(N: Int): Iterable[(String, String, Int)] = {
    val sortedData = data.sortBy(-_.runs) // Sort data by runs in descending order
    sortedData.take(N).map(p => (p.pName, p.country, p.runs))
  }

  // Method to retrieve top N players by wickets taken
  def topNWktTakers(N: Int): Iterable[(String, String, Int)] = {
    val sortedData = data.sortBy(-_.wickets) // Sort data by wickets in descending order
    sortedData.take(N).map(p => (p.pName, p.country, p.wickets))
  }

  // Method to rank players by their overall performance
  def rankPlayersByPerformance(N: Int): Iterable[(String, String, Double)] = {
    val sortedData = data.sortBy(p => -(5 * p.wickets + (5.0 / 100) * p.runs)) // Sort data by overall performance
    sortedData.take(N).map(p => (p.pName, p.country, 5 * p.wickets + (5.0 / 100) * p.runs))
  }
}

object Q2 {
  def main(args: Array[String]): Unit = {
    val q2 = new Q2()

    // A) Find player with highest run scored:
    val res2A = q2.topNScorers(1)
    println("Player with the highest score: " + res2A)

    // B) Find the top 5 players by runs scored:
    val res2B = q2.topNScorers(5)
    println("Top 5 run scorers: " + res2B.zipWithIndex.map { case (plr, idx) => (idx + 1, plr) })

    // C) Find the top 5 wicket takers:
    val res2C = q2.topNWktTakers(5)
    println("Top 5 wicket takers: " + res2C.zipWithIndex.map { case (plr, idx) => (idx + 1, plr) })

    // D) Rank players by their overall performance:
    val res2D = q2.rankPlayersByPerformance(10) // Increase the number to accommodate additional players
    println("Performance rankings: " + res2D.zipWithIndex.map { case (plr, idx) => (idx + 1, plr) })
  }
}
