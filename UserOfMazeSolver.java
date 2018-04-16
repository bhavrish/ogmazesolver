public class UserOfMazeSolver {
    
    private static Displayer displayer;
    
    public static void main(String[] commandLine) throws java.io.FileNotFoundException {
        System.out.println();
        Maze maze = new Maze( commandLine[0], Integer.parseInt( commandLine[1]), Integer.parseInt( commandLine[2]));
        System.out.println( maze + System.lineSeparator());
        MazeSolver mazeSolver = new MazeSolver(maze, Integer.parseInt( commandLine[3]));
        MazeSolver test = new MazeSolver();
        System.out.println(test.recursiveSolve());
    }
}
