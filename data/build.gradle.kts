import com.shs.buildsrc.AndroidConfig
import com.shs.buildsrc.implementationAndroidXCore
import com.shs.buildsrc.implementationHilt
import com.shs.buildsrc.implementationKotlin
import com.shs.buildsrc.implementationRetrofitOkHttp

plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.shs.data"
    compileSdk = AndroidConfig.COMPILE_SDK

    defaultConfig {
        minSdk = AndroidConfig.MIN_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "BASE_URL", "\"https://newsapi.org/\"")
        buildConfigField("String", "API_KEY", "\"e83a66a418984161bef701b16179f8c5\"")
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
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":domain"))
    implementationKotlin()
    implementationAndroidXCore()
    implementationHilt()
    implementationRetrofitOkHttp()
}