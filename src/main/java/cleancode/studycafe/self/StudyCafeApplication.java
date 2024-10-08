package cleancode.studycafe.self;

import cleancode.studycafe.self.config.StudyCafeConfig;
import cleancode.studycafe.self.io.ConsoleInputHandler;
import cleancode.studycafe.self.io.ConsoleOutputHandler;
import cleancode.studycafe.self.io.StudyCafeFileHandler;

public class StudyCafeApplication {

    public static void main(String[] args) {

        StudyCafeConfig studyCafeConfig = new StudyCafeConfig(
            new ConsoleInputHandler()
            ,new ConsoleOutputHandler()
            ,new StudyCafeFileHandler()
        );

        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(studyCafeConfig);
        studyCafePassMachine.run();
    }

}
