import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        dp[0] = 0;
        for (int i = 1; i < N +1; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
            }
        }
        System.out.println(dp[N]);

    }
}