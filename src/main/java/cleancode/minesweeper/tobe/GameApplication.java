package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.minesweeper.MineSweeper;
import cleancode.minesweeper.tobe.minesweeper.config.GameConfig;
import cleancode.minesweeper.tobe.minesweeper.gamelevel.Advanced;
import cleancode.minesweeper.tobe.minesweeper.gamelevel.Beginner;
import cleancode.minesweeper.tobe.minesweeper.io.ConsoleInputHandler;
import cleancode.minesweeper.tobe.minesweeper.io.ConsoleOutputHandler;

public class GameApplication {

    public static void main(String[] args) {

        GameConfig gameConfig = new GameConfig(
                new Advanced()
                , new ConsoleInputHandler()
                , new ConsoleOutputHandler()
        );

        MineSweeper ms = new MineSweeper(gameConfig);
        ms.initialize();
        ms.run();
    }

    /*
    *
    * DIP (Dependency Inversion Principle
    * 고수준 모듈과 저수준 모듈은 추상화(인터페이스)를 통해 연결 되어야 한다.
    * DI (Dependency injection) - 3?
    * 의존성 주입
    * 필요한 의존성을 외부에 주입 받겠다.
    * IOC (Inversion of Control)
    * 제어의 순방향 -> 프로그램은 개발자가 만듬, 개발자가 제어
    * 제어의 역전 -> 내가 만든 프로그램이 프레임워크내에서 내 코드가 제어되어 돌아간다.
    * */
}
