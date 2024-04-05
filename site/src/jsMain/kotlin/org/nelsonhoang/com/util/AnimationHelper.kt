package org.nelsonhoang.com.util

import androidx.compose.runtime.*
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.delay
import org.w3c.dom.events.EventListener

/**
 * Used to know when UI elements are scrolled into view
 */
@Composable
fun ObserveViewPortEntered(
    sectionId: String,
    distanceFromTop: Double,
    onViewportEntered: () -> Unit
) {
    var viewportEntered by remember { mutableStateOf(false) }
    val listener = remember {
        EventListener {
            val top =
                document.getElementById(sectionId)?.getBoundingClientRect()?.top
            if (top != null && top < distanceFromTop) {
                viewportEntered = true
            }
        }
    }

    LaunchedEffect(viewportEntered) {
        if (viewportEntered) {
            onViewportEntered()
            window.removeEventListener(
                type = EVENT_LISTENER_TYPE,
                callback = listener
            )
        } else {
            window.addEventListener(
                type = EVENT_LISTENER_TYPE,
                callback = listener
            )
        }
    }
}

suspend fun animateNumbers(
    number: Int,
    delay : Long = 10L,
    onUpdate: (Int) -> Unit
) {
    (0..number).forEach {
        delay(delay)
        onUpdate(it)
    }
}

const val EVENT_LISTENER_TYPE = "scroll"