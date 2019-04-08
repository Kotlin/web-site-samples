import interop.functionFromCInterop

fun main() {
  /// this is function from C code!
  functionFromCInterop()

  println("Hello Kotlin/Native!")
}

