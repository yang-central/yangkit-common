package org.yangcentral.yangkit.common.api.validate;

import org.yangcentral.yangkit.common.api.Builder;
import org.yangcentral.yangkit.common.impl.validate.ValidatorResultImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ValidatorResultBuilder implements Builder<ValidatorResult> {
   private List<ValidatorRecord<?, ?>> validatorRecords;

   public ValidatorResultBuilder() {
   }

   public ValidatorResultBuilder(ValidatorResult validatorResult) {
      this.validatorRecords = validatorResult.getRecords();
   }

   public void addRecord(ValidatorRecord<?, ?> record) {
      if (record != null) {
         if (this.validatorRecords == null) {
            this.validatorRecords = new ArrayList();
         }

         this.validatorRecords.add(record);
      }
   }

   public void merge(ValidatorResult validatorResult) {
      if (validatorResult != null) {
         List<ValidatorRecord<?, ?>> records = validatorResult.getRecords();
         if (records != null && records.size() > 0) {
            Iterator var3 = records.iterator();

            while(var3.hasNext()) {
               ValidatorRecord record = (ValidatorRecord)var3.next();
               if (record != null) {
                  this.addRecord(record);
               }
            }
         }

      }
   }

   public ValidatorResult build() {
      ValidatorResultImpl validatorResult = new ValidatorResultImpl();
      validatorResult.setValidatorRecords(this.validatorRecords);
      return validatorResult;
   }

   public void clear() {
      if (this.validatorRecords != null) {
         this.validatorRecords.clear();
      }

   }
}
