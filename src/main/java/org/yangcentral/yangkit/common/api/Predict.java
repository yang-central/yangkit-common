package org.yangcentral.yangkit.common.api;

import java.net.URI;
import java.util.Map;
import java.util.Objects;
import org.jaxen.NamespaceContext;

public class Predict {
   private QName name;
   private String value;
   private Map<String, URI> additionalNamespaces;

   public Predict(QName name, String value) {
      this.name = name;
      this.value = value;
   }

   public Predict(QName name, String value, Map<String, URI> additionalNamespaces) {
      this.name = name;
      this.value = value;
      this.additionalNamespaces = additionalNamespaces;
   }

   public Map<String, URI> getAdditionalNamespaces() {
      return this.additionalNamespaces;
   }

   public QName getName() {
      return this.name;
   }

   public String getValue() {
      return this.value;
   }

   public String toString() {
      StringBuilder sb = new StringBuilder();
      String qulifiedName = this.getName().getQualifiedName();
      sb.append(qulifiedName).append(" = ").append("'" + this.value + "'");
      return sb.toString();
   }

   public String toString(NamespaceContextDom4j namespaceContext) {
      StringBuilder sb = new StringBuilder();
      String qulifiedName = namespaceContext.translateNamespaceUriToPrefix(this.getName().getNamespace().toASCIIString()) + ":" + this.getName().getLocalName();
      sb.append(qulifiedName).append(" = ").append("'" + this.value + "'");
      return sb.toString();
   }

   public static Predict parse(String predictStr, NamespaceContext namespaceContext, URI defaultNamespace) {
      Predict predict = null;
      int position = predictStr.indexOf("=");
      String name = predictStr.substring(0, position).trim();
      String value = predictStr.substring(position + 1).trim();
      if (name.contains(":")) {
         String[] args = name.split(":");
         String prefix = args[0];
         String localName = args[1];
         String namespaceUri = namespaceContext.translateNamespacePrefixToUri(prefix);
         if (null == namespaceUri) {
            throw new IllegalArgumentException("can not find prefix:" + prefix + "'s namespace");
         }

         QName qName = new QName(namespaceUri, prefix, localName);
         predict = new Predict(qName, value);
      } else {
         QName qName = new QName(defaultNamespace, name);
         predict = new Predict(qName, value);
      }

      return predict;
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (!(o instanceof Predict)) {
         return false;
      } else {
         Predict predict = (Predict)o;
         return this.getName().equals(predict.getName()) && this.getValue().equals(predict.getValue());
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.getName(), this.getValue()});
   }
}
