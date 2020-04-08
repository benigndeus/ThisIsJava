package sec04.exam01_hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample1 {
    public static void main(final String[] args) {
        final Map<String, Integer> map = new HashMap<>();

        map.put("신용권", 85);
        map.put("홍길동", 90);
        map.put("동장군", 80);
        map.put("홍길동", 95);
        /* Key값이 "홍길동"으로 동일한 Entry는 나중에 입력된 Entry로 저장 */

        System.out.println("총 Entry 수: " + map.size());
        System.out.println("홍길동: " + map.get("홍길동"));
        System.out.println();
        
        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            Integer value = map.get(key);
            System.out.println("\t" + key + ": " + value);
        }
        System.out.println();

        map.remove("홍길동");
        System.out.println("(홍길동 삭제함)총 Entry 수: " + map.size());
        System.out.println();

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("\t" + key + ": " + value);
        }
        System.out.println();

        map.clear();
        System.out.println("(Entry Clear)총 Entry 수: " + map.size());
    }
}