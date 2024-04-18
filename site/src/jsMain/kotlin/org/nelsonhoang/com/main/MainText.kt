package org.nelsonhoang.com.main

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.nelsonhoang.com.model.Theme
import org.nelsonhoang.com.util.Constants.FONT_FAMILY

const val HEADER_TEXT1 = "Hello, I am"
const val HEADER_TEXT2 = "Nelson Hoang"
const val HEADER_TEXT3 = "Android Developer with Backend Experience"
const val BODY_TEXT =
    "I am passionate about developing Mobile Apps and love building backend APIs whenever I get the chance \uD83D\uDE42"

/**
 * Component for all the text shown in the [MainSection]
 */
@Composable
fun MainText(breakpoint: Breakpoint) {
    Column{
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(if (breakpoint >= Breakpoint.LG) 45.px else 20.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Primary.rgb)
                .toAttrs()
        ) {
            Text(HEADER_TEXT1)
        }
        P(
            attrs = Modifier
                .margin(top = 20.px, bottom = 0.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(if (breakpoint >= Breakpoint.LG) 68.px else 40.px)
                .fontWeight(FontWeight.Bolder)
                .color(Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text(HEADER_TEXT2)
        }
        P(
            attrs = Modifier
                .margin(top = 10.px, bottom = 5.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(30.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text(HEADER_TEXT3)
        }
        P(
            attrs = Modifier
                .margin(bottom = 25.px)
                .maxWidth(400.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(35.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Secondary.rgb)
                .lineHeight(48.px)
                .toAttrs()
        ) {
            Text(BODY_TEXT)
        }
    }
}