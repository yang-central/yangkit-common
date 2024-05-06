package org.yangcentral.yangkit.common.api.validate;

import org.yangcentral.yangkit.common.api.exception.Severity;

import java.util.List;

public interface ValidatorResult {
   boolean isOk();

   List<ValidatorRecord<?, ?>> getRecords();

   boolean contains(ValidatorRecord<?, ?> record);

   void sort();

   String print(Severity severity);
}
