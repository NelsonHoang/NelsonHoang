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
    Experience(
        id = "experience",
        title = "Experience",
        subtitle = "Work Experience",
        path = "#experience"
    ),
    Blog(
        id = "blog",
        title = "Blog",
        subtitle = "Blog",
        path = "#blog"
    ),
    About(
        id = "about",
        title = "About Me",
        subtitle = "What do I like to do?",
        path = "#about"
    ),
}