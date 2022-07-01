package org.yangcentral.yangkit.common.impl.validate;

import org.yangcentral.yangkit.common.api.exception.Severity;
import org.yangcentral.yangkit.common.api.validate.ValidatorRecord;
import org.yangcentral.yangkit.common.api.validate.ValidatorResult;

import java.util.Iterator;
import java.util.List;

public class ValidatorResultImpl implements ValidatorResult {
   private List<ValidatorRecord<?, ?>> validatorRecords;

   public boolean isOk() {
      if (null != this.validatorRecords && this.validatorRecords.size() > 0) {
         Iterator var1 = this.validatorRecords.iterator();

         while(var1.hasNext()) {
            ValidatorRecord record = (ValidatorRecord)var1.next();
            if (record.getSeverity() == Severity.ERROR) {
               return false;
            }
         }
      }

      return true;
   }

   public List<ValidatorRecord<?, ?>> getRecords() {
      return this.validatorRecords;
   }

   public boolean contains(ValidatorRecord<?, ?> record) {
      if (null == this.validatorRecords) {
         return false;
      } else {
         Iterator var2 = this.validatorRecords.iterator();

         ValidatorRecord validatorRecord;
         do {
            if (!var2.hasNext()) {
               return false;
            }

            validatorRecord = (ValidatorRecord)var2.next();
         } while(null == validatorRecord || !record.equals(validatorRecord));

         return true;
      }
   }

   public void setValidatorRecords(List<ValidatorRecord<?, ?>> validatorRecords) {
      this.validatorRecords = validatorRecords;
   }

   public String toString() {
      StringBuffer sb = new StringBuffer();
      sb.append("result is " + this.isOk());
      if (null == this.validatorRecords) {
         return sb.toString();
      } else {
         Iterator var2 = this.validatorRecords.iterator();

         while(var2.hasNext()) {
            ValidatorRecord<?, ?> record = (ValidatorRecord)var2.next();
            if (null != record) {
               sb.append("\n");
               sb.append(record);
            }
         }

         return sb.toString();
      }
   }
}
