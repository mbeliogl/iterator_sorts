
package com.maxim;

/* Contains several methods for sorting lists using iterators */

public class Sorts {
   /**
    * Performs the Selection Sort algorithm on the list that created the given iterator
    * @param begin an iterator positioned just before the first element
    */
   public static void selectionSort(SimpleListIterator begin) {

       SimpleListIterator clone3;
       SimpleListIterator clone1 = begin.clone();

       // setting smallest value to be the first and making a second(third) clone
       while(clone1.hasNext()) {
	       int currSmallest = clone1.next();
	       int first = currSmallest;
	       clone3 = clone1.clone();
	       SimpleListIterator clone2 = clone1.clone();
	       
	       // clone two is the one that moves around 
	       while(clone2.hasNext()) {
		      int nextItem = clone2.next(); 

		      // comparing the values and updating smallest
		      if(nextItem < currSmallest) {
			      clone3 = clone2.clone();
			      currSmallest = nextItem;
			  }
		   }
	       // swap the values
	       clone1.set(currSmallest);
	       clone3.set(first);
	   }
   }

   /**
    * Performs the Insertion Sort algorithm on the list that created the given iterator
    * @param begin an iterator positioned just before the first element
    */
   public static void insertionSort(SimpleListIterator begin)
   {
       SimpleListIterator clone3;
       SimpleListIterator clone1 = begin.clone();

       clone1.next();

       while(clone1.hasNext()) {
	       int currValue = clone1.next();

	       // iterator for the previous value
	       SimpleListIterator prev = clone1.clone();
	       int previousVal = prev.previous();

	       // helps stop the execution when previous is at the first position in the list
	       boolean hasPrev = true;

	       // swap values and continue execution until hasPrev is false
	       while(hasPrev && currValue < previousVal) {
		       prev.set(currValue);
		       clone3 = prev.clone();
		       clone3.next();
		       clone3.set(previousVal);

		       if(prev.hasPrevious()) {
			       previousVal = prev.previous();
			   }
		       else
			   hasPrev = false;
		   }
	   }
   }


   /** Takes in a list of integers separated by space (' ') and performs both sorts
	* Both Selection Sort and Insertion Sort are performed on an Array-Backed list and then on a Linked List
	* Prints results to command line
    */
   public static void main(String[] args) {
   		SimpleListIterator begin;
      	String[] sortLabels = {"----- Selection Sort -----", "----- Insertion Sort -----"};
      	String[] listLabels = {"Array-Backed List:", "Linked List:"};
      
      for(int i = 0; i < 2; i++) {
      	System.out.println(sortLabels[i] + "\n");

      	for(int j = 0; j < 2; j++) {
	 		System.out.println(listLabels[j]);
	 		SimpleList list;
	    	if(j == 0)
	       		list = new SimpleArrayList();
	    	else
	       		list = new SimpleLinkedList();

			for (String arg : args) {
				list.add(Integer.parseInt(arg));
			}

	    	System.out.println("Before: " + list);
	    	if(i == 0)
	       		selectionSort(list.begin());

	    	else insertionSort(list.begin());
	    	System.out.println("After: " + list + "\n");
	 	}
      }
   }
}
