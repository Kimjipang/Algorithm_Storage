import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	
	static String oddKey; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strArr = br.readLine().split("");
        
		Map<String, Integer> map = new TreeMap<>();
		for (String s : strArr) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		int size = strArr.length;
		if (!isPossible(size, map)) {
			System.out.println("I'm Sorry Hansoo");
		} else {
			if (size % 2 == 0) {
				String front = getFront(map, sb);
				String back = sb.reverse().toString();
				System.out.println(front + back);
			} else { 
				map.put(oddKey, map.get(oddKey) - 1);
				String front = getFront(map, sb);
				String back = sb.reverse().toString();
				front += oddKey;
				System.out.println(front + back);
			}

		}
	}

	private static String getFront(Map<String, Integer> map, StringBuilder sb) {
		for (String key : map.keySet()) {
			int halfSize = map.get(key) / 2;
			for (int i = 0; i < halfSize; i++) {
				sb.append(key);
			}
		}
		String front = sb.toString();
		return front;
	}

	private static boolean isPossible(int size, Map<String, Integer> map) {
		if (size % 2 == 0) {
			for (Integer value : map.values()) {
				if (value % 2 == 1) {
					return false;
				}
			}
		} else {
			int oddCount = 0;
			for (String key : map.keySet()) {
				int value = map.get(key);
				if (value % 2 == 1) {
					oddKey = key; 
					oddCount++;
				}

				if (oddCount >= 2) {
					return false;
				}
			}
		}
		return true;
	}

}

