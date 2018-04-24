package com.example.helloworld;

import java.util.concurrent.ExecutorService;

import com.google.inject.Inject;

import io.dropwizard.lifecycle.Managed;

public class HelloWorldManaged implements Managed {
  private final ExecutorService executorService;

  @Inject
  public HelloWorldManaged(ExecutorService executorService) {
    this.executorService = executorService;
  }

  @Override
  public void start() throws Exception {}

  @Override
  public void stop() throws Exception {
    executorService.shutdown();
  }
}
