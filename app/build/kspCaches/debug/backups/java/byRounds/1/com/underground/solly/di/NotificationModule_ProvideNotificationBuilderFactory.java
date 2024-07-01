package com.underground.solly.di;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("dagger.hilt.android.scopes.ServiceScoped")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class NotificationModule_ProvideNotificationBuilderFactory implements Factory<NotificationCompat.Builder> {
  private final Provider<Context> contextProvider;

  public NotificationModule_ProvideNotificationBuilderFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NotificationCompat.Builder get() {
    return provideNotificationBuilder(contextProvider.get());
  }

  public static NotificationModule_ProvideNotificationBuilderFactory create(
      Provider<Context> contextProvider) {
    return new NotificationModule_ProvideNotificationBuilderFactory(contextProvider);
  }

  public static NotificationCompat.Builder provideNotificationBuilder(Context context) {
    return Preconditions.checkNotNullFromProvides(NotificationModule.INSTANCE.provideNotificationBuilder(context));
  }
}
