package com.underground.solly.di;

import com.underground.solly.data.local.AppDatabase;
import com.underground.solly.data.local.TaskDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class DatabaseModule_ProvideTaskDaoDaoFactory implements Factory<TaskDao> {
  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_ProvideTaskDaoDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public TaskDao get() {
    return provideTaskDaoDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideTaskDaoDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvideTaskDaoDaoFactory(databaseProvider);
  }

  public static TaskDao provideTaskDaoDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideTaskDaoDao(database));
  }
}
