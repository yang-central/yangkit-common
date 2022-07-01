package org.yangcentral.yangkit.common.api;

public interface Builder<T> {
   void merge(T var1);

   T build();

   void clear();
}
