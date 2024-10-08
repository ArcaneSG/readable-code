package cleancode.studycafe.self.io;

import cleancode.studycafe.self.pass.StudyCafeLockerPass;
import cleancode.studycafe.self.pass.StudyCafePass;
import cleancode.studycafe.self.pass.StudyCafePassType;

import java.util.List;

public interface StudyCafeHandler {
    List<String> getStudyCafePass();
    List<String> getStudyCafeLockerPass();
}
