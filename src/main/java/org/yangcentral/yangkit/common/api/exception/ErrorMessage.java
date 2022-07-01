package org.yangcentral.yangkit.common.api.exception;

import java.util.Objects;

public class ErrorMessage {
   private String lang;
   private String message;

   public ErrorMessage(String message) {
      this.message = message;
      this.lang = null;
   }

   public ErrorMessage(String lang, String message) {
      this.lang = lang;
      this.message = message;
   }

   public String getLang() {
      return this.lang;
   }

   public String getMessage() {
      return this.message;
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (!(o instanceof ErrorMessage)) {
         return false;
      } else {
         ErrorMessage that = (ErrorMessage)o;
         return this.getMessage().equals(that.getMessage());
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.getMessage()});
   }
}
