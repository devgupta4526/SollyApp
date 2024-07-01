package com.underground.solly.presentation.session

import com.underground.solly.domain.model.Session
import com.underground.solly.domain.model.Subject

sealed class SessionEvent {
    data class OnRelatedSubjectChange(val subject: Subject) : SessionEvent()
    data class SaveSession(val duration: Long) : SessionEvent()
    data class OnDeleteSessionButtonClick(val session: Session) : SessionEvent()
    data object DeleteSession : SessionEvent()
    data object NotifyToUpdateSubject : SessionEvent()
    data class UpdateSubjectIdAndRelatedSubject(
        val subjectId: Int?,
        val relatedToSubject: String?
    ) : SessionEvent()
}
