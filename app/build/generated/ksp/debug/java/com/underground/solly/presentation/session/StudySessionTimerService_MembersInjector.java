package com.underground.solly.presentation.session;

import android.app.NotificationManager;
import androidx.core.app.NotificationCompat;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class StudySessionTimerService_MembersInjector implements MembersInjector<StudySessionTimerService> {
  private final Provider<NotificationManager> notificationManagerProvider;

  private final Provider<NotificationCompat.Builder> notificationBuilderProvider;

  public StudySessionTimerService_MembersInjector(
      Provider<NotificationManager> notificationManagerProvider,
      Provider<NotificationCompat.Builder> notificationBuilderProvider) {
    this.notificationManagerProvider = notificationManagerProvider;
    this.notificationBuilderProvider = notificationBuilderProvider;
  }

  public static MembersInjector<StudySessionTimerService> create(
      Provider<NotificationManager> notificationManagerProvider,
      Provider<NotificationCompat.Builder> notificationBuilderProvider) {
    return new StudySessionTimerService_MembersInjector(notificationManagerProvider, notificationBuilderProvider);
  }

  @Override
  public void injectMembers(StudySessionTimerService instance) {
    injectNotificationManager(instance, notificationManagerProvider.get());
    injectNotificationBuilder(instance, notificationBuilderProvider.get());
  }

  @InjectedFieldSignature("com.underground.solly.presentation.session.StudySessionTimerService.notificationManager")
  public static void injectNotificationManager(StudySessionTimerService instance,
      NotificationManager notificationManager) {
    instance.notificationManager = notificationManager;
  }

  @InjectedFieldSignature("com.underground.solly.presentation.session.StudySessionTimerService.notificationBuilder")
  public static void injectNotificationBuilder(StudySessionTimerService instance,
      NotificationCompat.Builder notificationBuilder) {
    instance.notificationBuilder = notificationBuilder;
  }
}
