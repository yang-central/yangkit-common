package org.yangcentral.yangkit.common.api;

public class LinkNode<E extends Comparable> {
   private E data;
   private LinkNode<E> next;
   private LinkNode<E> pre;

   public LinkNode() {
   }

   public LinkNode(E data) {
      this.data = data;
   }

   public E getData() {
      return this.data;
   }

   public void setData(E data) {
      this.data = data;
   }

   public LinkNode<E> getNext() {
      return this.next;
   }

   public void setNext(LinkNode<E> next) {
      this.next = next;
   }

   public LinkNode<E> getPre() {
      return this.pre;
   }

   public void setPre(LinkNode<E> pre) {
      this.pre = pre;
   }
}
