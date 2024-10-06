package cleancode.minesweeper.tobe.io.sign;

import cleancode.minesweeper.tobe.cell.CellSnapShotStatus;
import cleancode.minesweeper.tobe.cell.CellSnapshot;

public class UncheckedCellSignProvider implements CellSignProvidable {

    private static final String UNCHECKED_SIGN = "□";

    @Override
    public boolean supports(CellSnapshot snapshot) {
        if (snapshot == null) return false;
        return snapshot.isSameStatus(CellSnapShotStatus.UNCHECKED);
    }

    @Override
    public String provide(CellSnapshot cellSnapshot) {
        return UNCHECKED_SIGN;
    }
}
