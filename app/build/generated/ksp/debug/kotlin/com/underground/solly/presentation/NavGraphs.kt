package com.underground.solly.presentation

import com.ramcosta.composedestinations.spec.*
import com.underground.solly.presentation.destinations.*

/**
 * Class generated if any Composable is annotated with `@Destination`.
 * It aggregates all [TypedDestination]s in their [NavGraph]s.
 */
public object NavGraphs {

    public val root: NavGraph = NavGraph(
        route = "root",
        startRoute = DashboardScreenRouteDestination,
        destinations = listOf(
            DashboardScreenRouteDestination,
			SessionScreenRouteDestination,
			SubjectScreenRouteDestination,
			TaskScreenRouteDestination
        )
    )
}