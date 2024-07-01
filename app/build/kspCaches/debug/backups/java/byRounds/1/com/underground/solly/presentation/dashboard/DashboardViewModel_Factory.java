package com.underground.solly.presentation.dashboard;

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
public final class DashboardViewModel_Factory implements Factory<DashboardViewModel> {
  private final Provider<SubjectRepository> subjectRepositoryProvider;

  private final Provider<SessionRepository> sessionRepositoryProvider;

  private final Provider<TaskRepository> taskRepositoryProvider;

  public DashboardViewModel_Factory(Provider<SubjectRepository> subjectRepositoryProvider,
      Provider<SessionRepository> sessionRepositoryProvider,
      Provider<TaskRepository> taskRepositoryProvider) {
    this.subjectRepositoryProvider = subjectRepositoryProvider;
    this.sessionRepositoryProvider = sessionRepositoryProvider;
    this.taskRepositoryProvider = taskRepositoryProvider;
  }

  @Override
  public DashboardViewModel get() {
    return newInstance(subjectRepositoryProvider.get(), sessionRepositoryProvider.get(), taskRepositoryProvider.get());
  }

  public static DashboardViewModel_Factory create(
      Provider<SubjectRepository> subjectRepositoryProvider,
      Provider<SessionRepository> sessionRepositoryProvider,
      Provider<TaskRepository> taskRepositoryProvider) {
    return new DashboardViewModel_Factory(subjectRepositoryProvider, sessionRepositoryProvider, taskRepositoryProvider);
  }

  public static DashboardViewModel newInstance(SubjectRepository subjectRepository,
      SessionRepository sessionRepository, TaskRepository taskRepository) {
    return new DashboardViewModel(subjectRepository, sessionRepository, taskRepository);
  }
}
