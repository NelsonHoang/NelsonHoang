package org.nelsonhoang.com.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.FaInstagram
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.px
import org.nelsonhoang.com.style.SocialLinkStyle

/**
 * @return A Component that contains social media links
 * */
@Composable
fun SocialBar(isRow: Boolean = false) {
    if (isRow) {
        Row(
            modifier = Modifier
                .margin(top = 25.px)
                .padding(leftRight = 25.px)
                .minHeight(40.px)
                .borderRadius(r = 20.px)
                .backgroundColor(Colors.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            SocialLinks(isRow = true)
        }
    } else {
        Column(
            modifier = Modifier
                .margin(right = 25.px)
                .padding(top = 25.px)
                .minWidth(40.px)
                .borderRadius(r = 20.px)
                .backgroundColor(Colors.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SocialLinks()
        }
    }
}

@Composable
private fun SocialLinks(isRow: Boolean = false) {
    Link(
        path = LINKEDIN_URL,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaLinkedin(
            modifier = SocialLinkStyle.toModifier()
                .margin(
                    bottom = if (isRow) 0.px else 40.px,
                    right = if (isRow) 40.px else 0.px
                ),
            size = IconSize.LG
        )
    }
    Link(
        path = INSTAGRAM_URL,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaInstagram(
            modifier = SocialLinkStyle.toModifier()
                .margin(
                    bottom = if (isRow) 0.px else 40.px,
                    right = if (isRow) 40.px else 0.px
                ),
            size = IconSize.LG
        )
    }
}

private const val INSTAGRAM_URL = "https://www.instagram.com/nellyh808/"
private const val LINKEDIN_URL = "https://www.linkedin.com/in/nelsonhoang/"