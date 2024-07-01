package com.underground.solly.data.repository;

import com.underground.solly.data.local.SessionDao;
import com.underground.solly.data.local.SubjectDao;
import com.underground.solly.data.local.TaskDao;
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
public final class SubjectRepositoryImpl_Factory implements Factory<SubjectRepositoryImpl> {
  private final Provider<SubjectDao> subjectDaoProvider;

  private final Provider<TaskDao> taskDaoProvider;

  private final Provider<SessionDao> sessionDaoProvider;

  public SubjectRepositoryImpl_Factory(Provider<SubjectDao> subjectDaoProvider,
      Provider<TaskDao> taskDaoProvider, Provider<SessionDao> sessionDaoProvider) {
    this.subjectDaoProvider = subjectDaoProvider;
    this.taskDaoProvider = taskDaoProvider;
    this.sessionDaoProvider = sessionDaoProvider;
  }

  @Override
  public SubjectRepositoryImpl get() {
    return newInstance(subjectDaoProvider.get(), taskDaoProvider.get(), sessionDaoProvider.get());
  }

  public static SubjectRepositoryImpl_Factory create(Provider<SubjectDao> subjectDaoProvider,
      Provider<TaskDao> taskDaoProvider, Provider<SessionDao> sessionDaoProvider) {
    return new SubjectRepositoryImpl_Factory(subjectDaoProvider, taskDaoProvider, sessionDaoProvider);
  }

  public static SubjectRepositoryImpl newInstance(SubjectDao subjectDao, TaskDao taskDao,
      SessionDao sessionDao) {
    return new SubjectRepositoryImpl(subjectDao, taskDao, sessionDao);
  }
}
