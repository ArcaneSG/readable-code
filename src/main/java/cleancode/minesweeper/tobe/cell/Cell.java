package cleancode.minesweeper.tobe.cell;

public abstract class Cell {

    protected static final String FLAG_SIGN = "⚑";
    protected static final String UNCHECKED_SIGN = "□";

    protected boolean isFlagged;
    protected boolean isOpened;

    public void flag() {
        this.isFlagged = true;
    }

    public boolean isChecked() {
        return isFlagged || isOpened;
    }

    public void open() {
        this.isOpened = true;
    }

    public boolean isOpened() {
        return this.isOpened;
    }

    public abstract boolean isLandMine();

    public abstract boolean hasLandMineCount();

    public abstract String getSign();
}
