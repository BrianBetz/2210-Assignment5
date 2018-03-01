import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;


public class LinkedSetTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. 
   @Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   } **/
   
   @Test public void basicContainTest() {
      Set<Integer> set = new LinkedSet<Integer>();
      boolean expected = true;
      set.add(0);
      set.add(1);
      set.add(2);
      set.add(3);
      set.add(4);
      set.add(5);
      set.add(6);
      set.add(7);
      set.add(8);
      set.add(9);
      set.add(10);
      boolean actual = set.contains(4);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void basicContainTest2() {
      Set<Integer> set = new LinkedSet<Integer>();
      boolean expected = false;
      set.add(0);
      set.add(1);
      set.add(2);
      set.add(3);
      set.add(4);
      set.add(6);
      set.add(7);
      set.add(8);
      set.add(9);
      set.add(10);
      boolean actual = set.contains(5);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void basicContainTest3() {
      Set<Integer> set = new LinkedSet<Integer>();
      boolean expected = false;
      set.add(0);
      set.add(1);
      set.add(2);
      set.add(3);
      set.add(4);
      set.add(6);
      set.add(7);
      set.add(8);
      set.add(9);
      set.add(10);
      set.remove(4);
      set.remove(5);
      boolean actual = set.contains(5);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void basicAddTest() {
      Set<Integer> set = new LinkedSet<Integer>();
      int expected = 5;
      set.add(4);
      set.add(1);
      set.add(5);
      set.add(3);
      set.add(1);
      set.add(2);
      set.add(2);
      set.add(3);
      int actual = set.size();
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void basicAddTest1() {
      Set<Integer> set = new LinkedSet<Integer>();
      int expected = 6;
      set.add(2);
      set.add(1);
      set.add(3);
      set.add(6);
      set.add(4);
      set.add(5);
      
      int actual = set.size();
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void basiceAddTest4() {
      Set<Integer> set = new LinkedSet<Integer>();
      
      set.add(4);
      set.add(2);
      set.add(5);
      set.add(1);
      set.add(3);
      set.add(10);
      
      LinkedSet<Integer> clone = new LinkedSet<Integer>();
      Set<Integer> expected = new LinkedSet<Integer>();
      
      expected.add(1);
      expected.add(3);
      expected.add(4);
      expected.add(5);
      expected.add(10);
      
      
      Set<Integer> actual = new LinkedSet<Integer>();
      
      actual.add(1);
      actual.add(4);
      actual.add(3);
      actual.add(10);
      actual.add(5);
     
      Assert.assertTrue(expected.equals(actual));
   }
   
   @Test public void basicEqualsTestWithDifSize() {
      LinkedSet<Integer> set = new LinkedSet<Integer>();
      boolean expected = false;
      set.add(2);
      set.add(3);
      set.add(4);
      
      LinkedSet<Integer> set1 = new LinkedSet<Integer>();
      set1.add(1);
      set1.add(2);
      set1.add(3);
      set1.add(4);
      
      boolean actual = set1.equals(set);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void basicEqualsTestWithDifSize1() {
      LinkedSet<Integer> set = new LinkedSet<Integer>();
      boolean expected = true;
      set.add(2);
      set.add(3);
      set.add(4);
      
      LinkedSet<Integer> set1 = new LinkedSet<Integer>();
      set1.add(1);
      set1.add(2);
      set1.add(3);
      set1.add(4);
      set1.remove(1);
      
      boolean actual = set1.equals(set);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void basicRemoveTest() {
      Set<Integer> set = new LinkedSet<Integer>();
      int expected = 8;
      set.add(0);
      set.add(1);
      set.add(2);
      set.add(3);
      set.add(4);
      set.add(5);
      set.add(6);
      set.add(7);
      set.add(8);
      set.add(9);
      set.add(10);
      
      set.remove(5);
      set.remove(9);
      set.remove(4);
      
      int actual = set.size();
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void basicRemoveResizeTest() {
      Set<Integer> set = new LinkedSet<Integer>();
      int expected = 2;
      set.add(0);
      set.add(1);
      set.add(2);
      set.add(3);
      set.add(4);
      set.add(5);
      set.add(6);
      set.add(7);
      set.add(8);
      set.add(9);
      set.add(10);
      set.add(11);
      
      set.remove(0);
      set.remove(1);
      set.remove(2);
      set.remove(3);
      set.remove(4);
      set.remove(5);
      set.remove(6);
      set.remove(7);
      set.remove(8);
      set.remove(9);
      
      int actual = set.size();
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void basicUnionArraySetTest() {
      LinkedSet<Integer> arrSet = new LinkedSet<Integer>();
      LinkedSet<Integer> arrClone = new LinkedSet<Integer>();
      
      Set<Integer> expected = new LinkedSet<Integer>();
       
      arrSet.add(2);
      arrSet.add(1);
      arrSet.add(3);
      
      arrClone.add(6);
      arrClone.add(4);
      arrClone.add(5);
      
      expected.add(1);
      expected.add(2);
      expected.add(3);
      expected.add(4);
      expected.add(5);
      expected.add(6);
      
      Set<Integer> actual = arrClone.union(arrSet);
      String wattba = actual.toString();
      Assert.assertTrue(expected.equals(actual)); 
   }
   
   @Test public void basicRemoveTest1() {
      Set<Integer> set = new LinkedSet<Integer>();
      int expected = 8;
      set.add(10);
      set.add(1);
      set.add(4);
      set.add(3);
      set.add(2);
      set.add(6);
      set.add(5);
      set.add(8);
      set.add(7);
      set.add(9);
      set.add(0);
      
      set.remove(0);
      set.remove(9);
      set.remove(10);
      
      int actual = set.size();
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void basicEqualsTestWithSameSizeDifNums() {
      Set<Integer> arrSet = new LinkedSet<Integer>();
      boolean expected = false;
      arrSet.add(2);
      arrSet.add(3);
      arrSet.add(4);
      
      Set<Integer> set = new LinkedSet<Integer>();
      set.add(1);
      set.add(2);
      set.add(3);
      
      boolean actual = set.equals(arrSet);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void basicEqualsTestWithSameSizeDifNums2() {
      Set<Integer> arrSet = new LinkedSet<Integer>();
      boolean expected = false;
      arrSet.add(2);
      arrSet.add(3);
      arrSet.add(4);
      
      Set<Integer> set = new LinkedSet<Integer>();
      set.add(1);
      set.add(2);
      set.add(3);
      set.remove(1);
      set.remove(3);
      
      boolean actual = set.equals(arrSet);
      Assert.assertEquals(expected, actual);
   } 
   
   @Test public void basicEqualsTestWithSameSizeSameNum() {
      Set<Integer> arrSet = new LinkedSet<Integer>();
      boolean expected = true;
      arrSet.add(2);
      arrSet.add(3);
      arrSet.add(4);
      
      Set<Integer> set = new LinkedSet<Integer>();
      set.add(3);
      set.add(4);
      set.add(2);
      
      boolean actual = set.equals(arrSet);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void basicEqualsTestWithSameSizeDifNums3() {
      LinkedSet<Integer> arrSet = new LinkedSet<Integer>();
      boolean expected = true;
      arrSet.add(1);
      arrSet.add(2);
      arrSet.add(3);
      
      LinkedSet<Integer> set = new LinkedSet<Integer>();
      set.add(3);
      set.add(2);
      set.add(4);
      
      boolean actual = set.equals(arrSet);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void basicUnionSetTest() {
      Set<Integer> arrSet = new LinkedSet<Integer>();
      Set<Integer> arrClone = new LinkedSet<Integer>();
      
      Set<Integer> expected = new LinkedSet<Integer>();
       
      arrSet.add(2);
      arrSet.add(1);
      arrSet.add(3);
      
      arrClone.add(6);
      arrClone.add(4);
      arrClone.add(5);
       
      expected.add(1);
      expected.add(2);
      expected.add(3);
      expected.add(4);
      expected.add(5);
      expected.add(6);
       
      Set<Integer> actual = arrClone.union(arrSet);
      Assert.assertTrue(expected.equals(actual)); 
   }
   
   @Test public void basicIntersectonTest() {
      LinkedSet<Integer> arrSet = new LinkedSet<Integer>();
      LinkedSet<Integer> arrClone = new LinkedSet<Integer>();
      
      Set<Integer> expected = new LinkedSet<Integer>();
      
      arrSet.add(2);
      arrSet.add(1);
      arrSet.add(3);
      arrSet.add(4);
      arrSet.add(6);
      arrSet.add(5);
      
      arrClone.add(6);
      arrClone.add(4);
      arrClone.add(5);
      
      expected.add(4);
      expected.add(5);
      expected.add(6);
      
      Set<Integer> actual = arrSet.intersection(arrClone);
      String wattba = actual.toString();
      Assert.assertTrue(expected.equals(actual));
   }
   
   @Test public void descendingIteratorTest() {
      LinkedSet<Integer> set = new LinkedSet<Integer>();
      
      set.add(1);
      set.add(2);
      set.add(3);
      set.add(4);
      set.add(5);
      set.add(6);
      
      Iterator<Integer> wat = set.descendingIterator();
      Iterator<Integer> wattba = set.descendingIterator();
      
      while (wattba.hasNext()) {
         System.out.print(wattba.next());
      }
   }
   
   @Test public void PowerSetIteratorTest() {
      LinkedSet<String> set = new LinkedSet<String>();
      
      set.add("A");
      set.add("B");
      set.add("C");
      
      Iterator<Set<String>> wat = set.powerSetIterator();
      Iterator<Set<String>> wattba = set.powerSetIterator();
      
      while (wattba.hasNext()) {
         System.out.print(wattba.next());
      }
   } 
   
   @Test public void webCatContainsTest() {
      Set<Integer> set = new LinkedSet<Integer>();
      boolean expected = false;
      set.contains(4);
      set.add(4);
      set.contains(4);
      set.add(1);
      set.add(5);
      set.add(3);
      set.add(1);
      set.add(2);
      set.contains(3);
      set.remove(4);
      set.contains(4);
      set.remove(1);
      set.remove(5);
      boolean actual = set.contains(5);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void webCatRemoveTest() {
      Set<Integer> set = new LinkedSet<Integer>();
      int expected = 1;
      set.add(4);
      set.add(1);
      set.add(5);
      set.add(3);
      set.add(1);
      set.add(2);
      
      set.remove(4);
      set.remove(1);
      set.remove(5);
      set.remove(2);
      
      int actual = set.size();
      Assert.assertEquals(expected, actual);
   }
   
}
