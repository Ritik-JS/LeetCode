
class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final int MOD = 1_000_000_007;
        int[] cnt = new int[31];

        for (int x : nums) {
            while (x != 0) {
                int bit = Integer.numberOfTrailingZeros(x);
                cnt[bit]++;
                x &= x - 1;
            }
        }

        long ans = 0;

        for (int j = 0; j < k; j++) {
            long x = 0;

            for (int i = 0; i < 31; i++) {
                if (cnt[i] > 0) {
                    x |= 1L << i;
                    cnt[i]--;
                }
            }

            ans = (ans + x * x) % MOD;
        }

        return (int) ans;
    }
}
