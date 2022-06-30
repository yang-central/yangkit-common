package com.huawei.yang.common.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.jaxen.NamespaceContext;

public class AbsolutePath {
   private List<XPathStep> steps;

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (!(o instanceof AbsolutePath)) {
         return false;
      } else {
         AbsolutePath that = (AbsolutePath)o;
         return Objects.equals(this.getSteps(), that.getSteps());
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.getSteps()});
   }

   public void addStep(XPathStep step) {
      if (null == this.steps) {
         this.steps = new ArrayList();
      }

      this.steps.add(step);
   }

   public List<XPathStep> getSteps() {
      return this.steps;
   }

   public String toString() {
      StringBuilder sb = new StringBuilder();
      if (null == this.steps) {
         return "/";
      } else {
         Iterator var2 = this.steps.iterator();

         while(var2.hasNext()) {
            XPathStep step = (XPathStep)var2.next();
            sb.append("/").append(step.toString());
         }

         return sb.toString();
      }
   }

   public String toString(NamespaceContextDom4j namespaceContext) {
      StringBuilder sb = new StringBuilder();
      if (null == this.steps) {
         return "/";
      } else {
         Iterator var3 = this.steps.iterator();

         while(var3.hasNext()) {
            XPathStep step = (XPathStep)var3.next();
            sb.append("/").append(step.toString(namespaceContext));
         }

         return sb.toString();
      }
   }

   public boolean isRootPath() {
      return this.steps == null || this.steps.size() == 0;
   }

   public static AbsolutePath parse(String xpath, NamespaceContext namespaceContext, URI defaultNamespace) {
      if (!xpath.startsWith("/")) {
         throw new IllegalArgumentException("absolute path should start with '/'");
      } else {
         AbsolutePath absolutePath = new AbsolutePath();
         int length = xpath.length();
         int stepStart = -1;
         int stepEnd = -1;
         boolean inDQuotes = false;
         boolean inSQuotes = false;

         for(int i = 0; i < length; ++i) {
            char c = xpath.charAt(i);
            if (c == '/') {
               if (!inDQuotes && !inSQuotes) {
                  if (-1 == stepStart) {
                     stepStart = i + 1;
                  } else {
                     String stepStr = xpath.substring(stepStart, i);
                     XPathStep step = XPathStep.parse(stepStr, namespaceContext, defaultNamespace);
                     absolutePath.addStep(step);
                     stepStart = i + 1;
                  }
               }
            } else if (c == '"') {
               if (inDQuotes) {
                  inDQuotes = false;
               } else {
                  inDQuotes = true;
               }
            } else if (c == '\'') {
               if (inSQuotes) {
                  inSQuotes = false;
               } else {
                  inSQuotes = true;
               }
            }
         }

         if (stepStart != -1) {
            String stepStr = xpath.substring(stepStart);
            if (stepStr.length() != 0) {
               XPathStep step = XPathStep.parse(stepStr, namespaceContext, defaultNamespace);
               absolutePath.addStep(step);
            }
         }

         return absolutePath;
      }
   }
}
