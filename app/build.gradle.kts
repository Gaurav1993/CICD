plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "com.example.kotlin_project"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.kotlin_project"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_17 // Correct usage of JavaVersion
        targetCompatibility = JavaVersion.VERSION_17 // Correct usage of JavaVersion
    }
    kotlinOptions {
        jvmTarget = "17"
    }

}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.activity:activity-ktx:1.7.0")

    // Room Database dependencies
    implementation("androidx.room:room-runtime:2.6.1") // This is the core Room library
    implementation("androidx.room:room-ktx:2.6.1")    // This is the Room KTX library for Coroutines
    kapt("androidx.room:room-compiler:2.6.1")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.2")
   testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.2")
    // Hilt for Dependency Injection
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-compiler:2.48")

    // Optional - Testing libraries (if needed)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")

    
    kaptAndroidTest("com.google.dagger:hilt-compiler:2.43")
    kaptAndroidTest("com.google.dagger:hilt-compiler:2.43")

    testImplementation("org.mockito:mockito-inline:4.5.1")
    testImplementation("org.mockito:mockito-core:4.5.1")
    androidTestImplementation("org.mockito:mockito-core:4.5.1")
    androidTestImplementation("org.mockito:mockito-android:4.5.1")
    androidTestImplementation ("android.arch.core:core-testing:1.1.0")
    testImplementation("androidx.arch.core:core-testing:2.2.0")

    // Jetpack Compose UI testing dependencies
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.0") // Update to latest version
    androidTestImplementation("androidx.compose.ui:ui-test-manifest:1.5.0") // Manifest support for Compose
    androidTestImplementation("androidx.compose.ui:ui-tooling:1.5.0") // Optional for debugging purposes

    // For Espresso, if needed (optional if using Compose testing only)
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


}
kapt {
    correctErrorTypes = true
}