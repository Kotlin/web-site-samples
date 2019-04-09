import interop.*
import kotlinx.cinterop.invoke
import kotlinx.cinterop.staticCFunction

fun main() {
  println("Hello Kotlin/Native!")

  val cFunctionPointer = staticCFunction<Int, Int> { it + 1 }
  accept_fun(cFunctionPointer)

  val funFromC = supply_fun() ?: error("No function is returned")
  funFromC(42)
}
