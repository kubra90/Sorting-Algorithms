package sorts;

import application.SortingPanel;

public class BubbleSort implements Sortable {

    @Override
    public void sort(int[] arr, SortingPanel visualizer) {

        for (int i = 0; i < arr.length; i++) {

            for (int k = 0; k < arr.length - 1; k++) {

                if (arr[k] > arr[k + 1]) {
                    int temp = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = temp;

                    /*
                     * Call updateDisplay in your algorithm to see each frame
                     * as the sorting method updates. This method can be placed
                     * at different locations in this code to speed up or slow down
                     * the sorting visualization.
                     */
                    visualizer.updateDisplay();
                }
            }
        }
    }

    @Override
    public String getSortName() {
        return "Bubble Sort";
    }
}
