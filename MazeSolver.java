import java.util.Scanner;

public class MazeSolver {
    private final static int[] dirlist = {Maze.EAST, Maze.NORTH, Maze.WEST, Maze.SOUTH};
    
    private Maze currentmaze;
    private static Displayer displayer;
	
    public MazeSolver(Maze input, int windowHeight) {
	currentmaze = new Maze(input);
	displayer = new Displayer(windowHeight);
    }
    
    public boolean recursiveSolve(Maze unsolvedMaze) {
        // explorer on a wall
	if(currentmaze.explorerIsOnA() == Maze.WALL) {
		return false;
	}
	
	// explorer on the treasure
	else if(currentmaze.explorerIsOnA() == Maze.TREASURE) {
		return true;
	}
	
	else {
            for(int dir=0; dir < 4; dir++) { //4 was originally "dirlist.length()" but that produced an error
            	Maze snapshot = new Maze(currentmaze);
		currentmaze.dropA(Maze.WALL);
                currentmaze.go(dir);	
            	if (recursiveSolve()){						
                	return true;
            	}
            	else {
			currentmaze= new Maze(snapshot);
		}
            }
            return false;
	}
    }
}
