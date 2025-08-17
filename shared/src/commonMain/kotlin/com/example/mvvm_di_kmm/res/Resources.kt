package com.example.mvvm_di_kmm.res

import com.example.mvvm_di_kmm.SharedRes
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.getImageByFileName

fun getImageByFileName(name: String): ImageResource {
    val fallbackImage = SharedRes.images.app_logo_60
    return SharedRes.images.getImageByFileName(name) ?: fallbackImage
}