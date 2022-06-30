package com.huawei.yang.common.api;

public class FName {
   private String prefix;
   private String localName;

   public FName(String fName) {
      if (null != fName) {
         if (!fName.contains(":")) {
            this.localName = fName;
         } else {
            String[] strs = fName.split(":");
            if (2 == strs.length) {
               this.prefix = strs[0];
               this.localName = strs[1];
            }
         }
      }
   }

   public String getPrefix() {
      return this.prefix;
   }

   public String getLocalName() {
      return this.localName;
   }
}
