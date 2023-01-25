package sorts;

import application.SortingPanel;

public class MergeSort implements Sortable{
    /*
     * For reference:
     * https://en.wikipedia.org/wiki/Merge_sort
     */



    @Override
    public void sort(int[] arr, SortingPanel visualizer) {
        /*
         *divide array into 2 half arrays. Then, again continue dividing
         * each array into half array till one element left. Then you will merge
         * each array into new sorted array.
         */

        int lengthArray = arr.length;
        //we have one element, already sorted.
        if(lengthArray <= 1){
            return;
        }
            // if not continue to divide each array
            // get the mid index of array

            int middle = lengthArray / 2;
            int[] leftArray = new int[middle];
            int[] rightArray = new int[lengthArray - middle];
            //visualizer.updateDisplay();
            // you should decide from which indexes of left array and right array consist of/
            for (int i = 0; i < middle; i++) {
                leftArray[i] = arr[i];
                visualizer.updateDisplay();
            }
            visualizer.updateDisplay();



            for (int i = middle; i < lengthArray; i++) {
                rightArray[i - middle] = arr[i];
                visualizer.updateDisplay();

            }
            visualizer.updateDisplay();

        //visualizer.updateDisplay();
            // recursive function. we are calling same method inside of the method. this is because to repeat
            // each action to sort till one element left.


            sort(leftArray, visualizer);
            sort(rightArray, visualizer);

            merge(arr, leftArray, rightArray, visualizer);
            //visualizer.updateDisplay();


    }
    public  void merge(int[] arr, int[] leftArray, int[] rightArray, SortingPanel visualizer) {
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;

        // we are comparing each element in the same index, accordingly you re going to
        // merge into the new array.
        // you need to have 3 variable for each array.
        int i =0, j =0, k =0;

        while (i < leftLength && j < rightLength){
            if(leftArray[i] <= rightArray[j]){
                arr[k] = leftArray[i];
                visualizer.updateDisplay();
                i++;

            }else {
                arr[k] = rightArray[j];
                visualizer.updateDisplay();
                j++;

            }// you need to increase k for sorted array after checking if-else statement.
           k++;
        }
        //visualizer.updateDisplay();

        // to check any remaining element in the array
        while(i < leftLength) {
            arr[k] = leftArray[i];
            i++;
            k++;
            visualizer.updateDisplay();
        }
        while ( j < rightLength ){
            arr[k] = rightArray[j];
            j++;
            k++;
            visualizer.updateDisplay();

        }
        visualizer.updateDisplay();

    }

    @Override
    public String getSortName() {
        return "Merge Sort";
    }
}
