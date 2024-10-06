package cleancode.minesweeper.tobe.io.sign;

import cleancode.minesweeper.tobe.cell.CellSnapshot;

import java.util.List;

public class CellSignFinder {

    public static final List<CellSignProvidable> CELL_SIGN_PROVIDER = List.of(
            new EmptyCellSignProvider(),
            new FlagCellSignProvider(),
            new NumberCellSignProvider(),
            new LandMineCellSignProvider(),
            new UncheckedCellSignProvider()
    );

    public String findCellSignFrom(CellSnapshot snapshot) {

        return CELL_SIGN_PROVIDER.stream()
                .filter(provider -> provider.supports(snapshot))
                .findFirst()
                .map(provider -> provider.provide(snapshot))
                .orElseThrow(() ->new IllegalStateException("Unexpected cell snapshot status " + snapshot.getStatus()));
    }

}
