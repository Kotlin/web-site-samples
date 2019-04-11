# kotlinlang.org Examples

An Example project for Kotlin/Native
https://kotlinlang.org/docs/tutorials/native/dynamic-libraries.html

Use the following command to compile Kotlin code into
a shared (or dynamic) native C library:
```
./gradlew linkNative
```
and check
`build/bin/native/debugShared`
and
`build/bin/native/releaseShared`
folders 

The `cpp` folder contains Gradle C++ project
that uses the Kotlin/Native library. 

To build and execute it run (it expects you have Xcode and its console tools installed)  

```
./gradlew cpp:run
```


## License
MIT. See the `LICENSE` file for the full text

