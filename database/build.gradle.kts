import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.nicos.database"
    buildToolsVersion = "37.0.0"
    compileSdk = 37

    defaultConfig {
        minSdk = 29
        testOptions.targetSdk = 37
        lint.targetSdk = 37

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlin {
        compilerOptions {
            jvmTarget = JvmTarget.fromTarget("21")
            freeCompilerArgs = listOf("-Xannotation-default-target=param-property")
        }
    }
}

dependencies {

    // Modules
    implementation(projects.network)
    implementation(projects.core)
    // Architecture
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    // Room Database
    api(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    // Gson
    implementation(libs.gson)
    // Coroutines
    implementation(libs.coroutine.core)
    implementation(libs.coroutine.android)
    // Material
    implementation(libs.material)
    // Hilt
    implementation(libs.dagger.android)
    ksp(libs.dagger.compiler)
    ksp(libs.hilt.compiler)
    // Unit Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}