package org.yangcentral.yangkit.common.impl.validate;

import org.yangcentral.yangkit.common.api.exception.ErrorMessage;
import org.yangcentral.yangkit.common.api.exception.ErrorTag;
import org.yangcentral.yangkit.common.api.exception.Severity;
import org.yangcentral.yangkit.common.api.validate.ValidatorRecord;

import java.util.Objects;

public class ValidatorRecordImpl<P, E> implements ValidatorRecord<P, E> {
   private ErrorTag errorTag;
   private Severity severity;
   private String errorAppTag;
   private P errorPath;
   private E badElement;
   private ErrorMessage errorMessage;

   public ValidatorRecordImpl(ErrorTag errorTag, String errorAppTag, P errorPath, E badElement, ErrorMessage errorMessage) {
      this.errorTag = ErrorTag.BAD_ELEMENT;
      this.severity = Severity.ERROR;
      this.errorTag = errorTag;
      this.errorAppTag = errorAppTag;
      this.errorPath = errorPath;
      this.badElement = badElement;
      this.errorMessage = errorMessage;
   }

   public ValidatorRecordImpl(Severity severity, ErrorTag errorTag, String errorAppTag, P errorPath, E badElement, ErrorMessage errorMessage) {
      this.errorTag = ErrorTag.BAD_ELEMENT;
      this.severity = Severity.ERROR;
      this.severity = severity;
      this.errorTag = errorTag;
      this.errorAppTag = errorAppTag;
      this.errorPath = errorPath;
      this.badElement = badElement;
      this.errorMessage = errorMessage;
   }

   public Severity getSeverity() {
      return this.severity;
   }

   public ErrorTag getErrorTag() {
      return this.errorTag;
   }

   public String getErrorAppTag() {
      return this.errorAppTag;
   }

   public P getErrorPath() {
      return this.errorPath;
   }

   public E getBadElement() {
      return this.badElement;
   }

   public ErrorMessage getErrorMsg() {
      return this.errorMessage;
   }

   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("errorTag='").append(this.errorTag.getName()).append("'");
      if (null != this.errorAppTag) {
         sb.append(", errorAppTag='").append(this.errorAppTag).append("'");
      }

      sb.append(", severity=").append(this.severity.getFieldName());
      if (null != this.errorPath) {
         sb.append(", errorPath=").append(this.errorPath.toString());
      }

      if (null != this.badElement) {
         sb.append(", badElement=").append(this.badElement.toString());
      }

      if (null != this.errorMessage) {
         sb.append(", errorMessage=").append(this.errorMessage.getMessage());
      }

      return sb.toString();
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (!(o instanceof ValidatorRecord)) {
         return false;
      } else {
         ValidatorRecord<?, ?> that = (ValidatorRecord)o;
         return this.getErrorTag() == that.getErrorTag() && Objects.equals(this.getErrorAppTag(), that.getErrorAppTag()) && this.getErrorPath().equals(that.getErrorPath()) && this.errorMessage.equals(that.getErrorMsg());
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.getErrorTag(), this.getErrorAppTag(), this.getErrorPath(), this.getBadElement(), this.errorMessage});
   }
}
