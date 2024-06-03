import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		String replacedInput = input.replaceAll("(c=|c-|dz=|d-|s=|lj|nj|z=)", "x");

		System.out.println(replacedInput.length());
	}
}