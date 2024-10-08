package cleancode.studycafe.self.io;

import cleancode.studycafe.self.order.Order;
import cleancode.studycafe.self.pass.StudyCafeLockerPass;
import cleancode.studycafe.self.pass.StudyCafePass;

import java.util.List;

public interface OutputHandler {

    void showWelcomeMessage();

    void showAnnouncement();

    void askPassTypeSelection();

    void showPassListForSelection(List<StudyCafePass> passes);

    void askLockerPass(StudyCafeLockerPass lockerPass);

    void showPassOrderSummary(Order order);

    void showSimpleMessage(String message);
}
