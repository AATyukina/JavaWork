package Collections;

import java.util.HashSet;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class TestCollectionSet {

	public static void main(String[] args) {
		HashSet<Integer> hsi = new HashSet<>();
		hsi.add(5);
		hsi.add(6);
		hsi.add(1);
		hsi.add(5);
		hsi.add(-10);
		System.out.println("Размер " + hsi.size()); // Добавлено 5, а размер 4
		for (Integer i : hsi)
			System.out.println(i);

		Random random = new Random(30);
		SortedSet<Integer> numberSet = new TreeSet<>();	//Строго отсортированный
		for (int i = 0; i < 1000; i++)
			numberSet.add(random.nextInt(10));
		System.out.println(numberSet.toString());

		SortedSet<String> stringSet = new TreeSet<>();
		stringSet.add("Арина");
		stringSet.add("Марина");
		stringSet.add("Карина");
		stringSet.add("Дарина");
		stringSet.add("Арина");
		System.out.println(stringSet.toString());
	}

}
