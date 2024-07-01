package com.underground.solly.presentation.subject;

import androidx.lifecycle.SavedStateHandle;
import com.underground.solly.domain.repository.SessionRepository;
import com.underground.solly.domain.repository.SubjectRepository;
import com.underground.solly.domain.repository.TaskRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class SubjectViewModel_Factory implements Factory<SubjectViewModel> {
  private final Provider<SubjectRepository> subjectRepositoryProvider;

  private final Provider<TaskRepository> taskRepositoryProvider;

  private final Provider<SessionRepository> sessionRepositoryProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public SubjectViewModel_Factory(Provider<SubjectRepository> subjectRepositoryProvider,
      Provider<TaskRepository> taskRepositoryProvider,
      Provider<SessionRepository> sessionRepositoryProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.subjectRepositoryProvider = subjectRepositoryProvider;
    this.taskRepositoryProvider = taskRepositoryProvider;
    this.sessionRepositoryProvider = sessionRepositoryProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public SubjectViewModel get() {
    return newInstance(subjectRepositoryProvider.get(), taskRepositoryProvider.get(), sessionRepositoryProvider.get(), savedStateHandleProvider.get());
  }

  public static SubjectViewModel_Factory create(
      Provider<SubjectRepository> subjectRepositoryProvider,
      Provider<TaskRepository> taskRepositoryProvider,
      Provider<SessionRepository> sessionRepositoryProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new SubjectViewModel_Factory(subjectRepositoryProvider, taskRepositoryProvider, sessionRepositoryProvider, savedStateHandleProvider);
  }

  public static SubjectViewModel newInstance(SubjectRepository subjectRepository,
      TaskRepository taskRepository, SessionRepository sessionRepository,
      SavedStateHandle savedStateHandle) {
    return new SubjectViewModel(subjectRepository, taskRepository, sessionRepository, savedStateHandle);
  }
}
