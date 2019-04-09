import interop.copy_string
import interop.pass_string
import interop.return_string

fun main() {
  println("Hello Kotlin/Native!")

  pass_string(/*fix me*/)
  val useMe = return_string()
  val useMe2 = copy_string(/*fix me*/)
}

