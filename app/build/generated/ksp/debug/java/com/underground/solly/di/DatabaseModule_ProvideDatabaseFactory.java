package com.underground.solly.di;

import android.app.Application;
import com.underground.solly.data.local.AppDatabase;
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
public final class DatabaseModule_ProvideDatabaseFactory implements Factory<AppDatabase> {
  private final Provider<Application> applicationProvider;

  public DatabaseModule_ProvideDatabaseFactory(Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public AppDatabase get() {
    return provideDatabase(applicationProvider.get());
  }

  public static DatabaseModule_ProvideDatabaseFactory create(
      Provider<Application> applicationProvider) {
    return new DatabaseModule_ProvideDatabaseFactory(applicationProvider);
  }

  public static AppDatabase provideDatabase(Application application) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideDatabase(application));
  }
}
