package cleancode.minesweeper.tobe.cell;

public class CellSnapshot {
    private final CellSnapShotStatus status;
    private final int nearbyLandMineCount;

    private CellSnapshot(CellSnapShotStatus status, int nearbyLandMineCount) {
        this.status = status;
        this.nearbyLandMineCount = nearbyLandMineCount;
    }

    public static CellSnapshot of(CellSnapShotStatus status, int nearbyLandMineCount) {
        return new CellSnapshot(status, nearbyLandMineCount);
    }

    public static CellSnapshot ofEmpty() {
        return of(CellSnapShotStatus.EMPTY, 0);
    }

    public static CellSnapshot ofFlag() {
        return of(CellSnapShotStatus.FLAG, 0);
    }

    public static CellSnapshot ofLandMine() {
        return of(CellSnapShotStatus.LAND_MINE, 0);
    }

    public static CellSnapshot ofNumber(int nearbyLandMineCount) {
        return of(CellSnapShotStatus.NUMBER, nearbyLandMineCount);
    }

    public static CellSnapshot ofUnchecked() {
        return of(CellSnapShotStatus.UNCHECKED, 0);
    }

    public CellSnapShotStatus getStatus() {
        return status;
    }

    public int getNearbyLandMineCount() {
        return nearbyLandMineCount;
    }

    public boolean isSameStatus(CellSnapShotStatus cellSnapShotStatus) {
        return status == cellSnapShotStatus;
    }
}
