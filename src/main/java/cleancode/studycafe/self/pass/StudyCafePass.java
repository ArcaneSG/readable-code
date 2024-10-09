package cleancode.studycafe.self.pass;

import cleancode.studycafe.self.io.StudyCafeHandler;

import java.util.ArrayList;
import java.util.List;

public class StudyCafePass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;
    private final double discountRate;

    private StudyCafePass(StudyCafePassType passType, int duration, int price, double discountRate) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
        this.discountRate = discountRate;
    }

    public static StudyCafePass of(StudyCafePassType passType, int duration, int price, double discountRate) {
        return new StudyCafePass(passType, duration, price, discountRate);
    }

    public static List<StudyCafePass> ofHandler(StudyCafeHandler studyCafeHandler, StudyCafePassType passType) {

        List<String> lines = studyCafeHandler.getStudyCafePass();

        List<StudyCafePass> passes = new ArrayList<>();

        for (String line : lines) {
            String[] values = line.split(",");

            StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
            int duration = Integer.parseInt(values[1]);
            int price = Integer.parseInt(values[2]);
            double discountRate = Double.parseDouble(values[3]);

            if (passType == studyCafePassType) {
                StudyCafePass studyCafePass = StudyCafePass.of(studyCafePassType, duration, price, discountRate);
                passes.add(studyCafePass);
            }
        }
        return passes;
    }

    public StudyCafePassType getPassType() {
        return passType;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public String toDisplayString() {
        return String.format("%s%s - %d원", duration, passType.toString(),price);
    }

    public boolean isExistsLocker(StudyCafePassType studyCafePassType, int duration) {
        return this.passType == studyCafePassType && this.duration == duration;
    }
}
