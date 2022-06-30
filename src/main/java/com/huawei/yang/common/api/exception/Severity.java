package com.huawei.yang.common.api.exception;

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
}
