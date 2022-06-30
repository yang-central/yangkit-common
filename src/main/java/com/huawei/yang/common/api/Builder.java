package com.huawei.yang.common.api;

public interface Builder<T> {
   void merge(T var1);

   T build();

   void clear();
}
