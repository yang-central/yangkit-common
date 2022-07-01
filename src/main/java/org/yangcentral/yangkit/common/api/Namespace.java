package org.yangcentral.yangkit.common.api;

import java.net.URI;

public class Namespace {
   private URI uri;
   private String prefix;

   public Namespace(URI uri, String prefix) {
      this.uri = uri;
      this.prefix = prefix;
   }

   public Namespace(URI uri) {
      this.uri = uri;
   }

   public URI getUri() {
      return this.uri;
   }

   public String getPrefix() {
      return this.prefix;
   }
}
