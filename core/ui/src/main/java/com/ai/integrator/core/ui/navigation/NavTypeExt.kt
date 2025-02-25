package com.ai.integrator.core.ui.navigation

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

inline fun <reified T : Any> serializableType(
    isNullableAllowed: Boolean = false,
) = object : NavType<T>(isNullableAllowed = isNullableAllowed) {
    override fun get(bundle: Bundle, key: String) =
        bundle.getString(key)?.let<String, T>(Json::decodeFromString)

    override fun parseValue(value: String): T = Json.decodeFromString(value)

    override fun serializeAsValue(value: T): String = Uri.encode(Json.encodeToString(value))

    override fun put(bundle: Bundle, key: String, value: T) {
        bundle.putString(key, Json.encodeToString(value))
    }
}

inline fun <reified T : Parcelable> parcelableType(
    isNullableAllowed: Boolean = false,
) = object : NavType<T>(isNullableAllowed = isNullableAllowed) {
    override fun get(bundle: Bundle, key: String) =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, T::class.java)
        } else {
            @Suppress("DEPRECATION")
            bundle.getParcelable(key)
        }

    override fun parseValue(value: String): T = Json.decodeFromString<T>(value)

    override fun serializeAsValue(value: T): String = Uri.encode(Json.encodeToString(value))

    override fun put(bundle: Bundle, key: String, value: T) = bundle.putParcelable(key, value)
}