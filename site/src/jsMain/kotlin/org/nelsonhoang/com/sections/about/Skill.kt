package org.nelsonhoang.com.sections.about

import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.percent

enum class Skill(
    val title: String,
    val percentage: CSSSizeValue<CSSUnit.percent>
) {
    Android(
        title = "Android",
        percentage = 100.percent
    ),
    Backend(
        title = "Backend",
        percentage = 80.percent
    ),
    Basketball(
        title = "Basketball",
        percentage = 100.percent
    ),
    VideoGames(
        title = "Video Games",
        percentage = 80.percent
    ),
    Travel(
        title = "Travel",
        percentage = 90.percent
    ),
}