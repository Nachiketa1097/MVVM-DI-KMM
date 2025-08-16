package com.example.mvvm_di_kmm.res

import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc

actual class Strings {
    actual fun get(id: StringResource): StringDesc {
        return StringDesc.Resource(id)
    }
}