/**
  Represent a Maze with an Explorer in it
  
  A "MazeTerminal" is...
    o  a wall element; or
    o  a treasure; or
    o  a stepping stone.
  
  A "Maze" is...
    o  a MazeTerminal; or
    o  a stepping stone with a Maze as any of its 4 neighbors
  plus an optional explorer positioned on any element of the Maze.
 */
import java.util.Scanner;

public class Maze {

    // MazeTerminal named constants
    public final static int TREASURE = 0;
    public final static int WALL = 1;
    public final static int STEPPING_STONE = 2;
    
    // directions that can be searched
    public final static int EAST =  1;
    public final static int NORTH = 2;
    public final static int WEST =  4;
    public final static int SOUTH = 8;
       /* Values are pretty arbitrary. Values of 2^n might be useful
          in the unlikely event that we ever want to add north-west, etc.:
          2+4 --> 6  */
    
    private int[][] maze;
    private final static int MAX_RANKS = 64;
    private int rankCount;  // number of ranks in a constructed Maze
    
    private Vector explorerPosition;  // see Vector inner class, below

    /**
      Construct an instance from the contents of a file.
      For v0, maze is rectangular, with every line having the same length.
     */
    public Maze( String sourceFilename
               , int explorerRank, int explorerFile
               ) throws java.io.FileNotFoundException {

        /* Construct the maze array one rank at a time, in case
           we ever allow non-rectangular mazes  */
        maze = new int[ MAX_RANKS][];

        Scanner sc = new Scanner( new java.io.File( sourceFilename));
        sc.useDelimiter("");  // Whitespaces are data, not delimiters.

        // process the maze file
        while( sc.hasNextLine() ) {
            int rank = rankCount++;
            /* So rankCount == last rank +1, as usual.
               That is, rankCount is one larger than the number of
               the last-used rank.
             */
            String line = sc.nextLine();
            // System.out.println( "|" + line + "|");
            
            maze[ rank] = new int[ line.length()];

            // Convert the input line into maze elements.
            for( int file = 0; file < line.length(); file++ ) {
                String inChar = line.substring( file, file+1);
                int element;  // value destined for maze array
                if(      inChar.equals("0"))  element = TREASURE;
                else if( inChar.equals("*"))  element = STEPPING_STONE;
                // spaces and unrecognised characters are walls
                else                          element = WALL;
                maze[ rank][ file] = element;
            }
        }
        
        explorerPosition = new Vector().add( explorerRank, explorerFile);
    }

    public Maze( Maze old) {
        explorerPosition = new Vector( old.explorerPosition);

        throw new java.lang.RuntimeException(
            "Write code to copy the maze[][] array and rankCount.");
    }

    public String toString() {
        final String outChar = "0 *";  // no explorer here
        final String exOnTop = "!Ee";  /* explorer on top of
           treasure, wall, stepping stone, etc. */

        // build string for top and bottom separators
        String aboveAndBelow = "-";
        for( int file = 0; file < maze[0].length; file++)
            aboveAndBelow += "-";
        aboveAndBelow += "-" + System.lineSeparator();
        
        // process maze[][], explorer
        String result = aboveAndBelow;
        for( int rank = 0; rank < rankCount; rank++) {
            result += "|";
            for( int file = 0; file < maze[ rank].length; file++) {
                int elem = maze[ rank][ file];
                
                // choose from the appropriate character set,
                if(    explorerPosition != null
                    && explorerPosition.equals( rank, file)
                  )
                     result += exOnTop.substring( elem, elem+1);
                else result += outChar.substring( elem, elem+1);
            }
            result += "|" + System.lineSeparator();
        }
        return   result + aboveAndBelow;
    }

    public void go( int direction)  { 
        switch( direction) {
            case EAST:
                explorerPosition = explorerPosition.add( 0, 1);
                break;
            case NORTH:
                explorerPosition = explorerPosition.add( -1, 0);
                break;
            case WEST:
                explorerPosition = explorerPosition.add( 0, -1);
                break;
            case SOUTH:
                explorerPosition = explorerPosition.add( 1, 0);
                break;
        }
    }

    public void dropA( int mazeElement) {
        if( mazeElement != TREASURE)
            maze[ explorerPosition.rank][ explorerPosition.file] = mazeElement;
    }

    public int explorerIsOnA() {
        if( explorerPosition == null) return WALL;
        else return maze[ explorerPosition.rank][ explorerPosition.file];
    }

    private class Vector {
        private int rank, file;
        
        // The no-arg constructor produces [0, 0] 
        private Vector() {}

        // copy-constructor
        private Vector( Vector old) {
            rank = old.rank;
            file = old.file;
        }

        private Vector add( int ranks, int files) { 
            rank += ranks;
            file += files;
            if(    0 <= rank && rank < rankCount
                && 0 <= file && file < maze[ rank].length
              )  return this;
            else return null;  // outside maze
        }

        private boolean equals( int rank, int file) {
            return this.rank == rank && this.file == file;
        }
    }
}
