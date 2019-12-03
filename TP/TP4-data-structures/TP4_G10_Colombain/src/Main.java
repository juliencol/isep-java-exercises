import java.util.*;

public class Main {
    static char[][] plateau = new char[8][8];
    static int[] position = new int[2];
    static char direction = 'E';

    public static void main(String[] args) {
        initialisation();
        // System.out.println(Arrays.deepToString(plateau));
        while (true) {
            ArrayDeque<String> file = creationFile();
            deplacement(file);
            System.out.println(Arrays.toString(position));
            System.out.println(direction);
        }
    }

    public static void initialisation() {
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau.length; j++) {
                plateau[i][j] = ' ';
            }
        }
        plateau[7][0] = 'X';
    }

    public static ArrayDeque<String> creationFile() {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> file = new ArrayDeque<>();
        do {
            System.out.println("Chose an instruction: ");
            System.out.println("A pour avancer");
            System.out.println("G pour faire un quart de tour vers la gauche");
            System.out.println("D pour faire un quart de tour vers la droite");
            String userPosition = scanner.nextLine();
            if (userPosition.equals("A") || userPosition.equals("G") || userPosition.equals("D")) {
                file.add(userPosition);
            }
        } while (file.size() != 5);
        return file;
    }

    public static boolean checkIfInPlateau(ArrayDeque<String> instructions) {
        /** This function checks if the turtle is in the plateau.
         * returns true if yes and false if no **/
        return !(position[0] > 6 || position[0] < 0 || position[1] > 6 || position[1] < 0);
    }

    public static void deplacement(ArrayDeque<String> instructions) {
        for (String instruction: instructions) {
            switch(instruction) {
                case "A":
                    if (direction == 'N') {
                        if (checkIfInPlateau(instructions)) {
                            position[0]--;
                        }
                    }
                    else if (direction == 'S') {
                        if (checkIfInPlateau(instructions)) {
                            position[0]++;
                        }
                    }
                    else if (direction == 'E') {
                        if (checkIfInPlateau(instructions)) {
                            position[1]++;
                        }
                    }
                    else if (direction == 'O') {
                        if (checkIfInPlateau(instructions)) {
                            position[1]--;
                        }
                    }
                    break;

                case "G":
                    if (direction == 'N' || direction == 'S') {
                        direction = 'O';
                    }
                    else if (direction == 'E') {
                        direction = 'N';
                    }
                    else if (direction == 'O') {
                        direction = 'S';
                    }
                    break;

                case "D":
                    if (direction == 'N' || direction == 'S') {
                        direction = 'E';
                    }
                    else if (direction == 'E') {
                        direction = 'S';
                    }
                    else if (direction == 'O') {
                        direction = 'N';
                    }
                    break;
            }
        }
    }
}
