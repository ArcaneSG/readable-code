package cleancode.studycafe.self.pass;

import cleancode.studycafe.self.io.StudyCafeHandler;

import java.util.List;

public class StudyCafeLockerPass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;

    private StudyCafeLockerPass(StudyCafePassType passType, int duration, int price) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
    }

    public static StudyCafeLockerPass of(StudyCafePassType passType, int duration, int price) {
        return new StudyCafeLockerPass(passType, duration, price);
    }

    public static StudyCafeLockerPass ofHandler(StudyCafeHandler studyCafeHandler, StudyCafePass studyCafePass) {

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

    public StudyCafePassType getPassType() {
        return passType;
    }

    public int getPrice() {
        return price;
    }

    public String toDisplayString() {
        return String.format("%s%s - %d원", duration, passType.toString(),price);
    }

    public boolean isExistsLocker() {
        return passType != StudyCafePassType.UNKNOWN;
    }

}
