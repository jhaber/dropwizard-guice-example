package com.example.helloworld;

import java.util.concurrent.ExecutorService;

import com.google.inject.Inject;

public class ExampleExecutorUser {

  @Inject
  public ExampleExecutorUser(ExecutorService executorService) {
    executorService.submit(() -> {
      // do some stuff
    });
    throw new RuntimeException("failure!");
  }
}
