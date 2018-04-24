package com.example.helloworld.resources;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.example.helloworld.core.Saying;
import com.google.inject.Inject;
import com.google.inject.name.Named;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
  private static final Logger LOG = LoggerFactory.getLogger(HelloWorldResource.class);

  private final String template;
  private final String defaultName;
  private final AtomicLong counter;
  private final HttpHeaders headers;

  @Inject
  public HelloWorldResource(@Named("template") String template, @Named("defaultName") String defaultName, HttpHeaders headers) {
    LOG.info("Creating a new HelloWorldResource!");
    this.template = template;
    this.defaultName = defaultName;
    this.counter = new AtomicLong();
    this.headers = headers;
  }

  @GET
  @Timed
  public Saying sayHello(@QueryParam("name") Optional<String> name) {
    LOG.info("User-Agent: " + headers.getRequestHeader("User-Agent"));
    return new Saying(counter.incrementAndGet(), String.format(template, name.orElse(defaultName)));
  }
}
