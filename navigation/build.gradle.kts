plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.parcelize)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.nicos.navigation"
    buildToolsVersion = "34.0.0"
    compileSdk = 34

    defaultConfig {
        minSdk = 27
        testOptions.targetSdk = 34
        lint.targetSdk = 34

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
    }
    composeCompiler {
        enableStrongSkippingMode = true
        reportsDestination = layout.buildDirectory.dir("compose_compiler")
    }
}

dependencies {

    //Modules
    implementation(project(":compose_ui"))
    implementation(project(":database"))
    //Architecture
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    //Compose
    api(libs.androidx.navigate.compose)
    //Serialization
    implementation(libs.kotlinx.serialization.json)
    //Unit Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}