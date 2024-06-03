import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int size = Integer.parseInt(br.readLine());

		String inputString = br.readLine();

		int patternCount = 0; 
		int continuity = 0; 
		char prev = 'O';

		for (int i = 0; i < size; i++) {
			char current = inputString.charAt(i);

			if (prev != current) {
				continuity++;
			} else {
				if (current == 'O') {
					continuity = 0;
				} else {
					continuity = 1;
				}
			}

			prev = current;
            
			if (continuity >= 2 * n + 1 && continuity % 2 != 0) {
				patternCount++;
			}
		}

		System.out.println(patternCount);
	}
}
