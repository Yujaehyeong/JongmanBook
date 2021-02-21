package p20210221;
/**
 * 구간 합 최대값 찾기 - 동적 계획법
 */
public class P118_DP {

    public static void main(String[] args) {
        int arr [] = {-7, 4, -3, 6, 3, -8, 3, 4};
        int result = fastMaxSum(arr);
        System.out.println(result);
    }

    // A[]의 연속된 부분 구간의 최대합을 구한다. 시간복잡도 O(N)
    public static int fastMaxSum(int [] A) {
        int N = A.length;
        int ret = 0;
        int pSum = 0;

        for (int i = 0; i < N; i++) {
            pSum = Math.max(pSum, 0) + A[i];
            ret = Math.max(pSum, ret);
        }

        return ret;
    }
}
