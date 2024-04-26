package org.nelsonhoang.com.sections.about

import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.percent

enum class Hobbies(
    val title: String,
    val percentage: CSSSizeValue<CSSUnit.percent>
) {
    Android(
        title = "Android and Web Development",
        percentage = 100.percent
    ),
    Basketball(
        title = "Basketball",
        percentage = 100.percent
    ),
    Music(
        title = "Backend",
        percentage = 90.percent
    ),
    VideoGames(
        title = "Play Video Games",
        percentage = 75.percent
    ),
    Travel(
        title = "Travel the world",
        percentage = 90.percent
    ),
}