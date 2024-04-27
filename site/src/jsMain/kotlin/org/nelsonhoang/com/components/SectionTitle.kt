package org.nelsonhoang.com.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.nelsonhoang.com.model.Section
import org.nelsonhoang.com.model.Theme
import org.nelsonhoang.com.util.Constants.FONT_FAMILY
import org.nelsonhoang.com.util.ObserveViewPortEntered

/**
 * Used to label each Section of the Home Page based on their title and subtitle.
 */
@Composable
fun SectionTitle(
    modifier: Modifier = Modifier,
    section: Section,
    alignment: Alignment.Horizontal = Alignment.Start
) {
    val scope = rememberCoroutineScope()
    var titleMargin by remember { mutableStateOf(50.px) }
    var subtitleMargin by remember { mutableStateOf(50.px) }

    ObserveViewPortEntered(
        sectionId = section.id,
        distanceFromTop = 700.0,
        onViewportEntered = {
            scope.launch {
                subtitleMargin = 0.px
                if (alignment == Alignment.Start) {
                    delay(25)
                }
                titleMargin = 0.px
            }
        }
    )

    Column(
        modifier = modifier,
        horizontalAlignment = alignment
    ) {
        createHeaderText(section, alignment, titleMargin)
        createSubtitleText(section, alignment, subtitleMargin)
        createDividerLine()
    }
}

/**
 * @return [P] representing the title text of the section title.
 */
@Composable
private fun createHeaderText(
    section: Section,
    alignment: Alignment.Horizontal,
    titleMargin: CSSSizeValue<CSSUnit.px>
) {
    return P(
        attrs = Modifier
            .fillMaxWidth()
            .textAlign(
                when (alignment) {
                    Alignment.CenterHorizontally -> TextAlign.Center
                    Alignment.End -> TextAlign.End
                    else -> TextAlign.Start
                }
            )
            .margin(
                left = titleMargin,
                top = 0.px,
                bottom = 0.px
            )
            .fontFamily(FONT_FAMILY)
            .fontSize(25.px)
            .fontWeight(FontWeight.Normal)
            .color(Theme.Primary.rgb)
            .transition(
                createSectionTitleTransition()
            )
            .toAttrs()
    ) {
        Text(section.title)
    }
}

/**
 * @return [P] representing the subtitle text of the section title.
 */
@Composable
private fun createSubtitleText(
    section: Section,
    alignment: Alignment.Horizontal,
    subtitleMargin: CSSSizeValue<CSSUnit.px>
) {
    return P(
        attrs = Modifier
            .fillMaxWidth()
            .textAlign(
                when (alignment) {
                    Alignment.CenterHorizontally -> TextAlign.Center
                    Alignment.End -> TextAlign.End
                    else -> TextAlign.Start
                }
            )
            .margin(
                left = if (alignment == Alignment.Start) subtitleMargin else 0.px,
                right = if (alignment == Alignment.CenterHorizontally) subtitleMargin else 0.px,
                bottom = 10.px,
                top = 0.px
            )
            .fontFamily(FONT_FAMILY)
            .fontSize(40.px)
            .fontWeight(FontWeight.Bold)
            .color(Theme.Secondary.rgb)
            .transition(
                createSectionTitleTransition()
            )
            .toAttrs()
    ) {
        Text(section.subtitle)
    }
}

/**
 * @return [Box] represented as a lien divider below the title and subtitle.
 */
@Composable
private fun createDividerLine() {
    Box(
        modifier = Modifier
            .height(2.px)
            .width(80.px)
            .backgroundColor(Theme.Primary.rgb)
            .borderRadius(r = 50.px)
    )
}

/**
 * @return [CSSTransition] that animates the text elements from right to left.
 */
private fun createSectionTitleTransition(): CSSTransition {
    return CSSTransition(
        property = "margin",
        duration = 300.ms
    )
}