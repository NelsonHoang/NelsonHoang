package org.nelsonhoang.com.model

/**
 * Model representing each job.
 */
enum class Experience(
    val number: String,
    val jobPosition: String,
    val description: String,
    val company: String,
    val from: String,
    val to: String
) {
    First(
        number = "03",
        jobPosition = "Senior Android Developer",
        description = "Worked on video editing and infrastructure for Facebook Stories and Reels including building backend APIs when needed",
        company = "Facebook",
        from = "August 2017",
        to = "November 2023",
    ),
    Second(
        number = "02",
        jobPosition = "Lead Android Developer / Full Stack Engineer",
        description = "Built Skulpt's first Android app along with helping out with the Ruby on Rails backend",
        company = "Skulpt",
        from = "September 2014",
        to = "April 2017",
    ),
    Third(
        number = "01",
        jobPosition = "Android Developer",
        description = "Worked on the Amazon Music app for Prime Music and the Kindle Fire",
        company = "Amazon",
        from = "August 2014",
        to = "July 2012",
    )
}