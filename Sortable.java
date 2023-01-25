package sorts;

import application.SortingPanel;

public interface Sortable {
    void sort(int[] itemsToSort, SortingPanel visualizer);
    String getSortName();

}
