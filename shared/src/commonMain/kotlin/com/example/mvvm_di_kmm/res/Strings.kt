package com.example.mvvm_di_kmm.res

import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.StringDesc

expect class Strings {
    fun get(id: StringResource): StringDesc
}