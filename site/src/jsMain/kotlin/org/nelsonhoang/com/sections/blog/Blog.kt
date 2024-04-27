package org.nelsonhoang.com.sections.blog

import org.nelsonhoang.com.util.Res

enum class Blog(
    val image: String,
    val title: String,
    val description: String
) {
    One(
        image = Res.Img.SELF_LOGO,
        title = "Blog1",
        description = "Blog 1"
    )
}
