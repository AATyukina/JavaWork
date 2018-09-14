package Collections;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class TestCollectionsQueue {

	public static void main(String[] args) {
		PriorityQueue<Integer> qi = new PriorityQueue<>(5);
		Random rand = new Random();
		for(int i=0; i<7; i++){
			qi.add(new Integer(rand.nextInt(100)));
        }
		for(Integer in: qi) System.out.println(in);
//		for(int i=0;i<7;i++){
//            Integer in = qi.poll();
//            System.out.println("Обрабатываем Integer:"+in);
//        }
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		Iterator it = qi.iterator();
		while(it.hasNext()) System.out.println(it.next());
	}

}
