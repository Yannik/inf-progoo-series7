package programming.set7.sudoku;

import java.util.HashSet;
import java.util.Set;

public class SudokuSet<E> extends HashSet<E> implements Set<E> {
    @Override
    public boolean add(E o) {
        if ((Integer)o == Sudoku.EMPTY) {
            return true;
        }
        return super.add(o);
    }
}
