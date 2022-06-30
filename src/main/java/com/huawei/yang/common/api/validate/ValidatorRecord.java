package com.huawei.yang.common.api.validate;

import com.huawei.yang.common.api.exception.ErrorMessage;
import com.huawei.yang.common.api.exception.ErrorTag;
import com.huawei.yang.common.api.exception.Severity;

public interface ValidatorRecord<P, E> {
   Severity getSeverity();

   ErrorTag getErrorTag();

   String getErrorAppTag();

   P getErrorPath();

   E getBadElement();

   ErrorMessage getErrorMsg();
}
