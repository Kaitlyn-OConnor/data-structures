

public class Pair {

    int[] coordinate;
    
    int[] pair(int row, int column)
    {
        int[] coordinate = {row, column};
        

        return coordinate;

    }

    public int getRow()
    {
        return coordinate[0];
    }

    public int getColumn()
    {
        return coordinate[1];
    }
}







    /* 

            // adds the initial paths to directions that are available
            // 1 = North -1 = South 2 = East -2 = West
            if (start[2] == -10)
            {
                if (start[0]-1 != -1 && pixels[start[0]-1][start[1]] == 0) // initial north
                {
                    int[] north = {start[0], start[1], 1};
                    directions.add(north);
                }
                if (start[0]+1 != 11 && pixels[start[0]+1][start[1]] == 0) // initial south
                {
                    int[] south = {start[0], start[1], -1};
                    directions.add(south);
                }
                if (start[1]+1 != 11 && pixels[start[0]][start[1]+1] == 0) // initial east
                {
                    int[] east = {start[0], start[1], 2};
                    directions.add(east);
                }
                if (start[1]-1 != -1 && pixels[start[0]][start[1]-1] == 0) // initial west
                {
                    int[] west = {start[0], start[1], -2};
                    directions.add(west);
                }


            }



            return pixels;
        }
    */
    
