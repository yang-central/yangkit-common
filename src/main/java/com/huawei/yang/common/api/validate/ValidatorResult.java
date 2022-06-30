package com.huawei.yang.common.api.validate;

import java.util.List;

public interface ValidatorResult {
   boolean isOk();

   List<ValidatorRecord<?, ?>> getRecords();

   boolean contains(ValidatorRecord<?, ?> var1);
}
