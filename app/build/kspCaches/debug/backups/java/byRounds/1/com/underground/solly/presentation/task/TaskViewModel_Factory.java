package com.underground.solly.presentation.task;

import androidx.lifecycle.SavedStateHandle;
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
public final class TaskViewModel_Factory implements Factory<TaskViewModel> {
  private final Provider<TaskRepository> taskRepositoryProvider;

  private final Provider<SubjectRepository> subjectRepositoryProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public TaskViewModel_Factory(Provider<TaskRepository> taskRepositoryProvider,
      Provider<SubjectRepository> subjectRepositoryProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.taskRepositoryProvider = taskRepositoryProvider;
    this.subjectRepositoryProvider = subjectRepositoryProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public TaskViewModel get() {
    return newInstance(taskRepositoryProvider.get(), subjectRepositoryProvider.get(), savedStateHandleProvider.get());
  }

  public static TaskViewModel_Factory create(Provider<TaskRepository> taskRepositoryProvider,
      Provider<SubjectRepository> subjectRepositoryProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new TaskViewModel_Factory(taskRepositoryProvider, subjectRepositoryProvider, savedStateHandleProvider);
  }

  public static TaskViewModel newInstance(TaskRepository taskRepository,
      SubjectRepository subjectRepository, SavedStateHandle savedStateHandle) {
    return new TaskViewModel(taskRepository, subjectRepository, savedStateHandle);
  }
}
