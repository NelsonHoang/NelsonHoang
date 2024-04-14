package org.nelsonhoang.com.style

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.anyLink
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.filter
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.nelsonhoang.com.model.Theme

val NavigationItemStyle by ComponentStyle {
    base {
        Modifier
            .color(Theme.Secondary.rgb)
            .transition(
                CSSTransition(
                    property = "color",
                    duration = 200.ms
                )
            )
    }
    anyLink {
        Modifier
            .color(Theme.Secondary.rgb)
    }
    hover {
        Modifier
            .color(Theme.Primary.rgb)
    }
}

@OptIn(ExperimentalComposeWebApi::class)
val MainImageStyle by ComponentStyle {
    base {
        Modifier
            .styleModifier {
                filter {
                    grayscale(100.percent)
                }
            }
            .transition(CSSTransition(property = "width", duration = 200.ms))
    }
    hover {
        Modifier
            .styleModifier {
                filter {
                    grayscale(0.percent)
                }
            }
    }
}

val SocialLinkStyle by ComponentStyle {
    base {
        Modifier
            .color(Theme.Gray.rgb)
            .transition(CSSTransition(property = "color", 200.ms))
    }
    hover {
        Modifier.color(Theme.Primary.rgb)
    }
}