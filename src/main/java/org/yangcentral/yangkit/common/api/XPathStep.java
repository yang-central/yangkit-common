package org.yangcentral.yangkit.common.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.jaxen.NamespaceContext;

public class XPathStep {
   private QName step;
   private List<Predict> predicts;

   public XPathStep(QName step) {
      this.step = step;
   }

   public Predict getPredict(QName qName) {
      if (null == this.predicts) {
         return null;
      } else {
         Iterator var2 = this.predicts.iterator();

         Predict predict;
         do {
            if (!var2.hasNext()) {
               return null;
            }

            predict = (Predict)var2.next();
         } while(null == predict || !predict.getName().equals(qName));

         return predict;
      }
   }

   public void addPredict(Predict predict) {
      if (null == this.predicts) {
         this.predicts = new ArrayList();
      }

      this.predicts.add(predict);
   }

   public QName getStep() {
      return this.step;
   }

   public List<Predict> getPredicts() {
      return this.predicts;
   }

   public String toString() {
      StringBuilder sb = new StringBuilder();
      String qulifiedName = this.getStep().getQualifiedName();
      sb.append(qulifiedName);
      if (null != this.getPredicts()) {
         Iterator var3 = this.getPredicts().iterator();

         while(var3.hasNext()) {
            Predict predict = (Predict)var3.next();
            if (null != predict) {
               sb.append("[").append(predict.toString()).append("]");
            }
         }
      }

      return sb.toString();
   }

   public String toString(NamespaceContextDom4j namespaceContext) {
      StringBuilder sb = new StringBuilder();
      String qulifiedName = namespaceContext.translateNamespaceUriToPrefix(this.getStep().getNamespace().toASCIIString()) + ":" + this.getStep().getLocalName();
      sb.append(qulifiedName);
      if (null != this.getPredicts()) {
         Iterator var4 = this.getPredicts().iterator();

         while(var4.hasNext()) {
            Predict predict = (Predict)var4.next();
            if (null != predict) {
               sb.append("[").append(predict.toString(namespaceContext)).append("]");
            }
         }
      }

      return sb.toString();
   }

   private static List<String> parsePredicts(String predicts) {
      List<String> predictList = new ArrayList();
      int predictBegin = -1;
      int predictEnd = -1;
      boolean inDQuotes = false;
      boolean inSQuotes = false;
      int length = predicts.length();

      for(int i = 0; i < length; ++i) {
         char c = predicts.charAt(i);
         if (c == '[') {
            if (inDQuotes || inSQuotes) {
               continue;
            }

            predictBegin = i + 1;
         }

         if (c == ']') {
            if (inDQuotes || inSQuotes) {
               continue;
            }

            String predict = predicts.substring(predictBegin, i);
            predictList.add(predict);
         }

         if (c == '"') {
            if (inDQuotes) {
               inDQuotes = false;
            } else {
               inDQuotes = true;
            }
         }

         if (c == '\'') {
            if (inSQuotes) {
               inSQuotes = false;
            } else {
               inSQuotes = true;
            }
         }
      }

      return predictList;
   }

   public static XPathStep parse(String step, NamespaceContext namespaceContext, URI defaultNamespace) {
      XPathStep xPathStep = null;
      String name = null;
      String predicts = null;
      if (step.contains("[")) {
         int predictStart = step.indexOf("[");
         name = step.substring(0, predictStart);
         predicts = step.substring(predictStart);
      } else {
         name = step;
      }

      String predictStr;
      if (name.contains(":")) {
         String[] args = name.split(":");
         String prefix = args[0];
         predictStr = args[1];
         String namespaceUri = namespaceContext.translateNamespacePrefixToUri(prefix);
         if (null == namespaceUri) {
            throw new IllegalArgumentException("can not find prefix:" + prefix + "'s namespace");
         }

         QName stepQName = new QName(namespaceUri, prefix, predictStr);
         xPathStep = new XPathStep(stepQName);
      } else {
         xPathStep = new XPathStep(new QName(defaultNamespace, name));
      }

      if (null != predicts) {
         List<String> predictList = parsePredicts(predicts);
         Iterator var13 = predictList.iterator();

         while(var13.hasNext()) {
            predictStr = (String)var13.next();
            Predict predict = Predict.parse(predictStr, namespaceContext, xPathStep.getStep().getNamespace());
            xPathStep.addPredict(predict);
         }
      }

      return xPathStep;
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (!(o instanceof XPathStep)) {
         return false;
      } else {
         XPathStep step1 = (XPathStep)o;
         if (!this.getStep().equals(step1.getStep())) {
            return false;
         } else if (null != this.getPredicts()) {
            if (step1.getPredicts() == null) {
               return false;
            } else {
               int thisSize = this.getPredicts().size();
               int oSize = step1.getPredicts().size();
               if (thisSize != oSize) {
                  return false;
               } else {
                  for(int i = 0; i < thisSize; ++i) {
                     Predict thisPredict = (Predict)this.getPredicts().get(i);
                     Predict oPredict = (Predict)step1.getPredicts().get(i);
                     if (!thisPredict.equals(oPredict)) {
                        return false;
                     }
                  }

                  return true;
               }
            }
         } else {
            return null == step1.getPredicts();
         }
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.getStep(), this.getPredicts()});
   }
}
