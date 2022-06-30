package com.huawei.yang.common.api;

public class Attribute implements Cloneable {
   private QName name;
   private String value;

   public Attribute(QName name, String value) {
      this.name = name;
      this.value = value;
   }

   public QName getName() {
      return this.name;
   }

   public String getValue() {
      return this.value;
   }

   public void setValue(String value) {
      this.value = value;
   }

   public Attribute clone() throws CloneNotSupportedException {
      return (Attribute)super.clone();
   }
}
