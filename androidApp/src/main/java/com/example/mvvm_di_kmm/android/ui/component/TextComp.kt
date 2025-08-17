package com.example.mvvm_di_kmm.android.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.mvvm_di_kmm.SharedRes
import dev.icerock.moko.resources.compose.fontFamilyResource

@Composable
fun TextComp(
    text: String = "", textModifier: Modifier = Modifier, style: TextStyle = TextStyle(
        color = AppColor.text,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        fontFamily = fontFamilyResource(SharedRes.fonts.poppins_regular)
    )
) {
    Text(
        text = text, modifier = textModifier,
        style = style
    )
}