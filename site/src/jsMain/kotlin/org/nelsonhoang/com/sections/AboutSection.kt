package org.nelsonhoang.com.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.nelsonhoang.com.components.SectionTitle
import org.nelsonhoang.com.model.Section
import org.nelsonhoang.com.model.Theme
import org.nelsonhoang.com.style.AboutImageStyle
import org.nelsonhoang.com.style.AboutTextStyle
import org.nelsonhoang.com.util.Constants.FONT_FAMILY
import org.nelsonhoang.com.util.Constants.SECTION_WIDTH
import org.nelsonhoang.com.util.Res

@Composable
fun AboutSection() {
    Box(
        modifier = Modifier
            .id(Section.About.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 150.px),
        contentAlignment = Alignment.Center
    ) {
        AboutContent()
    }
}

@Composable
fun AboutContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            )
            .maxWidth(1200.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleGrid(
            modifier = Modifier.fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
            numColumns = numColumns(base = 1, md = 2)
        ) {
            if (breakpoint >= Breakpoint.MD) {
                AboutImage()
            }
            AboutMe()
        }
    }
}

@Composable
fun AboutImage() {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = AboutImageStyle.toModifier()
                .fillMaxWidth(80.percent),
            src = Res.Img.ABOUT,
            description = "About Image"
        )
    }
}

@Composable
fun AboutMe() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        SectionTitle(section = Section.About)
        P(
            attrs = AboutTextStyle.toModifier()
                .margin(topBottom = 25.px)
                .maxWidth(500.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(18.px)
                .fontWeight(FontWeight.Normal)
                .fontStyle(FontStyle.Italic)
                .color(Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text("Hello")
        }
    }
}