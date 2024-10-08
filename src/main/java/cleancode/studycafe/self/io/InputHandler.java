package cleancode.studycafe.self.io;

import cleancode.studycafe.self.pass.StudyCafePass;
import cleancode.studycafe.self.pass.StudyCafePassType;

import java.util.List;

public interface InputHandler {
    StudyCafePassType getPassTypeSelectingUserAction();

    StudyCafePass getSelectPass(List<StudyCafePass> passes);

    boolean getLockerSelection();
}

