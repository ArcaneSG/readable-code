package cleancode.studycafe.self.io;

import cleancode.studycafe.self.pass.StudyCafeLockerPass;
import cleancode.studycafe.self.pass.StudyCafePass;
import cleancode.studycafe.self.pass.StudyCafePassType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudyCafeFileHandler implements StudyCafeHandler {

    @Override
    public List<String> getStudyCafePass() {
        try {

            return Files.readAllLines(Paths.get("src/main/resources/cleancode/studycafe/pass-list.csv"));

        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

    @Override
    public List<String> getStudyCafeLockerPass() {
        try {

            return Files.readAllLines(Paths.get("src/main/resources/cleancode/studycafe/locker.csv"));

        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

}
