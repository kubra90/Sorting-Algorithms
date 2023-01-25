package application;

import sorts.Sortable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class SortingPanel extends JLabel {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final int ARRAY_SIZE = WIDTH / 2;
    private static final int CELL_WIDTH = WIDTH / ARRAY_SIZE;

    private int[] array;
    private int cellWidth;

    private JFrame window;
    private JPanel displayPanel;
    private BufferedImage display;

    private Sortable currentSorter;

    public SortingPanel(Sortable sorter) {
        currentSorter = sorter;
        display = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        setIcon(new ImageIcon(display));

        array = new int[ARRAY_SIZE];
        cellWidth = WIDTH / ARRAY_SIZE;

        window = new JFrame(currentSorter.getSortName());
        displayPanel = new JPanel();
        displayPanel.add(this);
        displayPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        addMouseEffects(window);
        window.add(displayPanel);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.pack();
        window.setVisible(true);

        randomizeArray();
    }

    public void run(){
        currentSorter.sort(array, this);
        updateDisplay();
    }

    public void updateDisplay() {
        Color itemColor;

        for (int i = 0; i < WIDTH; i++) {
            for (int k = 0; k < HEIGHT; k++) {
                if (array[i / CELL_WIDTH] > HEIGHT - k) {
                    itemColor = Color.BLACK;
                } else {
                    itemColor = Color.ORANGE;
                }
                display.setRGB(i, k, itemColor.getRGB());
            }
        }

        setIcon(new ImageIcon(display));
    }

    public void dispose(){
        this.window.dispose();
    }

    private void randomizeArray() {
        Random randGen = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = randGen.nextInt(HEIGHT);
        }
        updateDisplay();
    }

    private void addMouseEffects(JFrame window){
        window.addMouseListener(new MouseListener() {

            /*
             * Click the mouse on the window to see how the array sorts
             */
            @Override
            public void mouseReleased(MouseEvent e) {
                randomizeArray();
            }

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) { }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }
}
