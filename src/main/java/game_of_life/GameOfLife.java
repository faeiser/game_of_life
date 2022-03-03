package game_of_life;

import java.util.Random;
import java.util.Scanner;

public class GameOfLife {

    public static void playGround(int[][] array) {
        // ### output playing field
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 1; j < array[i].length - 1; j++) {
                if (array[i][j] == 0) {
                    System.out.print(".");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] randomCell(int[][] array) {
        // ### random created cells
        Random live = new Random();
        int cell;
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 1; j < array[i].length - 1; j++) {
                cell = live.nextInt(2);
                array[i][j] = cell;
            }
        }
        return array;
    }

    public static int[][] game_of_live(int array[][]) {
        // ### return array
        int[][] array_next = new int[array.length][array[0].length];
        // ### start loop
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 1; j < array[i].length - 1; j++) {
                int neighbour_live, neighbour_dead;
                // ### neighbour scanner(Moor), alive cells
                if (array[i][j] == 1) {
                    neighbour_live = -1;
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            if (array[k][l] == array[i][j]) {
                                // ### neighbour counter, alive cells
                                neighbour_live += 1;
                            }
                        }
                    }
                    // ### optional output neighbors, alive cells
                    // System.out.println("live "+i+j+"-"+neighbour_live);

                    // ### query alive or dead, alive cells
                    if (neighbour_live < 2) {
                        array_next[i][j] = 0;
                    } else if (neighbour_live >= 2 & neighbour_live <= 3) {
                        array_next[i][j] = 1;
                    } else {
                        array_next[i][j] = 0;
                    }

                }
                // ### neighbour scanner(Moor), dead cells
                else {
                    neighbour_dead = 0;
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            if (array[k][l] != array[i][j]) {
                                // ### neighbour counter, dead cells
                                neighbour_dead += 1;
                            }
                        }
                    }
                    // ### optional output neighbors, dead cells
                    // System.out.println("dead "+i+j+"-"+neighbour_dead);

                    // ### query alive or dead, dead cells
                    if (neighbour_dead == 3) {
                        array_next[i][j] = 1;
                    }
                }
            }
        }
        return array_next;
    }

    public static void main(String[] args) {

        // ### playing field size & generations
        int x_fields = 100, y_fields = 20, generations = 0;
        // ### playing field
        int playground[][] = new int[y_fields + 2][x_fields + 2];

        Scanner s = new Scanner(System.in);

        System.out.print("Please specify the number of generations: ");
        generations = s.nextInt();
        s.close();

        playground = randomCell(playground);

        for (int i = 1; i <= generations; i++) {
            System.out.println("Generation: " + i);
            playGround(playground);
            playground = game_of_live(playground);
        }
    }
}
