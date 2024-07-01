package com.underground.solly.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavBackStackEntry
import com.underground.solly.presentation.destinations.SubjectScreenRouteDestination
import com.underground.solly.presentation.destinations.TaskScreenRouteDestination
import com.underground.solly.presentation.subject.SubjectScreenNavArgs
import com.underground.solly.presentation.task.TaskScreenNavArgs

public inline fun <reified T> SavedStateHandle.navArgs(): T {
    return navArgs(T::class.java, this)
}

public inline fun <reified T> NavBackStackEntry.navArgs(): T {
    return navArgs(T::class.java, this)
}

@Suppress("UNCHECKED_CAST")
public fun <T> navArgs(argsClass: Class<T>, argsContainer: SavedStateHandle): T {
    return when (argsClass) {
		SubjectScreenNavArgs::class.java -> SubjectScreenRouteDestination.argsFrom(argsContainer) as T
		TaskScreenNavArgs::class.java -> TaskScreenRouteDestination.argsFrom(argsContainer) as T
        else -> error("Class ${argsClass} is not a navigation arguments class!")
    }
}

@Suppress("UNCHECKED_CAST")
public fun <T> navArgs(argsClass: Class<T>, argsContainer: NavBackStackEntry): T {
    return when (argsClass) {
		SubjectScreenNavArgs::class.java -> SubjectScreenRouteDestination.argsFrom(argsContainer) as T
		TaskScreenNavArgs::class.java -> TaskScreenRouteDestination.argsFrom(argsContainer) as T
        else -> error("Class ${argsClass} is not a navigation arguments class!")
    }
}
