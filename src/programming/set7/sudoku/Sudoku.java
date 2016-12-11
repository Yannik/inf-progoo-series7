package programming.set7.sudoku;

import java.util.HashSet;
import java.util.Set;

public class Sudoku extends NumberBoard {

    private final static int FIELDS = 9;

    public Sudoku() {
        super(Sudoku.FIELDS, Sudoku.FIELDS);
    }

    @Override
    public void setValueAt(int row, int col, int value) {
        if (value >= 0 && value <= 9) {
            super.setValueAt(row, col, value);
        }
    }

    public void printSquares() {
        int i = 3;
        for (int j=0; j <Sudoku.FIELDS; j++) {
            System.out.print("(" + (j/3 + (i/3)*3) + "," + (j%3 + (i*3)%9) + ")");
        }
    }
    /*
    First Square: (i=0), 0<=j<8
    (0,0), (0,1), (0,2)
    (1,0), (1,1), (1,2)
    (2,0), (2,1), (2,2)

    Second square: (i=1)
    (0,3), (0,4), (0,5)
    (1,3), (1,4), (1,5)
    (2,3), (2,4), (2,5)

    fourth square: (i=3)
    (3,0), (3,1), (3,2)
    (4,0), (4,1), (4,2)
    (5,0), (5,1), (5,2)

    i-sequenz:
    0,0,0,1,1,1,2,2,2
    0,0,0,1,1,1,2,2,2
    0,0,0,1,1,1,2,2,2
    3,3,3,4,4,4,5,5,5

    j-sequenz:
    0,1,2,0,1,2,0,1,2
    3,4,5,3,4,5,3,4,5
    6,7,8,6,7,8,6,7,8
    0,1,2,0,1,2,0,1,2



    i/3:
    0,1,2=0
    3,4,5=1
    6,7,8=2

    i*3 % 9:
    0,3,6: 0
    1,4,7: 3
    2,5,7: 6

    i%3:
    0,3,6: 0
    1,4,7: 1
    2,5,8: 2


     */
    public boolean isValid() {
        // check rows and columns
        for (int i = 0; i < Sudoku.FIELDS; i++) {
            Set<Integer> rowValues = new HashSet<>();
            Set<Integer> colValues = new HashSet<>();
            Set<Integer> squareValues = new HashSet<>();
            for (int j = 0; j < Sudoku.FIELDS; j++) {
                if (!rowValues.add(this.getValueAt(i, j)) ||
                        !colValues.add(this.getValueAt(j, i)) ||
                        !squareValues.add(this.getValueAt(j/3 + (i/3)*3,(j%3 + (i*3)%9)))) {
                    return false;
                }
            }
        }

        return true;
    }

    public String toString() {
        return "";
    }
}
