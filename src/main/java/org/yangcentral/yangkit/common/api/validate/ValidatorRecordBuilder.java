package org.yangcentral.yangkit.common.api.validate;

import org.yangcentral.yangkit.common.api.exception.ErrorMessage;
import org.yangcentral.yangkit.common.api.exception.ErrorTag;
import org.yangcentral.yangkit.common.api.exception.Severity;
import org.yangcentral.yangkit.common.impl.validate.ValidatorRecordImpl;

public class ValidatorRecordBuilder<P, E> {
   private ErrorTag errorTag;
   private String errorAppTag;
   private P errorPath;
   private E badElement;
   private ErrorMessage errorMessage;
   private Severity severity;

   public ValidatorRecordBuilder() {
      this.errorTag = ErrorTag.BAD_ELEMENT;
      this.severity = Severity.ERROR;
   }

   public void setSeverity(Severity severity) {
      this.severity = severity;
   }

   public void setErrorTag(ErrorTag errorTag) {
      this.errorTag = errorTag;
   }

   public void setErrorAppTag(String errorAppTag) {
      this.errorAppTag = errorAppTag;
   }

   public void setErrorPath(P errorPath) {
      this.errorPath = errorPath;
   }

   public void setBadElement(E badElement) {
      this.badElement = badElement;
   }

   public void setErrorMessage(ErrorMessage errorMessage) {
      this.errorMessage = errorMessage;
   }

   public ValidatorRecord<P, E> build() {
      return new ValidatorRecordImpl(this.severity, this.errorTag, this.errorAppTag, this.errorPath, this.badElement, this.errorMessage);
   }
}
