package cleancode.studycafe.self.config;

import cleancode.studycafe.self.io.InputHandler;
import cleancode.studycafe.self.io.OutputHandler;
import cleancode.studycafe.self.io.StudyCafeHandler;

public class StudyCafeConfig {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final StudyCafeHandler studyCafeHandler;

    public StudyCafeConfig(InputHandler inputHandler, OutputHandler outputHandler, StudyCafeHandler studyCafeHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.studyCafeHandler = studyCafeHandler;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public OutputHandler getOutputHandler() {
        return outputHandler;
    }

    public StudyCafeHandler getStudyCafeHandler() {
        return studyCafeHandler;
    }
}
