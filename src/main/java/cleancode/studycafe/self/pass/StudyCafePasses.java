package cleancode.studycafe.self.pass;

import cleancode.studycafe.self.io.StudyCafeHandler;

import java.util.ArrayList;
import java.util.List;

public class StudyCafePasses {

    private final StudyCafeHandler studyCafeHandler;

    public StudyCafePasses(StudyCafeHandler studyCafeHandler) {
        this.studyCafeHandler = studyCafeHandler;
    }

    public List<StudyCafePass> getStudyCafePassesAt(StudyCafePassType passType) {
        List<String> lines = studyCafeHandler.getStudyCafePass();

        List<StudyCafePass> studyCafePasses = new ArrayList<>();

        for (String line : lines) {
            String[] values = line.split(",");

            StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
            int duration = Integer.parseInt(values[1]);
            int price = Integer.parseInt(values[2]);
            double discountRate = Double.parseDouble(values[3]);

            if (passType == studyCafePassType) {
                StudyCafePass studyCafePass = StudyCafePass.of(studyCafePassType, duration, price, discountRate);
                studyCafePasses.add(studyCafePass);
            }
        }

        return studyCafePasses;
    }

    public StudyCafeLockerPass getStudyCafeLockerPassesAt(StudyCafePass studyCafePass) {

        List<String> lines = studyCafeHandler.getStudyCafeLockerPass();

        for (String line : lines) {
            String[] values = line.split(",");
            StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
            int duration = Integer.parseInt(values[1]);
            int price = Integer.parseInt(values[2]);

            if (studyCafePass.isExistsLocker(studyCafePassType, duration)) {
                return StudyCafeLockerPass.of(studyCafePassType, duration, price);
            }
        }

        return StudyCafeLockerPass.of(StudyCafePassType.UNKNOWN, 0, 0);

    }
}
