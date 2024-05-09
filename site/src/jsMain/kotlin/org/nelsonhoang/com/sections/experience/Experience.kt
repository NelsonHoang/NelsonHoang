package org.nelsonhoang.com.sections.experience

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
        description = "Facebook was my top choice while I was recruiting in 2017" +
                " for two main reasons. Reason number one was to experience the " +
                "Facebook culture I heard so much about of \"move fast and " +
                "break things.\" The second reason was to use the basketball " +
                "court, where I am happy to say I have met many friends \uD83D\uDE03 " +
                "I felt like I grew the most as a Software Engineering during my " +
                "time at the company formerly known as Facebook. I got to build" +
                "many new products on Facebook Stories and Reels and often had" +
                "to dive deep into client side and backend video infrastructure " +
                "code.",
        company = FACEBOOK,
        from = "August 2017",
        to = "November 2023",
    ),
    Second(
        number = "02",
        jobPosition = "Lead Android Developer / Full Stack Engineer",
        description = "I was itching to experience a start-up company and joined " +
                "Skulpt as their first Android engineer. Skulpt created a " +
                "device, a little smaller than modern iPhones, to use electrical" +
                " impedance in order to to detect body fat and muscle " +
                "hypertrophy. I built v1 of the Android and led two other " +
                "engineers to implement the app's redesign. When needed I'd " +
                "pick up Ruby on Rails backend work. We were found in Best Buy " +
                "and sold 30,000 units. Ultimately, we failed to sell at a scale " +
                "needed like FitBit. Nonetheless, I cherish taking a product " +
                "from 0 to 1.",
        company = SKULPT,
        from = "September 2014",
        to = "April 2017",
    ),
    Third(
        number = "01",
        jobPosition = "Android Developer",
        description = "I was part of Amazon Music in San Francisco, and we were " +
                "tasked with launching Prime Music on the Kindle Fire and " +
                "Android devices. It was an exciting time to be in S.F. as it was " +
                "my first job after college and unicorn companies were being " +
                "formed seemingly overnight. This is where I was blessed to meet " +
                "my mentors, who help me navigate life as a software engineer.",
        company = AMAZON,
        from = "August 2014",
        to = "July 2012",
    )
}

const val AMAZON = "Amazon"
const val FACEBOOK = "Facebook"
const val SKULPT = "Skulpt"