import java.util.*;

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    Pair start = new Pair();
    Pair next = new Pair();
    Pair coordinate = new Pair();
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

        while (directions.size() != 0) // goes through all the possible directions and fills in the pixels
        {
            coordinate = directions.pop();

            if (pixels[coordinate.getRow()][coordinate.getColumn()]==0)
            {
                // fills in the pixel with the correct value
                pixels[coordinate.getRow()][coordinate.getColumn()] = fill;
                fill++;

                // checks if that coordinate has other open pixel neighbors and adds those coordinates to directions
                if (coordinate.getRow()-1 != -1 && pixels[coordinate.getRow()-1][coordinate.getColumn()]==0) //north
                {
                    next.pair(coordinate.getRow()-1, coordinate.getColumn());
                    directions.add(next);
                }
                if (coordinate.getColumn()+1 != 10 && pixels[coordinate.getRow()][coordinate.getColumn()+1]==0) // east
                {
                    next.pair(coordinate.getRow(), coordinate.getColumn()+1);
                    directions.add(next);
                }
                if (coordinate.getRow()+1 != 10 && pixels[coordinate.getRow()+1][coordinate.getColumn()]==0) //south
                {
                    next.pair(coordinate.getRow()+1, coordinate.getColumn());
                    directions.add(next);
                }
                if (coordinate.getColumn()-1 != -1 && pixels[coordinate.getRow()][coordinate.getColumn()-1]==0) // west
                {
                    next.pair(coordinate.getRow(), coordinate.getColumn()-1);
                    directions.add(next);
                }

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

