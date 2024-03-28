package org.nelsonhoang.com.model

enum class Section(
    val id: String,
    val title: String,
    val subtitle: String,
    val path: String
) {
    Home(
        id = "home",
        title = "Home",
        subtitle = "",
        path = "#home"
    ),
    About(
        id = "about",
        title = "About Me",
        subtitle = "About Me",
        path = "#about"
    ),
    Experience(
        id = "experience",
        title = "Experience",
        subtitle = "Work Experience",
        path = "#experience"
    ),
    Contact(
        id = "contact",
        title = "Contact me",
        subtitle = "Get in Touch",
        path = "#contact"
    ),
}