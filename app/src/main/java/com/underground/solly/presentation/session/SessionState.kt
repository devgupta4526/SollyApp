package com.underground.solly.presentation.session

import com.underground.solly.domain.model.Session
import com.underground.solly.domain.model.Subject

data class SessionState(
    val subjects: List<Subject> = emptyList(),
    val sessions: List<Session> = emptyList(),
    val relatedToSubject: String? = null,
    val subjectId: Int? = null,
    val session: Session? = null
)
