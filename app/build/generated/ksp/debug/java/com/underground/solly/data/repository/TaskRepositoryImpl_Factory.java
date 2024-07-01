package com.underground.solly.data.repository;

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
public final class TaskRepositoryImpl_Factory implements Factory<TaskRepositoryImpl> {
  private final Provider<TaskDao> taskDaoProvider;

  public TaskRepositoryImpl_Factory(Provider<TaskDao> taskDaoProvider) {
    this.taskDaoProvider = taskDaoProvider;
  }

  @Override
  public TaskRepositoryImpl get() {
    return newInstance(taskDaoProvider.get());
  }

  public static TaskRepositoryImpl_Factory create(Provider<TaskDao> taskDaoProvider) {
    return new TaskRepositoryImpl_Factory(taskDaoProvider);
  }

  public static TaskRepositoryImpl newInstance(TaskDao taskDao) {
    return new TaskRepositoryImpl(taskDao);
  }
}
