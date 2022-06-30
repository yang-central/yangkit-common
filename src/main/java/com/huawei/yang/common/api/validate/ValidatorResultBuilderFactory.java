package com.huawei.yang.common.api.validate;

import com.huawei.yang.common.api.Builder;
import com.huawei.yang.common.api.BuilderFactory;

public class ValidatorResultBuilderFactory implements BuilderFactory<ValidatorResult> {
   public Builder<ValidatorResult> getBuilder() {
      return new ValidatorResultBuilder();
   }
}
