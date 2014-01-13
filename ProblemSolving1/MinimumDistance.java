package ProblemSolving1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;

public class MinimumDistance {


    public int minimumDistance (List<Integer> a, List<Integer> b, List<Integer> c) {
        int minimumDistance = Integer.MAX_VALUE;
        int distance = Integer.MAX_VALUE;
        Collections.sort(a);
        Collections.sort(b);
        Collections.sort(c);
               
        Iterator<Integer> IteratorA = a.iterator();
        Iterator<Integer> IteratorB = b.iterator();
        Iterator<Integer> IteratorC = c.iterator();
        
        int itemA = 0;
        int itemB = 0;
        int itemC = 0;
        
        if (IteratorA.hasNext()) {
            itemA = IteratorA.next();
        }

        if (IteratorB.hasNext()) {
            itemB = IteratorB.next();
        }

        if (IteratorC.hasNext()) {
            itemC = IteratorC.next();
        }
          
        while (IteratorA.hasNext() && IteratorB.hasNext() && IteratorC.hasNext()) {
        distance = Math.max(Math.max(Math.abs(itemA-itemC), Math.abs(itemA-itemB)),Math.abs(itemB-itemC));
        System.out.println(distance);
        System.out.println(itemA + ","+ itemB + "," + itemC);
        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
                    if (distance < minimumDistance) {
                        minimumDistance = distance;
                    }
                        if (itemA == itemB) {
                            if(IteratorA.hasNext()) {
                                itemA = IteratorA.next();
                            } else return minimumDistance;
                        } else if (itemA == itemC) {
                            if(IteratorA.hasNext()) {
                                itemA = IteratorA.next();
                            } else return minimumDistance;
                        } else if (itemC == itemB) {
                            if(IteratorB.hasNext()) {
                                itemB = IteratorB.next();
                            } else return minimumDistance;
                        }
                         if (itemA > itemB) {
                             if (itemC > itemA) {
                                 if (IteratorB.hasNext()) {
                                     itemB = IteratorB.next();
                                 } else return minimumDistance;
                             } else if (itemB > itemC){
                                 if (IteratorC.hasNext()) {
                                     itemC = IteratorC.next();                                     
                                 } else return minimumDistance;
                             } else {
                                 if(IteratorB.hasNext()) {
                                     itemB = IteratorB.next();                                    
                                 } else return minimumDistance;
                             }
                         } else if (itemC > itemB) {
                             if(IteratorA.hasNext()) {
                                 itemA = IteratorA.next();                 
                             } else return minimumDistance;
                         } else if (itemA > itemC) {
                            if(IteratorC.hasNext()) {
                                itemC = IteratorC.next();                                
                            } else return minimumDistance;
                         }                    
                    }
        
        return minimumDistance;
    }

    public static void main(String[] args) {
        
        MinimumDistance minDistance = new MinimumDistance();
        List<Integer> listA = new ArrayList<Integer>();
        List<Integer> listB = new ArrayList<Integer>();
        List<Integer> listC = new ArrayList<Integer>();
        listA.add(4);
        listA.add(8);
        listA.add(9);
        listB.add(3);
        listB.add(4);
        listB.add(7);
        listC.add(2);
        listC.add(3);
        listC.add(4);
        listC.add(5);
        System.out.println("minimum distance " + minDistance.minimumDistance(listA, listB, listC) );
        
        
        // TODO Auto-generated method stub

    }

}
