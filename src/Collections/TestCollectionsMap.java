package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class TestCollectionsMap {
	public static void main(String[] args) {
		Map<String, Integer> hm = new HashMap<>();
		hm.put("Олимп", 1);
		hm.put("Индиго", 2);
		hm.put("Фантастика", 6);
		hm.put("Мега", 12);
		hm.put("Мега", 13);	//Значение ключа перезаписывается
		Set<Map.Entry<String, Integer>> set = hm.entrySet();
		for (Map.Entry<String, Integer> me : set) {
		    System.out.print(me.getKey() + ": ");
		    System.out.println(me.getValue());
		}
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		Random random = new Random(36);
		Map<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < 100; i++){
		    int number = random.nextInt(10);
		    Integer frequency = hashMap.get(number);
		    hashMap.put(number, frequency == null ? 1 : frequency + 1);
		}
		System.out.println(hashMap);

	}
}
