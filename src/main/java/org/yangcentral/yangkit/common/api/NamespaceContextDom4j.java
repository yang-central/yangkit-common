package org.yangcentral.yangkit.common.api;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.jaxen.NamespaceContext;

public class NamespaceContextDom4j implements NamespaceContext {
   private Map<String, String> nsPrefixPairs;

   public String translateNamespacePrefixToUri(String s) {
      return null == this.nsPrefixPairs ? null : (String)this.nsPrefixPairs.get(s);
   }

   public boolean addPrefixNSPair(String prefix, String namespace) {
      if (null == this.nsPrefixPairs) {
         this.nsPrefixPairs = new HashMap();
      }

      if (null != this.nsPrefixPairs.get(prefix)) {
         return false;
      } else {
         this.nsPrefixPairs.put(prefix, namespace);
         return true;
      }
   }

   public void removePrefixNSPair(String prefix) {
      if (null != this.nsPrefixPairs) {
         if (null != this.nsPrefixPairs.get(prefix)) {
            this.nsPrefixPairs.remove(prefix);
         }
      }
   }

   public String translateNamespaceUriToPrefix(String uri) {
      if (null == this.nsPrefixPairs) {
         return null;
      } else {
         Iterator<Map.Entry<String, String>> map = this.nsPrefixPairs.entrySet().iterator();

         Map.Entry entry;
         do {
            if (!map.hasNext()) {
               return null;
            }

            entry = (Map.Entry)map.next();
         } while(!((String)entry.getValue()).equals(uri));

         return (String)entry.getKey();
      }
   }

   public Map<String, String> getNsPrefixPairs() {
      return this.nsPrefixPairs;
   }

   public void merge(NamespaceContextDom4j other) {
      if (null != other) {
         if (other.nsPrefixPairs != null) {
            Set<String> keys = other.nsPrefixPairs.keySet();
            Iterator var3 = keys.iterator();

            while(true) {
               String key;
               do {
                  do {
                     if (!var3.hasNext()) {
                        return;
                     }

                     key = (String)var3.next();
                  } while(null == key);
               } while(null != this.nsPrefixPairs && null != this.nsPrefixPairs.get(key));

               this.addPrefixNSPair(key, other.translateNamespacePrefixToUri(key));
            }
         }
      }
   }
}
