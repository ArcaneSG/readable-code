package cleancode.studycafe.self.order;

import cleancode.studycafe.self.pass.StudyCafeLockerPass;
import cleancode.studycafe.self.pass.StudyCafePass;

public class Order {

    private final StudyCafePass studyCafePass;
    private final StudyCafeLockerPass studyCafeLockerPass;

    private Order(StudyCafePass studyCafePass, StudyCafeLockerPass studyCafeLockerPass) {
        this.studyCafePass = studyCafePass;
        this.studyCafeLockerPass = studyCafeLockerPass;
    }

    public static Order of(StudyCafePass studyCafePass, StudyCafeLockerPass studyCafeLockerPass) {
        return new Order(studyCafePass, studyCafeLockerPass);
    }

    public void showSummary() {
        System.out.println();
        System.out.println("이용 내역");
        System.out.println("이용권: " + studyCafePass.display());
        if (studyCafeLockerPass.isExistsLocker()) {
            System.out.println("사물함: " + studyCafeLockerPass.display());
        }

        double discountRate = studyCafePass.getDiscountRate();
        int discountPrice = (int) (studyCafePass.getPrice() * discountRate);
        if (discountPrice > 0) {
            System.out.println("이벤트 할인 금액: " + discountPrice + "원");
        }

        int totalPrice = studyCafePass.getPrice() - discountPrice + (studyCafeLockerPass.isExistsLocker() ? studyCafeLockerPass.getPrice() : 0);
        System.out.println("총 결제 금액: " + totalPrice + "원");
        System.out.println();
    }
}
