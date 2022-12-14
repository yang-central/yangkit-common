package org.yangcentral.yangkit.common.api;

import java.net.URI;
import java.util.Objects;

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

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (!(o instanceof Namespace)) {
         return false;
      }
      Namespace namespace = (Namespace) o;
      return getUri().equals(namespace.getUri());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getUri());
   }
}
