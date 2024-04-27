package org.nelsonhoang.com.sections.blog

import androidx.compose.runtime.Composable
import com.omega.san.components.BlogCard
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowLeft
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRight
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.nelsonhoang.com.components.SectionTitle
import org.nelsonhoang.com.model.Section
import org.nelsonhoang.com.sections.blog.ID.SCROLLABLE_CONTAINER_ID
import org.nelsonhoang.com.util.Constants

/**
 * @return [Composable] defining the structure of [BlogContent]
 */
@Composable
fun BlogSection() {
    Box(
        modifier = Modifier
            .id(Section.Blog.id)
            .maxWidth(Constants.SECTION_WIDTH.px)
            .padding(topBottom = Constants.SECTION_PADDING.px),
        contentAlignment = Alignment.Center
    ) {
        BlogContent()
    }
}

/**
 * @return [Composable] with a selector for blog entries.
 */
@Composable
fun BlogContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth()
                .margin(bottom = 25.px),
            section = Section.Blog
        )
        BlogCards()
        BlogNavigation()
    }
}

/**
 * @return [Composable] representing a single blog card.
 */
@Composable
fun BlogCards() {
    Row(
        modifier = Modifier
            .id(SCROLLABLE_CONTAINER_ID)
            .fillMaxWidth()
            .margin(bottom = 25.px)
            .maxWidth(950.px)
            .overflow(Overflow.Hidden)
            .scrollBehavior(ScrollBehavior.Smooth)
    ) {
        Blog.entries.forEach { blog ->
            BlogCard(
                modifier = Modifier.margin(
                    right = if (blog != Blog.Three) 25.px else 0.px
                ),
                blog = blog
            )
        }
    }
}

/**
 * @return [Composable] representing the left and right arrow to navigate
 * the blog cards
 */
@Composable
fun BlogNavigation() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        FaArrowLeft(
            modifier = BlogArrowIconStyle.toModifier()
                .margin(right = 40.px)
                .cursor(Cursor.Pointer)
                .onClick {
                    document.getElementById(SCROLLABLE_CONTAINER_ID)
                        ?.scroll(x = -325.0, y = 0.0)
                },
            size = IconSize.LG
        )
        FaArrowRight(
            modifier = BlogArrowIconStyle.toModifier()
                .cursor(Cursor.Pointer)
                .onClick {
                    document.getElementById(SCROLLABLE_CONTAINER_ID)
                        ?.scroll(x = 325.0, y = 0.0)
                },
            size = IconSize.LG
        )
    }
}

object ID {
    const val SCROLLABLE_CONTAINER_ID = "scrollableContainer"
}