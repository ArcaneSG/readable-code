package cleancode.minesweeper.tobe.minesweeper.io;

import cleancode.minesweeper.tobe.minesweeper.board.position.CellPosition;
import cleancode.minesweeper.tobe.minesweeper.user.UserAction;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {
    public static final Scanner SCANNER = new Scanner(System.in);

    private final BoardIndexConverter boardIndexConverter = new BoardIndexConverter();

    @Override
    public String getUserInput() {
        return SCANNER.nextLine();
    }

    @Override
    public CellPosition getCellPositionFromUser() {
        String input = SCANNER.nextLine();

        int rowIndex = boardIndexConverter.getSelectedRowIndex(input);
        int colIndex = boardIndexConverter.getSelectedColIndex(input);

        return CellPosition.of(rowIndex, colIndex);
    }

    @Override
    public UserAction getUserActionFromUser() {
        String input = SCANNER.nextLine();

        if ("1".equals(input)) {
            return UserAction.OPEN;
        }
        if ("2".equals(input)) {
            return UserAction.FLAG;
        }

        return UserAction.UNKNOWN;
    }
}

