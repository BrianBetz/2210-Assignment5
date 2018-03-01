import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Provides an implementation of the Set interface.
 * A doubly-linked list is used as the underlying data structure.
 * Although not required by the interface, this linked list is
 * maintained in ascending natural order. In those methods that
 * take a LinkedSet as a parameter, this order is used to increase
 * efficiency.
 *
 * @author Brian Betz (betzbri@auburn.edu
 * @version 2016-03-13
 *
 */
public class LinkedSet<T extends Comparable<? super T>> implements Set<T> {

   //////////////////////////////////////////////////////////
   // Do not change the following three fields in any way. //
   //////////////////////////////////////////////////////////

   /** References to the first and last node of the list. */
   Node front;
   Node rear;

   /** The number of nodes in the list. */
   int size;

   /////////////////////////////////////////////////////////
   // Do not change the following constructor in any way. //
   /////////////////////////////////////////////////////////

   /**
    * Instantiates an empty LinkedSet.
    */
   public LinkedSet() {
      front = null;
      rear = null;
      size = 0;
   }


   //////////////////////////////////////////////////
   // Public interface and class-specific methods. //
   //////////////////////////////////////////////////

   ///////////////////////////////////////
   // DO NOT CHANGE THE TOSTRING METHOD //
   ///////////////////////////////////////
   /**
    * Return a string representation of this LinkedSet.
    *
    * @return a string representation of this LinkedSet
    */
   @Override
   public String toString() {
      if (isEmpty()) {
         return "[]";
      }
      StringBuilder result = new StringBuilder();
      result.append("[");
      for (T element : this) {
         result.append(element + ", ");
      }
      result.delete(result.length() - 2, result.length());
      result.append("]");
      return result.toString();
   }


   ///////////////////////////////////
   // DO NOT CHANGE THE SIZE METHOD //
   ///////////////////////////////////
   /**
    * Returns the current size of this collection.
    *
    * @return  the number of elements in this collection.
    */
   public int size() {
      return size;
   }

   //////////////////////////////////////
   // DO NOT CHANGE THE ISEMPTY METHOD //
   //////////////////////////////////////
   /**
    * Tests to see if this collection is empty.
    *
    * @return  true if this collection contains no elements, false otherwise.
    */
   public boolean isEmpty() {
      return (size == 0);
   }


   /**
    * Ensures the collection contains the specified element. Neither duplicate
    * nor null values are allowed. This method ensures that the elements in the
    * linked list are maintained in ascending natural order.
    *
    * @param  element  The element whose presence is to be ensured.
    * @return true if collection is changed, false otherwise.
    */
   public boolean add(T element) {
   
      if (element == null || contains(element)) {
         return false;
      }
      
      Node node = new Node(element);
      
      if (size == 0) {
         front = node;
         rear = front;
         front.prev = null;
         size++;
         return true;
      }
      
      else if (element.compareTo(rear.element) > 0) {
         Node n = rear;
         rear.next = node;
         rear = node;
         rear.prev = n;
         size++;
         return true;
      }
      
      else if (element.compareTo(front.element) < 0) {
         node.next = front;
         front.prev = node;
         front = node;
         size++;
         return true;
      } 
      
      else {
         Node n = front;
      
         while (element.compareTo(n.element) > 0) {
            n = n.next;
         }
      
         n.prev.next = node;
         node.next = n;
         node.prev = n.prev;
         n.prev = node;
         size++;
         return true;  
      }
   }

   /**
    * Ensures the collection does not contain the specified element.
    * If the specified element is present, this method removes it
    * from the collection. This method, consistent with add, ensures
    * that the elements in the linked lists are maintained in ascending
    * natural order.
    *
    * @param   element  The element to be removed.
    * @return  true if collection is changed, false otherwise.
    */
   public boolean remove(T element) {
      Node node = new Node(element);
      Node node1 = front;
      
      if (node.element.compareTo(front.element) == 0) {
         Node n = front;
         n.next.prev = node.next;
         front = front.next;
         size--;
         return true;
      }
      
      if (node.element.compareTo(rear.element) == 0) {
         Node n = rear;
         n.prev.next = node.prev;
         rear = rear.prev;
         size--;
         return true;
      }
   
      if (contains(element)) {
         while (node.element.compareTo(node1.element) != 0) {
            node1 = node1.next;
         }
      
         node.prev = node1.prev;
         node1.prev.next = node1.next;
         node1.next.prev = node1.prev;
         size--;
         return true;
      }
      
      return false;
   }


   /**
    * Searches for specified element in this collection.
    *
    * @param   element  The element whose presence in this collection is to be tested.
    * @return  true if this collection contains the specified element, false otherwise.
    */
   public boolean contains(T element) {
   
      if (isEmpty()) {
         return false;
      }
      
      Node temp = front;
   
      while (temp != null) {
         if (temp.element.compareTo(element) == 0) {
            return true;
         }
         
         temp = temp.next;
      }
        
      return false;
   }


   /**
    * Tests for equality between this set and the parameter set.
    * Returns true if this set contains exactly the same elements
    * as the parameter set, regardless of order.
    *
    * @return  true if this set contains exactly the same elements as
    *               the parameter set, false otherwise
    */
   public boolean equals(Set<T> s) {
      if (s.size() != this.size) {
         return false;
      }
      
      Node node = front;
      
      while (node != null) {
         if (s.contains(node.element)) {
            return true;
         }
         
         node = node.next;
         return false;
      }
      
      return false;
   }


   /**
    * Tests for equality between this set and the parameter set.
    * Returns true if this set contains exactly the same elements
    * as the parameter set, regardless of order.
    *
    * @return  true if this set contains exactly the same elements as
    *               the parameter set, false otherwise
    */
   public boolean equals(LinkedSet<T> s) {
      boolean result = false;
   
      if (s.size() != this.size) {
         return result;
      }
      
      Node node = front;
      
      while (node != null) {
         if (s.contains(node.element)) {
            return true;
         }
         node = node.next;
         return false;
      }
      
      return false;
   }


   /**
    * Returns a set that is the union of this set and the parameter set.
    *
    * @return  a set that contains all the elements of this set and the parameter set
    */
    
   public Set<T> union(Set<T> s){
   
      Node node = front;
      LinkedSet<T> uSet = new LinkedSet<T>();
      while (node != null) {
         uSet.add(node.element);
         node = node.next;
      }
      
      if (s.isEmpty()) {
         return uSet;
      }
      
      for (T val : s) { 
         uSet.add(val);  
      }
      
      return uSet;
   }

   /**
    * Returns a set that is the union of this set and the parameter set.
    *
    * @return  a set that contains all the elements of this set and the parameter set
    */ 
    
   public Set<T> union(LinkedSet<T> s){
   
      LinkedSet<T> uSet = new LinkedSet<T>();
      Node node = front;
      Node node1 = s.front;
      Node n1 = new Node(node1.element);
   
      if (uSet.size == 0 && (!isEmpty())) {
         uSet.front = node;
         uSet.rear = rear;
         uSet.front.prev = null;
         uSet.size += uSet.size + size;
      }
   
      while (n1 != null) {
         if (uSet.size == 0) {
            uSet.front = node1;
            uSet.rear = uSet.front;
            uSet.front.prev = null;
            n1 = new Node(node1.next.element);
            uSet.size = uSet.size + 1;
         }
         
         else if (n1.element.compareTo(uSet.rear.element) > 0) {
            Node n = s.rear;
            uSet.rear.next = node1;
            uSet.rear = node1;
            uSet.rear.prev = n;
            n1 = new Node(node1.next.element);
            uSet.size = uSet.size + 1;
         }
         
         else if (n1.element.compareTo(uSet.front.element) < 0) {
            n1.next = node;
            node.prev = n1;
            uSet.front = n1;
            n1 = node1.next;
            n1 = new Node(node1.next.element);
            uSet.size = uSet.size + 1;
         } 
         
         else {
         
            while (n1.element.compareTo(node.element) > 0) {
               node = node.next;
            }
         
            node.prev.next = n1;
            n1.next = node;
            n1.prev = node.prev;
            node.prev = n1;
            n1 = new Node(node1.next.element);
            uSet.size = uSet.size + 1;  
         }
      }
      
      
      if (s.isEmpty()) {
         return uSet;
      }  
      
      return uSet;
   }


   /**
    * Returns a set that is the intersection of this set and the parameter set.
    *
    * @return  a set that contains elements that are in both this set and the parameter set
    */
    
    
   public Set<T> intersection(Set<T> s) {
      LinkedSet<T> uSet = new LinkedSet<T>();
      Node node = front;
      if (!this.isEmpty())
         while (node != null) {
            if (s.contains(node.element)) {
               uSet.add(node.element);
            }
            
            node = node.next;
         }
         
      return uSet;
   }

   /**
    * Returns a set that is the intersection of this set and
    * the parameter set.
    *
    * @return  a set that contains elements that are in both
    *            this set and the parameter set
    */
    
   public Set<T> intersection(LinkedSet<T> s) {
      LinkedSet<T> uSet = new LinkedSet<T>();
      Node node = front;
      if (!this.isEmpty())
         while (node != null) {
            if (s.contains(node.element)) {
               uSet.add(node.element);
            }
            
            node = node.next;
         }
         
      return uSet;
   }

   /**
    * Returns a set that is the complement of this set and the parameter set.
    *
    * @return  a set that contains elements that are in this set but not the parameter set
    */
    
   public Set<T> complement(Set<T> s) {
      if (s == null || s.isEmpty()) {
         return this;
      }
      
      if (this == null || isEmpty()) {
         return this;
      }
      
      LinkedSet<T> cSet = new LinkedSet<T>();
      Node node = front;
      
      while (node != null) {
         if (!s.contains(node.element)) {
            cSet.add(node.element);
         }
         
         node = node.next;
      }
      
      return cSet;
   }

   /**
    * Returns a set that is the complement of this set and
    * the parameter set.
    *
    * @return  a set that contains elements that are in this
    *            set but not the parameter set
    */
    
   public Set<T> complement(LinkedSet<T> s) {
      if (s == null || s.isEmpty()) {
         return this;
      }
      
      if (this == null || isEmpty()) {
         return this;
      }
      
      LinkedSet<T> cSet = new LinkedSet<T>();
      Node node = front;
      
      while (node != null) {
         if (!s.contains(node.element)) {
            cSet.add(node.element);
         }
         
         node = node.next;
      }
      
      return cSet;
   }

   /**
    * Returns an iterator over the elements in this LinkedSet.
    * Elements are returned in ascending natural order.
    *
    * @return  an iterator over the elements in this LinkedSet
    */
    
   public Iterator<T> iterator() {
      return new LinkedSetIterator();
   }

   /**
    * Returns an iterator over the elements in this LinkedSet.
    * Elements are returned in descending natural order.
    *
    * @return  an iterator over the elements in this LinkedSet
    */
    
   public Iterator<T> descendingIterator() {
      return new DescIterator();
   }

   /**
    * Returns an iterator over the members of the power set
    * of this LinkedSet. No specific order can be assumed.
    *
    * @return  an iterator over members of the power set
    */
    
   public Iterator<Set<T>> powerSetIterator() {
      return new PowerSetIterator();
   }

   //////////////////////////////
   // Private utility methods. //
   //////////////////////////////

   // Feel free to add as many private methods as you need.

   ////////////////////
   // Nested classes //
   ////////////////////

   private class LinkedSetIterator implements Iterator<T> {
      private Node current;
   
      public LinkedSetIterator() {
         current = front;
      }
      
      @Override
      public boolean hasNext() {
         return (current != null); 
      }
      
      @Override
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         else {
            T item = current.element;
            current = current.next;
            return item;
         }
      }
      
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
   
   private class DescIterator implements Iterator<T> {
      private Node current;
   
      public DescIterator() {
         current = rear;
      }
      
      @Override
      public boolean hasNext() {
         return current != null; 
      }
      
      @Override
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         else {
            T item = current.element;
            current = current.prev;
            return item;
         }
      }
      
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
   
   private class PowerSetIterator implements Iterator<Set<T>> {
      private int count;
      private int current;
      private int bit;
   
      public PowerSetIterator() {
         count = size;
         current = 0;
         bit = 0;
      }
   
      public boolean hasNext() {
         return (current < (int) Math.pow(2, size));
      }
   
      public Set<T> next() {
         Set<T> pSet = new LinkedSet<T>();
         int mask = 1;
         Node node = front;
         for (int i = 0; i < size; i++) {
            if ((bit & mask) != 0) {
               pSet.add(node.element);
            }
         }
         current++;
         bit = 0;
         return pSet;
      }
   
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }

   //////////////////////////////////////////////
   // DO NOT CHANGE THE NODE CLASS IN ANY WAY. //
   //////////////////////////////////////////////

   /**
    * Defines a node class for a doubly-linked list.
    */
   class Node {
      /** the value stored in this node. */
      T element;
      /** a reference to the node after this node. */
      Node next;
      /** a reference to the node before this node. */
      Node prev;
   
      /**
       * Instantiate an empty node.
       */
      public Node() {
         element = null;
         next = null;
         prev = null;
      }
   
      /**
       * Instantiate a node that containts element
       * and with no node before or after it.
       */
      public Node(T e) {
         element = e;
         next = null;
         prev = null;
      }
   }
 
}
