package org.yangcentral.yangkit.common.api.exception;

public enum Severity {
   ERROR("Error"),
   WARNING("Warning"),
   INFO("Info"),
   DEBUG("Debug");

   private String fieldName;

   private Severity(String name) {
      this.fieldName = name;
   }

   public String getFieldName() {
      return this.fieldName;
   }

   public int compare(Severity other) {
      if(this == other){
         return 0;
      }
      switch (this) {
         case ERROR: {
            return 1;
         }
         case WARNING:{
            if(other == ERROR){
               return -1;
            }
            return 1;
         }
         case INFO: {
            if(other == DEBUG){
               return 1;
            }
            return -1;
         }
         case DEBUG: {
            return -1;
         }
      }
      return 0;
   }
}
