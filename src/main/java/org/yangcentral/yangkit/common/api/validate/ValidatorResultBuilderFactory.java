package org.yangcentral.yangkit.common.api.validate;

import org.yangcentral.yangkit.common.api.Builder;
import org.yangcentral.yangkit.common.api.BuilderFactory;

public class ValidatorResultBuilderFactory implements BuilderFactory<ValidatorResult> {
   public Builder<ValidatorResult> getBuilder() {
      return new ValidatorResultBuilder();
   }
}
