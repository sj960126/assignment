package com.shs.buildsrc

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementationAndroidXCore() {
    add("implementation", Dependencies.AndroidX.CORE_KTX)
    add("implementation", Dependencies.AndroidX.ANNOTATION)
}

fun DependencyHandler.implementationKotlin() {
    add("implementation", Dependencies.Kotlin.KOTLIN_BOM)
    add("implementation", Dependencies.Kotlin.IMMUTABLE)
    add("implementation", Dependencies.Kotlin.COROUTINES)
}

fun DependencyHandler.implementationRetrofitOkHttp() {
    add("implementation", Dependencies.SquareUp.RETROFIT)
    add("implementation", Dependencies.SquareUp.OKHTTP)
    add("implementation", Dependencies.SquareUp.OKHTTP_LOGGING)
    add("implementation", Dependencies.SquareUp.CONVERTER_GSON)
}

fun DependencyHandler.implementationHilt() {
    add("implementation", Dependencies.Hilt.ANDROID)
    add("kapt", Dependencies.Hilt.COMPILER)
    add("kapt", Dependencies.Hilt.ANDROID_COMPILER)
    add("testImplementation", Dependencies.Hilt.ANDROID_TESTING)
    add("kaptTest", Dependencies.Hilt.ANDROID_COMPILER)
}

fun DependencyHandler.implementationPaging() {
    add("implementation", Dependencies.Paging.PAGING_RUNTIME)
    add("implementation", Dependencies.Paging.PAGING_COMPOSE)
}

fun DependencyHandler.implementationRoom() {
    add("implementation", Dependencies.Room.RUNTIME)
    add("implementation", Dependencies.Room.ROOM_PAGING)
    add("implementation", Dependencies.Room.ROOM_KTX)
    add("kapt", Dependencies.Room.COMPILER)
}

fun DependencyHandler.implementationCompose() {
    add("implementation", Dependencies.Compose.COMPOSE_UI)
    add("implementation", Dependencies.Compose.COMPOSE_RUNTIME)
    add("implementation", Dependencies.Compose.COMPOSE_FOUNDATION)
    add("implementation", Dependencies.Compose.COMPOSE_FOUNDATION_LAYOUT)
    add("implementation", Dependencies.Compose.COMPOSE_MATERIAL)
    add("implementation", Dependencies.Compose.COMPOSE_UI_TOOLING)
    add("implementation", Dependencies.Compose.COMPOSE_ACTIVITY)
    add("implementation", Dependencies.Compose.COMPOSE_COIL)
    add("implementation", Dependencies.Compose.NAVIGATION)
    add("implementation", Dependencies.Compose.HILT_NAVIGATION)
    add("implementation", Dependencies.Compose.COMPOSE_LIFECYCLE)
}
