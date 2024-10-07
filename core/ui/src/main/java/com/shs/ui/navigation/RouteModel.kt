package com.shs.ui.navigation
import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    object Nes : Route

    @Serializable
    data class Detail(val pk: String) : Route

}