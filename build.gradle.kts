buildscript {
    println("... buildscript")
    // ext -
//    extra.apply{
//        set("compose_version", "1.0.0")
//    }


    dependencies {
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}


// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    println("... plugins")
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    // ksp thingy
    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
    //  dockka integration
    id("org.jetbrains.dokka") version "1.9.10"

    id("org.jetbrains.kotlinx.kover") version "0.7.5"

    id("com.google.dagger.hilt.android") version "2.51" apply false


}

subprojects {
    println("... sub-projects")
    apply(plugin = "org.jetbrains.kotlinx.kover")
//    apply(plugin = "jacoco")

}

