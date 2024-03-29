package org.nelsonhoang.com.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.nelsonhoang.com.components.Header
import org.nelsonhoang.com.components.MainText
import org.nelsonhoang.com.model.Section
import org.nelsonhoang.com.style.MainImageStyle
import org.nelsonhoang.com.util.Constants.SECTION_WIDTH
import org.nelsonhoang.com.util.Res

@Composable
fun MainSection() {
    Box(
        modifier = Modifier
            .id(Section.Home.id)
            .maxWidth(SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        MainBackground()
        MainContent()
    }
}

@Composable
fun MainBackground() {
    Image(
        modifier = Modifier
            .fillMaxSize()
            .objectFit(ObjectFit.Cover),
        src = Res.Img.BACKGROUND,
        description = "Background Image"
    )
}

@Composable
fun MainContent() {
    val breakpoint = rememberBreakpoint()
    Header()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleGrid(
            modifier = Modifier
                .fillMaxWidth(
                    if (breakpoint >= Breakpoint.MD) 80.percent
                    else 90.percent
                ),
            numColumns = numColumns(base = 1, md = 2)
        ) {
            MainText(breakpoint = breakpoint)
            MainImage()
        }
    }
}

@Composable
fun MainImage() {
    Column(
        modifier = Modifier
            .fillMaxSize(80.percent)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            modifier = MainImageStyle.toModifier().fillMaxWidth()
                .margin(left = 20.percent),
            src = Res.Img.SELF,
            description = "Self Image"
        )
    }
}