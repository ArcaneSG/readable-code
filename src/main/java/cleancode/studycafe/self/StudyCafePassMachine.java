package cleancode.studycafe.self;

import cleancode.studycafe.self.config.StudyCafeConfig;
import cleancode.studycafe.self.exception.AppException;
import cleancode.studycafe.self.io.InputHandler;
import cleancode.studycafe.self.io.OutputHandler;
import cleancode.studycafe.self.io.StudyCafeHandler;
import cleancode.studycafe.self.order.Order;
import cleancode.studycafe.self.pass.StudyCafeLockerPass;
import cleancode.studycafe.self.pass.StudyCafePass;
import cleancode.studycafe.self.pass.StudyCafePassType;
import cleancode.studycafe.self.pass.StudyCafePasses;

import java.util.List;

public class StudyCafePassMachine {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final StudyCafeHandler studyCafeHandler;

    private final StudyCafePasses studyCafePasses;

    public StudyCafePassMachine(StudyCafeConfig studyCafeConfig) {
        this.inputHandler = studyCafeConfig.getInputHandler();
        this.outputHandler = studyCafeConfig.getOutputHandler();
        this.studyCafeHandler = studyCafeConfig.getStudyCafeHandler();
        this.studyCafePasses = new StudyCafePasses(studyCafeHandler);
    }

    public void run() {
        try {

            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();
            outputHandler.askPassTypeSelection();

            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();

            List<StudyCafePass> studyCafePassList = studyCafePasses.getStudyCafePassesAt(studyCafePassType);

            outputHandler.showPassListForSelection(studyCafePassList);
            StudyCafePass selectedPass = inputHandler.getSelectPass(studyCafePassList);

            StudyCafeLockerPass studyCafeLockerPass = getStudyCafeLockerPass(selectedPass);

            Order order = Order.of(selectedPass, studyCafeLockerPass);
            order.showSummary();

        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private StudyCafeLockerPass getStudyCafeLockerPass(StudyCafePass selectedPass) {
        StudyCafeLockerPass studyCafeLockerPass = studyCafePasses.getStudyCafeLockerPassesAt(selectedPass);
        if(studyCafeLockerPass.isExistsLocker()) {
            outputHandler.askLockerPass(studyCafeLockerPass);
            if(!inputHandler.getLockerSelection()){
                studyCafeLockerPass = null;
            }
        }
        return studyCafeLockerPass;
    }
}
