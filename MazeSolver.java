import java.util.Scanner;

public class MazeSolver {
    private final static int[] dirlist = {Maze.EAST, Maze.NORTH, Maze.WEST, Maze.SOUTH};
    
    public MazeSolver () {		
		solvedMazes = new ArrayList<Maze>();
	}
    
    public boolean recursiveSolve(int x, int y) {
        if(current.explorerIsOnA() == Maze.WALL) {
		return false;
	}
	else if(current.explorerIsOnA() == Maze.TREASURE) {
		addSolve(current);
		return true;
	}
        else {
            maze.dropA(Maze.WALL);
            Maze snapshot = new Maze(maze);
            for(int dir=0; dir<dirlist.length(); i++) {
                maze.go(dir);	
            if (recursiveSolve(maze)==false){						
                maze= new Maze(snapshot);		
                displayerTest(maze);
            }
            else return true;				          																							//					return true :)
        }
        return false;				
     }
}
