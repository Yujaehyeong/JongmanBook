package p20210221;
/**
 * 구간 합 최대값 찾기 - 분할정복 기법
 */
public class P118_Binary {

    public static void main(String[] args) {
        int arr [] = {-7, 4, -3, 6, 3, -8, 3, 4};
        int result = fastMaxSum(arr, 0, arr.length-1);
        System.out.println(result);
    }

    // A[]의 연속된 부분 구간의 최대합을 구한다. 시간복잡도 O(NlogN)
    public static int fastMaxSum(int [] A, int lo, int hi) {
        // 기저사례 : 구간의 길이가 1인 경우
        if (lo == hi) return A[lo];
        // 배열을 A[left ~ mid], A[mid+1 ~ right] 로 나눈다.
        int mid = (lo + hi) / 2;

        // 두 부분에 모두 걸쳐 있는 최대 합 구간을 찾는다. 이 구간은
        // A[i ~ mid], A[mid+1 ~ j] 형태를 갖는 구간의 합으로 이루어진다.

        // A[i ~ mid] 형태를 갖는 최대 구간을 찾는다
        int left = 0;
        int right = 0;
        int sum = 0;

        for (int i = mid; i >= lo; --i) {
            sum += A[i];
            left = Math.max(left, sum);
        }

        // A[mid+1 ~ j] 형태를 갖는 최대 구간을 찾는다
        sum = 0;
        for (int j = mid+1; j <= hi; j++) {
            sum += A[j];
            right = Math.max(right, sum);
        }

        // 최대 구간이 두 조각 중 하나에만 속해 있는 경우의 답을 재귀 호출로 찾는다.
        int single = Math.max(fastMaxSum(A, lo, mid), fastMaxSum(A, mid+1, hi));

        // 두 경우 중 최대치를 반환한다.
        return Math.max(left + right, single);
    }
}
