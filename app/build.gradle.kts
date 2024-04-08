plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.g5"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.g5"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}


dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")


    // don't you need by viewModels()
    implementation("androidx.activity:activity-ktx:1.8.2")

    // TODO - This part we gonna explore, long time
    val lifecycleVersion = "2.7.0"
    // this one is for viewmodelscope
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")

    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // retrofit-converter-moshi
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    // OkHttp interceptors
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
//    implementation("com.squareup.okhttp3:okhttp:4.11.0")

    // moshi and codegen
    implementation("com.squareup.moshi:moshi-kotlin:1.15.1")
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.15.1")
    // we may not even need this
    implementation("com.squareup.moshi:moshi-adapters:1.15.1")

    // room
//    val roomVersion = "2.6.1"
//    implementation("androidx.room:room-runtime:$roomVersion")
//    implementation("androidx.room:room-ktx:$roomVersion")
//    ksp("androidx.room:room-compiler:$roomVersion")


    testImplementation("junit:junit:4.13.2")

    // HILT
    implementation("com.google.dagger:hilt-android:2.51")
    ksp("com.google.dagger:hilt-android-compiler:2.51")
    ksp("androidx.hilt:hilt-compiler:1.2.0")

    // Coil- Kotlin, compose has different dependency
    implementation("io.coil-kt:coil:2.6.0")


}
