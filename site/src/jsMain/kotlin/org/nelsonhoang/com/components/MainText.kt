package org.nelsonhoang.com.components

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
import org.nelsonhoang.com.util.Constants

/**
 * Component for all the text shown in the [MainSection]
 */
@Composable
fun MainText(breakpoint: Breakpoint) {
    Column {
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(if (breakpoint >= Breakpoint.LG) 45.px else 20.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Primary.rgb)
                .toAttrs()
        ) {
            Text("Hello, I am")
        }
        P(
            attrs = Modifier
                .margin(top = 20.px, bottom = 0.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(if (breakpoint >= Breakpoint.LG) 68.px else 40.px)
                .fontWeight(FontWeight.Bolder)
                .color(Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text("Nelson Hoang")
        }
        P(
            attrs = Modifier
                .margin(top = 10.px, bottom = 5.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(30.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text("Android Developer with Backend Experience")
        }
    }
}