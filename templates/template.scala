object HelloWorld {
   def main(args: Array[String]) {
       import scala.io
       val t = readInt()
       for(x <- 1 to t){
           val n = readLine().toInt; 
           var as = readLine().split(" ").toList.map(_.toInt);
           //println(" n:" + n + ", x:" + x + " , in:" + as)
           
       }
   }  
}