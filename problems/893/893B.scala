object HelloWorld {
  def main(args: Array[String]): Unit = {
    val input = 992
    println(beautifuls.map(binaryToDec(_)).take(10).toList)
    println(beautifuls.map(binaryToDec(_)).filter(x => ((x < input) && (input%x == 0)) ).toList )
  }
  
  def beautifuls: Stream[String] = "1" #:: beautifuls.map("1" + _ + "0")

  def binaryToDec: String => Int = x => Integer.parseInt(x, 2)
}
