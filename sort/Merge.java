package sort;

/**
 * Created by tianz on 2017/5/26 0026.
 */
public class Merge {
    private static Comparable[] aux; //辅助数组

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    // 核心操作，对于两个有序数组的归并
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j];
            else if (j > hi) a[k] = aux[i];
            else if (less(aux[j],aux[i])) a[k] = aux[j];
            else a[k] = aux[i];
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 自底向上的归并排序
     */
    static class MergeBU{
        private static Comparable[] aux;

        public static void sort(Comparable[] a) {
            int N = a.length;
            aux = new Comparable[N];
            int lo,sz;
            for (sz = 1; sz < N; sz = sz + sz)
                for (lo = 0; lo < N - sz; lo += sz + sz)
                    merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
        }
    }
}
