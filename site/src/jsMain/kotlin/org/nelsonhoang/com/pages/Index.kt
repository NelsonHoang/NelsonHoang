package org.nelsonhoang.com.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import org.nelsonhoang.com.sections.about.AboutSection
import org.nelsonhoang.com.sections.blog.BlogSection
import org.nelsonhoang.com.sections.experience.ExperienceSection
import org.nelsonhoang.com.sections.main.MainSection
import org.nelsonhoang.com.sections.main.OverflowMenu
import org.nelsonhoang.com.util.Constants

@Page
@Composable
fun HomePage() {
    var menuOpened by remember { mutableStateOf(false)}

    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainSection(onMenuClicked = { menuOpened = true})
            ExperienceSection()
            if (shouldShowBlogSection()) {
                BlogSection()
            }
            AboutSection()
        }
        if (menuOpened) {
            OverflowMenu(onMenuClosed = {menuOpened = false})
        }
    }
}

fun shouldShowBlogSection(): Boolean {
    return Constants.NUMBER_OF_HEADER_ITEMS > 3
}
