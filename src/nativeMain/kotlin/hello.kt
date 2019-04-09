import interop.*
import kotlinx.cinterop.invoke
import kotlinx.cinterop.staticCFunction

fun main() {
  println("Hello Kotlin/Native!")

  accept_fun(staticCFunction<Int, Int> { it + 1})

  val useMe = supply_fun()
  useMe?.invoke(42)
}
