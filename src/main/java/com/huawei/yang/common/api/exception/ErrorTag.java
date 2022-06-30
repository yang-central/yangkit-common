package com.huawei.yang.common.api.exception;

public enum ErrorTag {
   IN_USE("in-use"),
   INVALID_VALUE("invalid-value"),
   TOO_BIG("too-big"),
   MISSING_ATTRIBUTE("missing-attribute"),
   BAD_ATTRIBUTE("bad-attribute"),
   UNKNOWN_ATTRIBUTE("unknown-attribute"),
   MISSING_ELEMENT("missing-element"),
   BAD_ELEMENT("bad-element"),
   UNKNOWN_ELEMENT("unknown-element"),
   UNKNOWN_NAMESPACE("unknown-namespace"),
   ACCESS_DENIED("access-denied"),
   LOCK_DENIED("lock-denied"),
   RESOURCE_DENIED("resource-denied"),
   ROLLBACK_FAILED("rollback-failed"),
   DATA_EXISTS("data-exists"),
   DATA_MISSING("data-missing"),
   OPERATION_NOT_SUPPORT("operation-not-supported"),
   OPERATION_FAILED("operation-failed"),
   PARTIAL_OPERATION("partial-operation"),
   MALFORMED_MESSAGE("malformed-message");

   private String name;

   private ErrorTag(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }

   public static ErrorTag forName(String name) {
      switch (name) {
         case "in-use":
            return IN_USE;
         case "invalid-value":
            return INVALID_VALUE;
         case "too-big":
            return TOO_BIG;
         case "missing-attribute":
            return MISSING_ATTRIBUTE;
         case "bad-attribute":
            return BAD_ATTRIBUTE;
         case "unknown-attribute":
            return UNKNOWN_ATTRIBUTE;
         case "missing-element":
            return MISSING_ELEMENT;
         case "bad-element":
            return BAD_ELEMENT;
         case "unknown-element":
            return UNKNOWN_ELEMENT;
         case "unknown-namespace":
            return UNKNOWN_NAMESPACE;
         case "access-denied":
            return ACCESS_DENIED;
         case "lock-denied":
            return LOCK_DENIED;
         case "resource-denied":
            return RESOURCE_DENIED;
         case "rollback-failed":
            return ROLLBACK_FAILED;
         case "data-exists":
            return DATA_EXISTS;
         case "data-missing":
            return DATA_MISSING;
         case "operation-not-supported":
            return OPERATION_NOT_SUPPORT;
         case "operation-failed":
            return OPERATION_FAILED;
         case "partial-operation":
            return PARTIAL_OPERATION;
         case "malformed-message":
            return MALFORMED_MESSAGE;
         default:
            return null;
      }
   }
}
