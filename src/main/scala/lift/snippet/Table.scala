package lift.snippet

import scala.xml._

import net.liftweb.util._
import net.liftweb.util.Helpers._
import net.liftweb.common._
import net.liftweb.http._
import net.liftweb.http.js.JsCmds._

object Table {

  val map = List("I", "II", "III").map { (_, ValueCell(Map("a" -> 1, "b" -> 2, "c" -> 3))) }.toMap

  def render = {
    "tr *" #> List("I", "II", "III").map { key =>
      ".name *" #> key &
      // ".content *" #> WiringUI(map(key))(_ => "*" #> "___")
      ".content *" #> WiringUI(map(key))(nestedMap => "*" #> nestedMap.values.map { v => Text(v.toString) })
    }
  }
}
