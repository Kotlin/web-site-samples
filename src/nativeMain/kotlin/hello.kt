import interop.copy_string
import interop.pass_string
import interop.return_string
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.cstr
import kotlinx.cinterop.toKString
import kotlinx.cinterop.usePinned

fun main() {
  println("Hello Kotlin/Native!")

  val str = "this is a Kotlin String"

  pass_string(str.cstr)

  val useMe = return_string()?.toKString() ?: error("null pointer returned")
  println(useMe)

  val stringFromC = ByteArray(255).usePinned { pinned ->

    val useMe2 = copy_string(pinned.addressOf(0), pinned.get().size - 1)

    if (useMe2 != 0) throw Error("Failed to read string from C")
    pinned.get().stringFromUtf8()
  }

  println(stringFromC)
}

