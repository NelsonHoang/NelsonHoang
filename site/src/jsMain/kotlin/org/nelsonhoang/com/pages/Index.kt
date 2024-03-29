package org.nelsonhoang.com.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.dom.Text
import org.nelsonhoang.com.sections.MainSection

@Page
@Composable
fun HomePage() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        MainSection()
    }
}
