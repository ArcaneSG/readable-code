package cleancode.minesweeper.tobe.io.sign;

import cleancode.minesweeper.tobe.cell.CellSnapShotStatus;
import cleancode.minesweeper.tobe.cell.CellSnapshot;

public class FlagCellSignProvider implements CellSignProvidable {
    private static final String FLAG_SIGN = "⚑";

    @Override
    public boolean supports(CellSnapshot snapshot) {
        if (snapshot == null) return false;
        return snapshot.isSameStatus(CellSnapShotStatus.FLAG);
    }

    @Override
    public String provide(CellSnapshot cellSnapshot) {
        return FLAG_SIGN;
    }
}
