package cleancode.minesweeper.tobe.io.sign;

import cleancode.minesweeper.tobe.cell.CellSnapShotStatus;
import cleancode.minesweeper.tobe.cell.CellSnapshot;


public class EmptyCellSignProvider implements CellSignProvidable {

    private static final String EMPTY_SIGN = "■";

    @Override
    public boolean supports(CellSnapshot snapshot) {
        if (snapshot == null) return false;
        return snapshot.isSameStatus(CellSnapShotStatus.EMPTY);
    }

    @Override
    public String provide(CellSnapshot cellSnapshot) {
        return EMPTY_SIGN;
    }
}
