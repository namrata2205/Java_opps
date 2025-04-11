// 9. Multithreaded Merge Sort
import java.util.Arrays;

class MultithreadedMergeSort {
    private static final int THREAD_THRESHOLD = 1000;

    public void mergeSort(int[] array) {
        if (array.length < 2) return;
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int left, int right) {
        if (right - left < THREAD_THRESHOLD) {
            sequentialMergeSort(array, left, right);
        } else {
            int mid = (left + right) / 2;
            Thread leftSorter = new Thread(() -> mergeSort(array, left, mid));
            Thread rightSorter = new Thread(() -> mergeSort(array, mid + 1, right));

            leftSorter.start();
            rightSorter.start();

            try {
                leftSorter.join();
                rightSorter.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            merge(array, left, mid, right);
        }
    }

    private void sequentialMergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sequentialMergeSort(array, left, mid);
            sequentialMergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArray.length && j < rightArray.length) {
            array[k++] = (leftArray[i] <= rightArray[j]) ? leftArray[i++] : rightArray[j++];
        }

        while (i < leftArray.length) array[k++] = leftArray[i++];
        while (j < rightArray.length) array[k++] = rightArray[j++];
    }

    public static void main(String[] args) {
        int[] numbers = new int[10000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 10000);
        }

        MultithreadedMergeSort sorter = new MultithreadedMergeSort();
        sorter.mergeSort(numbers);

        System.out.println("Array is sorted: " + isSorted(numbers));
    }

    private static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++)
            if (array[i - 1] > array[i])
                return false;
        return true;
    }
}