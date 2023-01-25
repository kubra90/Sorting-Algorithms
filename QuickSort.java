package sorts;

import application.SortingPanel;

/*
 * For reference:
 * https://en.wikipedia.org/wiki/Quicksort
 */
public class QuickSort implements Sortable{



    @Override
    public void sort(int[] arr, SortingPanel visualizer) {

    }

    public void quickSort(int[] arr, int low, int high, SortingPanel visualizer) {
        int leftPointer = partition(arr, low, high, visualizer);
        quickSort(arr, low, leftPointer -1, visualizer);
        quickSort(arr, leftPointer + 1, high, visualizer);
    }

    public static int partition(int[] arr, int low, int high, SortingPanel visualizer) {

        int pivot = arr[arr.length - 1];
        int leftPointer = low;
        int rightPointer = high - 1;

        while (leftPointer < rightPointer) {

            //we should check the lp to be higher than pivot, if not iterreate
            //increase one index of the leftpointer.
            while (arr[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
                //visualizer.updateDisplay();
            }
            while (arr[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
                //visualizer.updateDisplay();
            }

            //swap the numbers in rp and lp if they meet the condition. If rp larger than pivot and
            // lp is smaller than pivot.
            swap(arr, leftPointer, rightPointer, visualizer);
        }

        if (arr[leftPointer] > arr[high]) {
            swap(arr, leftPointer, high, visualizer);
        } else {
            leftPointer = high;
        }
        return leftPointer;


        // if they are in the same location, index swap with the pivot
// you need to specify two different arrays
        //sort(arr, visualizer);

    }

    public static void swap(int[] arr, int index1, int index2, SortingPanel visualizer){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        visualizer.updateDisplay();
    }

    @Override
    public String getSortName() {
        return "Quick Sort";
    }
}
