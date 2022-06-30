package com.huawei.yang.common.api;

public class LinkNode {
   private ILinkData data;
   private LinkNode next;
   private LinkNode pre;

   public LinkNode() {
   }

   public LinkNode(ILinkData data) {
      this.data = data;
   }

   public ILinkData getData() {
      return this.data;
   }

   public void setData(ILinkData data) {
      this.data = data;
   }

   public LinkNode getNext() {
      return this.next;
   }

   public void setNext(LinkNode next) {
      this.next = next;
   }

   public LinkNode getPre() {
      return this.pre;
   }

   public void setPre(LinkNode pre) {
      this.pre = pre;
   }
}
