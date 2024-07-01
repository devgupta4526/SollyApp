package com.underground.solly.presentation.session;

import com.underground.solly.domain.repository.SessionRepository;
import com.underground.solly.domain.repository.SubjectRepository;
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
public final class SessionViewModel_Factory implements Factory<SessionViewModel> {
  private final Provider<SubjectRepository> subjectRepositoryProvider;

  private final Provider<SessionRepository> sessionRepositoryProvider;

  public SessionViewModel_Factory(Provider<SubjectRepository> subjectRepositoryProvider,
      Provider<SessionRepository> sessionRepositoryProvider) {
    this.subjectRepositoryProvider = subjectRepositoryProvider;
    this.sessionRepositoryProvider = sessionRepositoryProvider;
  }

  @Override
  public SessionViewModel get() {
    return newInstance(subjectRepositoryProvider.get(), sessionRepositoryProvider.get());
  }

  public static SessionViewModel_Factory create(
      Provider<SubjectRepository> subjectRepositoryProvider,
      Provider<SessionRepository> sessionRepositoryProvider) {
    return new SessionViewModel_Factory(subjectRepositoryProvider, sessionRepositoryProvider);
  }

  public static SessionViewModel newInstance(SubjectRepository subjectRepository,
      SessionRepository sessionRepository) {
    return new SessionViewModel(subjectRepository, sessionRepository);
  }
}
