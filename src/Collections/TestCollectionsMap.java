package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class TestCollectionsMap {
	public static void main(String[] args) {
		Map<String, Integer> hm = new HashMap<>();
		hm.put("�����", 1);
		hm.put("������", 2);
		hm.put("����������", 6);
		hm.put("����", 12);
		hm.put("����", 13);	//�������� ����� ����������������
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
