plugins {
  `cpp-application`
}


val knProject = project(":")
val knProjectTask
  get() = Callable { knProject.tasks.getByName("linkNative") }

application {
  baseName.value("app")

  privateHeaders {
    from("${knProject.buildDir}/bin/native/debugShared")
    builtBy(knProjectTask)
  }

  dependencies {
    implementation(fileTree("${knProject.buildDir}/bin/native/debugShared") {
      include("libnative.dylib")
      builtBy(knProjectTask)
    })
  }


  val run by tasks.creating(Exec::class) {
    executable("$buildDir/exe/main/debug/app")
  }


  binaries.configureEach {
    run.dependsOn(Callable { compileTask.get() })
  }
}
