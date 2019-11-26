class QuickSort {
    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int left, int right) {
        if (left > right) {
            return;
        }

        int key = a[left];
        int i = left, j = right;
        while (i < j) {
            // 反向查找比key小的值
            while (i < j && key <= a[j]) {
                j--;
            }

            // 正向查找到比key大的值
            while (i < j && key >= a[i]) {
                i++;
            }

            // 调换两个值的位置
            if (i < j) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        
        // 在一次遍历完成后将key归位，使得key左边的值都比key小（大），右边的值都比key大（小）
        a[left] = a[i];
        a[i] = key;

        // 然后左右两边的子数组各自递归进行排序
        sort(a, left, i - 1);
        sort(a, i + 1, right);
    }
}
