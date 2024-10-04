package com.photo.buildsrc

object Dependencies {

    object Kotlin {
        const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_VERSION}"
        const val JDK17 = "org.jetbrains.kotlin:kotlin-stdlib-jdk17:${Versions.KOTLIN_VERSION}"
        const val KOTLIN_BOM = "org.jetbrains.kotlin:kotlin-bom:${Versions.KOTLIN_VERSION}"
        const val IMMUTABLE = "org.jetbrains.kotlinx:kotlinx-collections-immutable:${Versions.IMMUTABLE_VERSION}"
    }

    object AndroidX {
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
        const val ANNOTATION = "androidx.annotation:annotation:${Versions.ANNOTATION}"
    }

    object Room {
        const val RUNTIME = "androidx.room:room-runtime:${Versions.ROOM_VERSION}"
        const val ROOM_KTX = "androidx.room:room-ktx:${Versions.ROOM_VERSION}"
        const val COMPILER = "androidx.room:room-compiler:${Versions.ROOM_VERSION}"
        const val ROOM_PAGING = "androidx.room:room-paging:${Versions.ROOM_VERSION}"
    }

    object Paging {
        const val PAGING_RUNTIME = "androidx.paging:paging-runtime:${Versions.PAGING_VERSION}"
        const val PAGING_COMPOSE = "androidx.paging:paging-compose:${Versions.PAGING_COMPOSE_VERSION}"
    }

    object Hilt {
        const val ANDROID = "com.google.dagger:hilt-android:${Versions.HILT_VERSION}"
        const val COMPILER = "com.google.dagger:hilt-compiler:${Versions.HILT_VERSION}"
        const val ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT_VERSION}"
        const val ANDROID_TESTING = "com.google.dagger:hilt-android-testing:${Versions.HILT_VERSION}"
    }

    object Compose {
        const val COMPOSE_RUNTIME = "androidx.compose.runtime:runtime:${Versions.COMPOSE_VERSION}"
        const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE_VERSION}"
        const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation:${Versions.COMPOSE_VERSION}"
        const val COMPOSE_FOUNDATION_LAYOUT = "androidx.compose.foundation:foundation-layout:${Versions.COMPOSE_VERSION}"
        const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE_VERSION}"
        const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE_VERSION}"
        const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${Versions.COMPOSE_ACTIVITY_VERSION}"
        const val COMPOSE_COIL = "io.coil-kt:coil-compose:${Versions.COMPOSE_COIL_VERSION}"
        const val NAVIGATION = "androidx.navigation:navigation-compose:${Versions.NAVIGATION_VERSION}"
        const val HILT_NAVIGATION = "androidx.hilt:hilt-navigation-compose:${Versions.HILT_NAVIGATION_VERSION}"
        const val COMPOSE_LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.COMPOSE_LIFECYCLE_VERSION}"
    }

    object SquareUp {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
        const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP_VERSION}"
        const val OKHTTP_LOGGING = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP_LOGGING_VERSION}"
        const val CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Versions.CONVERTER_GSON_VERSION}"
    }

}