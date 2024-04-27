package org.nelsonhoang.com.sections.blog

import com.omega.san.components.ID
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.nelsonhoang.com.model.Theme

val BlogSectionStyle by ComponentStyle {
    cssRule(" > #${ID.COLUMN_PARENT_ID} > #${ID.BOX_PARENT_ID} > #${ID.GREEN_OVERLAY_ID}") {
        Modifier
            .width(0.px)
            .transition(CSSTransition(property = "width", duration = 500.ms))
    }

    cssRule(":hover > #${ID.COLUMN_PARENT_ID} > #${ID.BOX_PARENT_ID} > #${ID.GREEN_OVERLAY_ID}") {
        Modifier.width(300.px)
    }

    cssRule(" > #${ID.COLUMN_PARENT_ID} > #${ID.BOX_PARENT_ID} > #${ID.GREEN_OVERLAY_ID} > #${ID.LINK_ICON_ID}") {
        Modifier
            .visibility(Visibility.Hidden)
    }


    cssRule(":hover > #${ID.COLUMN_PARENT_ID} > #${ID.BOX_PARENT_ID} > #${ID.GREEN_OVERLAY_ID} > #${ID.LINK_ICON_ID}") {
        Modifier
            .visibility(Visibility.Visible)
    }

    cssRule(" > #${ID.COLUMN_PARENT_ID} > #${ID.PORTFOLIO_TITLE_ID}") {
        Modifier
            .color(Theme.Secondary.rgb)
            .translateX(0.percent)
            .transition(
                CSSTransition(property = "width", duration = 200.ms),
                CSSTransition(property = "translate", duration = 200.ms)
            )
    }

    cssRule(":hover > #${ID.COLUMN_PARENT_ID} > #${ID.PORTFOLIO_TITLE_ID}") {
        Modifier
            .color(Theme.Primary.rgb)
            .translateX(5.percent)
    }

    cssRule(" > #${ID.COLUMN_PARENT_ID} > #${ID.PORTFOLIO_DESCRIPTION_ID}") {
        Modifier
            .color(Theme.Secondary.rgb)
            .translateX(0.percent)
            .transition(
                CSSTransition(property = "width", duration = 200.ms),
                CSSTransition(property = "translate", duration = 200.ms)
            )
    }

    cssRule(":hover > #${ID.COLUMN_PARENT_ID} > #${ID.PORTFOLIO_DESCRIPTION_ID}") {
        Modifier
            .color(Theme.Primary.rgb)
            .translateX(5.percent)
    }
}

val BlogArrowIconStyle by ComponentStyle {
    base {
        Modifier
            .color(Theme.Gray.rgb)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    hover {
        Modifier.color(Theme.Primary.rgb)
    }
}