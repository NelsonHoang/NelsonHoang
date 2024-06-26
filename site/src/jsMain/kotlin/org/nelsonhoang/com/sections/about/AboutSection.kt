package org.nelsonhoang.com.sections.about

import androidx.compose.runtime.*
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
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.nelsonhoang.com.components.SectionTitle
import org.nelsonhoang.com.model.Section
import org.nelsonhoang.com.model.Theme
import org.nelsonhoang.com.util.Constants.FONT_FAMILY
import org.nelsonhoang.com.util.Constants.SECTION_PADDING
import org.nelsonhoang.com.util.Constants.SECTION_WIDTH
import org.nelsonhoang.com.util.ObserveViewPortEntered
import org.nelsonhoang.com.util.Res
import org.nelsonhoang.com.util.animateNumbers

/**
 * About me section of the Home Page
 */
@Composable
fun AboutSection() {
    Box(
        modifier = Modifier
            .id(Section.About.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = SECTION_PADDING.px),
        contentAlignment = Alignment.Center
    ) {
        AboutContent()
    }
}

/**
 * @return [Composable] with information about hobbies and maybe an image if the
 * screen is large enough.
 */
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

/**
 * @return [Composable] showing an image of self
 */
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

/**
 * @return [Composable] showing an illustration of hobbies
 */
@Composable
fun AboutMe() {
    val scope = rememberCoroutineScope()
    var viewportEntered by remember { mutableStateOf(false) }
    val animatePercentage = remember { mutableStateListOf(0, 0, 0, 0, 0) }

    ObserveViewPortEntered(
        sectionId = Section.About.id,
        distanceFromTop = 300.0,
        onViewportEntered = {
            viewportEntered = true
            Hobbies.entries.forEach { skill ->
                scope.launch {
                    animateNumbers(
                        number = skill.percentage.value.toInt(),
                        onUpdate = {
                            animatePercentage[skill.ordinal] = it
                        }
                    )
                }
            }
        }
    )

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
            Text(ABOUT_ME_TEXT)
        }
        Hobbies.entries.forEach { skill ->
            HobbiesBar(
                name = skill.title,
                index = skill.ordinal,
                percentage = if (viewportEntered) skill.percentage else 0.percent,
                animatedPercentage = if (viewportEntered) animatePercentage[skill.ordinal] else 0
            )
        }
    }
}
const val ABOUT_ME_TEXT = "I love playing basketball and my favorite NBA team " +
        "are the L.A. Lakers. My all time favorite video game is Counter-Strike" +
        "while Cyberpunk 2077 would be a recent favorite. Italy and Japan are " +
        "among my favorite countries that I have visited."