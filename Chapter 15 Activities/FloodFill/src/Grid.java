import java.util.*;

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    Pair start = new Pair();
    Pair next = new Pair();
    Stack<Pair> directions;

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        directions = new Stack<>();
        start.pair(row,column);
        directions.add(start);
        int fill = 1;
        Pair[] addList;

        while (directions.size() != 0) // goes through all the possible directions and fills in the pixels
        {
            Pair coordinate = directions.pop();
            //next.pair(row,column);

            while (next.getRow()-1 != -1 && pixels[next.getRow()-1][next.getColumn()]==0)
            {
                // updates next so it is the current pixel
                next.pair(next.getRow()-1, next.getColumn());

                // fills in the pixel with the correct value
                pixels[next.getRow()][next.getColumn()] = fill;
                fill++;

                // checks if that coordinate has other branching paths and adds that to directions
                if (next.getColumn()+1 != 11 && pixels[next.getRow()][next.getColumn()+1]==0)
                {
                    start.pair(row,next.getColumn()+1);
                    directions.add(start);
                }
                if (next.getColumn()-1 != -1 && pixels[next.getRow()][next.getColumn()-1]==0)
                {
                    start.pair(row,next.getColumn()-1);
                    directions.add(start);
                }

                
        }




    }

    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
