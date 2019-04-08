import org.jetbrains.kotlin.load.kotlin.computeInternalName

plugins {
    kotlin("multiplatform") version "1.3.21"
}

repositories {
    mavenCentral()
}

kotlin {
  linuxX64("native") {
    val main by compilations.getting
    val interop by main.cinterops.creating
    
    binaries {
      executable()
    }
  }
}

tasks.withType<Wrapper> {
  gradleVersion = "5.3.1"
  distributionType = Wrapper.DistributionType.ALL
}


