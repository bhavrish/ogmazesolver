import java.util.Scanner;

public class MazeSolver {
    public final static int TREASURE = 0;
    public final static int WALL = 1;
    public final static int STEPPING_STONE = 2;
    
int[][] maze = new int[width][height];
boolean[][] wasHere = new boolean[width][height];
boolean[][] correctPath = new boolean[width][height];
int startX, startY;
int endX, endY; 


public boolean recursiveSolve(int x, int y) {
    if (x == endX && y == endY) return true;
    else if (maze[x][y] == 2 || wasHere[x][y]) return false;  
    else {
        wasHere[x][y] = true;
        if (x != 0)
            if (recursiveSolve(x-1, y)) {
                correctPath[x][y] = true;
                return true;
            }
        if (x != width - 1) 
            if (recursiveSolve(x+1, y)) {
                correctPath[x][y] = true;
                return true;
            }
        if (y != 0)
            if (recursiveSolve(x, y-1)) {
                correctPath[x][y] = true;
                return true;
            }
        if (y != height - 1)
            if (recursiveSolve(x, y+1)) {
                correctPath[x][y] = true;
                return true;
            }
        return false;
}
}
