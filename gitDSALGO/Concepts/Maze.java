package gitDSALGO.Concepts;

public class Maze {
    
    /*
     *  given maze find number of possible way you can reach bottom
     * 
     */

    public static int numberOfPath(int r, int c){
       
        if(r==0|| c==0){
            return 1;
        }
        int right = numberOfPath(r,c-1);
        int down = numberOfPath(r-1,c);

        return right+down;

    }

    /*
     * print all the path 
     * 
     */

    public static void printPath(int r, int c){
        printPathHelper("", r, c);

    }
    public static void printPathHelper(String s,int r, int c){
        if(r==0 && c==0){
            System.out.println(s);
            return;
        }
        if(r>0)
        printPathHelper(s+"V", r-1,c);
        if(c>0)
        printPathHelper(s+"R", r,c-1);
        if(c>0 && r>0)
        printPathHelper(s+"D", r-1, c-1);
    }

    public static void printPathBlocker(boolean[][]maze){
        printPathBlockerHelper("", maze,maze.length-1, maze[0].length-1);

    }
    public static void printPathBlockerHelper(String s,boolean[][]maze,int r, int c){
        if(r== 0 && c==0){
            System.out.println(s);
            return;
        }
        if(maze[r][c] == false){
            return;
        }
        if(r>0)
        printPathBlockerHelper(s+"V",maze, r-1,c);
        if(c>0)
        printPathBlockerHelper(s+"R",maze, r,c-1);
    }
    public static void main(String[] args) {
        boolean[][] maze = new boolean[][]{{true,true,true},{true,false,true},{true,true,true}};
        printPathBlocker(maze);
    }
}
