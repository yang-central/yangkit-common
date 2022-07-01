package org.yangcentral.yangkit.common.api;

import java.net.URI;
import java.util.Objects;

public class QName implements Comparable<QName> {
   private URI namespace;
   private String prefix;
   private String localName;

   public QName(URI namespace, String prefix, String localName) {
      this.namespace = namespace;
      this.prefix = prefix;
      this.localName = localName;
   }

   public QName(URI namespace, String localName) {
      this.namespace = namespace;
      this.localName = localName;
   }

   public QName(String namespace, String prefix, String localName) {
      this.namespace = URI.create(namespace);
      this.prefix = prefix;
      this.localName = localName;
   }

   public QName(String namespace, String localName) {
      this.namespace = URI.create(namespace);
      this.localName = localName;
   }

   public QName(Namespace namespace, String localName) {
      this.namespace = namespace.getUri();
      this.prefix = namespace.getPrefix();
      this.localName = localName;
   }

   public URI getNamespace() {
      return this.namespace;
   }

   public String getPrefix() {
      return this.prefix;
   }

   public String getLocalName() {
      return this.localName;
   }

   public void setPrefix(String prefix) {
      this.prefix = prefix;
   }

   public String getQualifiedName() {
      return null == this.prefix ? this.localName : this.prefix + ":" + this.localName;
   }

   public boolean equals(Object o) {
      if (null == o) {
         return false;
      } else if (this == o) {
         return true;
      } else if (!(o instanceof QName)) {
         return false;
      } else {
         QName qName = (QName)o;
         if (this.hashCode() != qName.hashCode()) {
            return false;
         } else {
            return this.getNamespace().equals(qName.getNamespace()) && this.getLocalName().equals(qName.getLocalName());
         }
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.getNamespace(), this.getLocalName()});
   }

   public int compareTo(QName o) {
      int compare = this.getLocalName().compareTo(o.getLocalName());
      return 0 != compare ? compare : this.getNamespace().compareTo(o.getNamespace());
   }
}
