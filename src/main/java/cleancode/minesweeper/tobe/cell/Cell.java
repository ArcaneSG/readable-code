package cleancode.minesweeper.tobe.cell;

public interface Cell {


    void flag();

    boolean isChecked();

    void open();

    boolean isOpened();

    boolean isLandMine();

    boolean hasLandMineCount();

    CellSnapshot getSnapshot();
}
