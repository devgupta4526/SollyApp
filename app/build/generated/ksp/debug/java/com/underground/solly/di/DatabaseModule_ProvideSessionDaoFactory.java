package com.underground.solly.di;

import com.underground.solly.data.local.AppDatabase;
import com.underground.solly.data.local.SessionDao;
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
public final class DatabaseModule_ProvideSessionDaoFactory implements Factory<SessionDao> {
  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_ProvideSessionDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public SessionDao get() {
    return provideSessionDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideSessionDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvideSessionDaoFactory(databaseProvider);
  }

  public static SessionDao provideSessionDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideSessionDao(database));
  }
}
