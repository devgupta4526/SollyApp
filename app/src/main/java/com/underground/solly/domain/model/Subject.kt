package com.underground.solly.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.underground.solly.presentation.theme.gradient1
import com.underground.solly.presentation.theme.gradient2
import com.underground.solly.presentation.theme.gradient3
import com.underground.solly.presentation.theme.gradient4
import com.underground.solly.presentation.theme.gradient5

@Entity
data class Subject(
    val name: String,
    val goalHours: Float,
    val colors: List<Int>,
    @PrimaryKey(autoGenerate = true)
    val subjectId: Int? = null
) {
    companion object {
        val subjectCardColors = listOf(gradient1, gradient2, gradient3, gradient4, gradient5)
    }
}
