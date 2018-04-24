package com.example.helloworld;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Named;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class HelloWorldModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(ExecutorService.class).toInstance(Executors.newSingleThreadExecutor());
    bind(ExampleExecutorUser.class).asEagerSingleton();
  }

  @Provides
  @Named("template")
  public String provideTemplate(HelloWorldConfiguration configuration) {
    return configuration.getTemplate();
  }

  @Provides
  @Named("defaultName")
  public String provideDefaultName(HelloWorldConfiguration configuration) {
    return configuration.getDefaultName();
  }

}
