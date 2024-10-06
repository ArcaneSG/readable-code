package cleancode.minesweeper.tobe.position;

import java.util.Objects;

public class CellPosition {
    private final int rowIndex;
    private final int colIndex;

    private CellPosition(int rowIndex, int colIndex) {
        if(rowIndex < 0 || colIndex < 0){
            throw new IllegalArgumentException("rowIndex and colIndex must be non-negative");
        }
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }

    public static CellPosition of(int rowIndex, int colIndex) {
        return new CellPosition(rowIndex, colIndex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellPosition that = (CellPosition) o;
        return rowIndex == that.rowIndex && colIndex == that.colIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowIndex, colIndex);
    }

    public boolean isRowIndexMoreThanOrEqual(int rowSize) {
        return rowIndex >= rowSize;
    }

    public boolean isColIndexMoreThanOrEqual(int colSize) {
        return colIndex >= colSize;
    }

    public int getRowIndex() {
        return rowIndex;
    }
    public int getColIndex() {
        return colIndex;
    }

    public CellPosition calculatePositionBy(RelativePosition relativePosition) {
        if(this.canCalculatePositionBy(relativePosition)){
            return CellPosition.of(
                    rowIndex + relativePosition.getDeltaRow()
                    , colIndex + relativePosition.getDeltaCol());
        }
        throw new IllegalArgumentException("Cannot calculate position because row index is out of bounds");
    }

    public boolean canCalculatePositionBy(RelativePosition relativePosition) {
        return rowIndex + relativePosition.getDeltaRow() >= 0
                && colIndex + relativePosition.getDeltaCol() >= 0;
    }

    public boolean isRowIndexLessThanOrEqual(int rowIndex) {
        return this.rowIndex < rowIndex;
    }
    public boolean isColIndexLessThanOrEqual(int colIndex) {
        return this.colIndex < colIndex;
    }
}
