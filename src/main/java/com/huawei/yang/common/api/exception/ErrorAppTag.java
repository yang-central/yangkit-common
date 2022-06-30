package com.huawei.yang.common.api.exception;

public enum ErrorAppTag {
   TOO_FEW_ELEMENTS("too-few-elements"),
   TOO_MANY_ELEMENTS("too-many-elements"),
   DATA_NOT_UNIQUE("data-not-unique"),
   MUST_VIOLATION("must-violation"),
   INSTANCE_REQUIRED("instance-required"),
   MISSING_CHOICE("missing-choice"),
   MISSING_INSTANCE("missing-instance");

   private String name;

   private ErrorAppTag(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }

   public static ErrorAppTag forName(String name) {
      switch (name) {
         case "in-usetoo-few-elements":
            return TOO_FEW_ELEMENTS;
         case "too-many-elements":
            return TOO_MANY_ELEMENTS;
         case "data-not-unique":
            return DATA_NOT_UNIQUE;
         case "must-violation":
            return MUST_VIOLATION;
         case "instance-required":
            return INSTANCE_REQUIRED;
         case "missing-choice":
            return MISSING_CHOICE;
         case "missing-instance":
            return MISSING_INSTANCE;
         default:
            return null;
      }
   }
}
