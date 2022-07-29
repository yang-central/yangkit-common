package org.yangcentral.yangkit.common.impl.validate;

import org.yangcentral.yangkit.common.api.Link;
import org.yangcentral.yangkit.common.api.exception.Severity;
import org.yangcentral.yangkit.common.api.validate.ValidatorRecord;
import org.yangcentral.yangkit.common.api.validate.ValidatorResult;

import java.util.Iterator;
import java.util.List;

public class ValidatorResultImpl implements ValidatorResult {
   private List<ValidatorRecord<?, ?>> validatorRecords;

   public boolean isOk() {
      if (null != this.validatorRecords && this.validatorRecords.size() > 0) {
         Iterator recordIterator = this.validatorRecords.iterator();

         while(recordIterator.hasNext()) {
            ValidatorRecord record = (ValidatorRecord)recordIterator.next();
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
         Iterator recordIterator = this.validatorRecords.iterator();

         ValidatorRecord validatorRecord;
         do {
            if (!recordIterator.hasNext()) {
               return false;
            }

            validatorRecord = (ValidatorRecord)recordIterator.next();
         } while(null == validatorRecord || !record.equals(validatorRecord));

         return true;
      }
   }

   @Override
   public void sort() {
      Link<ValidatorRecord<?,?>> link = new Link<ValidatorRecord<?,?>>(Link.SortOrder.ASCEND);
      for(ValidatorRecord record:validatorRecords){
         link.insert(record);
      }
      int length = link.size();
      validatorRecords.clear();
      for(int i = 0; i<length;i++){
         validatorRecords.add(link.get(i));
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
         Iterator recordIterator = this.validatorRecords.iterator();

         while(recordIterator.hasNext()) {
            ValidatorRecord<?, ?> record = (ValidatorRecord)recordIterator.next();
            if (null != record) {
               sb.append("\n");
               sb.append(record);
            }
         }

         return sb.toString();
      }
   }
}
