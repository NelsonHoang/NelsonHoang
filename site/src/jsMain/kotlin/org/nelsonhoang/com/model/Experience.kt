package org.nelsonhoang.com.model

enum class Experience(
    val number: String,
    val jobPosition : String,
    val description: String,
    val company: String,
    val from: String,
    val to: String
) {
    First(
        number = "01",
        jobPosition = "Kotlin Multi-Platform Developer",
        description = "A",
        company = "Google",
        from = "February 2022",
        to = "NOW",
    ),
    Second(
        number = "02",
        jobPosition = "Mobile Developer",
        description = "B",
        company = "Facebook",
        from = "January 2021",
        to = "October 2021",
    ),
    Third(
        number = "03",
        jobPosition = "Freelancer",
        description = "C",
        company = "Netflix",
        from = "March 2020",
        to = "August 2020",
    )
}