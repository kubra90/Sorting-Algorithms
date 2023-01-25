package application;

import sorts.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SortingVisualizer {
    Scanner inputScanner = new Scanner(System.in);
    List<Sortable> sortingMethods;

    public void run() {
        SortingPanel sortingPanel = null;

        sortingMethods = Arrays.asList(
                new BubbleSort(),
                new InsertionSort(),
                new QuickSort(),
                new MergeSort()
        );

        displayAvailableSortingMethods();

        while(true) {
            Sortable selectedSortingMethod = askUserForChart();

            if(selectedSortingMethod == null){
                System.exit(0);
            }

            if( sortingPanel != null ){
                sortingPanel.dispose();
            }
            sortingPanel = new SortingPanel(selectedSortingMethod);
            sortingPanel.run();
        }
    }

    private Sortable askUserForChart(){
        Sortable selectedSortingMethod = null;

        System.out.print("Select a chart to display (1-" + sortingMethods.size() + ") or E to exit: ");
        String response = inputScanner.nextLine();

        if( !response.equalsIgnoreCase("e")) {

            while (true) {
                try {

                    // User selection started at 1, not 0
                    int userSelection = Integer.parseInt(response);
                    selectedSortingMethod = sortingMethods.get(userSelection - 1);
                    break;

                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number from 1-" + sortingMethods.size());
                    response = inputScanner.nextLine();
                }
            }
        }

        return selectedSortingMethod;
    }

    private void displayAvailableSortingMethods(){
        for (int i = 0; i < sortingMethods.size(); i++) {
            System.out.println((i + 1) + ". " + sortingMethods.get(i).getSortName());
        }
    }
}
