package com.omega.san.components

import androidx.compose.runtime.Composable
import com.omega.san.components.ID.BOX_PARENT_ID
import com.omega.san.components.ID.COLUMN_PARENT_ID
import com.omega.san.components.ID.GREEN_OVERLAY_ID
import com.omega.san.components.ID.LINK_ICON_ID
import com.omega.san.components.ID.PORTFOLIO_DESCRIPTION_ID
import com.omega.san.components.ID.PORTFOLIO_TITLE_ID
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Width
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.nelsonhoang.com.model.Theme
import org.nelsonhoang.com.sections.blog.Blog
import org.nelsonhoang.com.sections.blog.BlogSectionStyle
import org.nelsonhoang.com.util.Constants
import org.nelsonhoang.com.util.Constants.FONT_FAMILY
import org.nelsonhoang.com.util.Res

@Composable
fun BlogCard(
    modifier: Modifier = Modifier,
    blog: Blog,
    link: String = "http://localhost:8080/blog"
) {
    Link(
        modifier = BlogSectionStyle.toModifier()
            .textDecorationLine(TextDecorationLine.None),
        path = link,
        openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE
    ) {
        Column(
            modifier = modifier
                .id(COLUMN_PARENT_ID)
                .width(Width.MaxContent)
        ) {
            Box(
                modifier = Modifier
                    .id(BOX_PARENT_ID)
                    .fillMaxWidth()
                    .maxWidth(300.px)
                    .margin(bottom = 20.px)
            ) {
                Image(
                    modifier = Modifier
                        .size(300.px)
                        .objectFit(ObjectFit.Cover),
                    src = blog.image,
                    description = "Portfolio Image"
                )
                Box(
                    modifier = Modifier
                        .id(GREEN_OVERLAY_ID)
                        .fillMaxHeight()
                        .backgroundColor(
                            argb(
                                a = 0.5f,
                                r = 0,
                                g = 167,
                                b = 142
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .id(LINK_ICON_ID)
                            .size(32.px),
                        src = Res.Img.LINK,
                        description = "Link Icon"
                    )
                }
            }
            P(
                attrs = Modifier
                    .id(PORTFOLIO_TITLE_ID)
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()
            ) {
                Text(blog.title)
            }
            P(
                attrs = Modifier
                    .id(PORTFOLIO_DESCRIPTION_ID)
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)
                    .opacity(50.percent)
                    .toAttrs()
            ) {
                Text(blog.description)
            }
        }
    }
}

object ID {
    const val BOX_PARENT_ID = "boxParent"
    const val COLUMN_PARENT_ID = "columnParent"
    const val GREEN_OVERLAY_ID = "greenOverlay"
    const val LINK_ICON_ID = "linkIcon"
    const val PORTFOLIO_DESCRIPTION_ID = "portfolioDescription"
    const val PORTFOLIO_TITLE_ID = "portfolioTitle"
}