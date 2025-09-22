

public class Pair {

    int[] coordinate = new int[2];
    
    
    public  void pair(int row, int column)
    {
        coordinate[0] = row;
        coordinate[1] = column;

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


    
