package sorts;

import application.SortingPanel;

public class InsertionSort implements Sortable {
    /*
     * For reference:
     * https://en.wikipedia.org/wiki/Insertion_sort
     */
    @Override
    public void sort(int[] arr, SortingPanel visualizer) {

        for (int i = 1; i < arr.length; i++) {

            for (int k = 0; k < i; k++) {
                if (arr[k] > arr[i]) {
                        int temp = arr[i];
                        arr[i] = arr[k];
                        arr[k] = temp;
                        visualizer.updateDisplay();


                    }

                }

            }
        }

    @Override
    public String getSortName() {
        return "Insertion Sort";
    }

}
