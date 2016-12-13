package programming.set7.sudoku;

import java.util.Set;

/**
 * A sudoku board which supports validation of the fields and visual output
 * of the board.
 */
public class Sudoku extends NumberBoard {

    /** Number of fields per row/column */
    private final static int FIELDS = 9;

    /**
     * Creates a new Sudoku board
     */
    public Sudoku() {
        super(Sudoku.FIELDS, Sudoku.FIELDS);
    }

    /**
     * Sets the value of the given cell.
     *
     * @param row
     *            the cell's row, starting at 0.
     * @param col
     *            the cell's column, starting at 0.
     * @param value
     *            the cell's value. Must be {@code 1 <= value <= 9} or {@link #EMPTY}.
     */
    @Override
    public void setValueAt(int row, int col, int value) {
        if ((value >= 1 && value <= 9) || value == EMPTY) {
            super.setValueAt(row, col, value);
        }
    }

    /**
     * Checks whether the sudoku instance is valid, which requires the numbers 1-9
     * not to exist twice in a row, column or 3x3 field.
     *
     * @return {@code true} if the sudoku is valid, {@code false} if not
     */
    public boolean isValid() {
        /*
        How to calculate the 3x3 square:

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
        for (int i = 0; i < Sudoku.FIELDS; i++) {
            Set<Integer> rowValues = new SudokuSet<>();
            Set<Integer> colValues = new SudokuSet<>();
            Set<Integer> squareValues = new SudokuSet<>();
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

    /**
     * @return a text presentation of the sudoku instance
     */
    public String toString() {
        String output = "";
        for (int row = 0; row < Sudoku.FIELDS; row++) {
            for (int column = 0; column < Sudoku.FIELDS; column++) {
                if (column != 0) {
                    output += " ";
                }
                int val = this.getValueAt(row, column);
                if (val != EMPTY) {
                    output += val;
                } else {
                    output += " ";
                }

            }
            output += "\n";
        }
        return output;
    }
}
