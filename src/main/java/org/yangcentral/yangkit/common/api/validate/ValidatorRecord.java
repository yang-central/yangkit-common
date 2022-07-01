package org.yangcentral.yangkit.common.api.validate;

import org.yangcentral.yangkit.common.api.exception.ErrorMessage;
import org.yangcentral.yangkit.common.api.exception.ErrorTag;
import org.yangcentral.yangkit.common.api.exception.Severity;

public interface ValidatorRecord<P, E> {
   Severity getSeverity();

   ErrorTag getErrorTag();

   String getErrorAppTag();

   P getErrorPath();

   E getBadElement();

   ErrorMessage getErrorMsg();
}
