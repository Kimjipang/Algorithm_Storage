import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String expandedAddress = expandIPv6(input);

        System.out.println(expandedAddress);
    }

    public static String expandIPv6(String ipv6) {
        String[] groups = new String[8];
        Arrays.fill(groups, "0000");

        String[] parts = ipv6.split("::", -1);

        String[] leftParts = parts[0].isEmpty() ? new String[0] : parts[0].split(":");
        String[] rightParts = parts.length > 1 && !parts[1].isEmpty() ? parts[1].split(":") : new String[0];

        for (int i = 0; i < leftParts.length; i++) {
            groups[i] = padZeros(leftParts[i]);
        }

        for (int i = 0; i < rightParts.length; i++) {
            groups[groups.length - rightParts.length + i] = padZeros(rightParts[i]);
        }

        return String.join(":", groups);
    }

    public static String padZeros(String segment) {
        StringBuilder sb = new StringBuilder(segment);
        while (sb.length() < 4) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }
}