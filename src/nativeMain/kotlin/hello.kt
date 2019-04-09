import interop.*
import kotlinx.cinterop.alloc
import kotlinx.cinterop.cValue
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.readValue

fun main() {
  println("Hello Kotlin/Native!")

  val cUnion = cValue<MyUnion> {
    b.a = 5
    b.b = 2.7182
  }

  memScoped {
    union_by_value(cUnion)
    union_by_pointer(cUnion.ptr)
  }

  memScoped {
    val cStruct = alloc<MyStruct> {
      a = 42
      b = 3.14
    }

    struct_by_value(cStruct.readValue())
    struct_by_pointer(cStruct.ptr)
  }
}
