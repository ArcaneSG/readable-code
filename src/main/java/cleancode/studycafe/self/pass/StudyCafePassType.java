package cleancode.studycafe.self.pass;

public enum StudyCafePassType {

    HOURLY("시간 단위 이용권"){
        @Override
        public String toString() {
            return "시간권";
        }
    },
    WEEKLY("주 단위 이용권"){
        @Override
        public String toString() {
            return "주권";
        }
    },
    FIXED("1인 고정석"){
        @Override
        public String toString() {
            return "주권";
        }
    },
    UNKNOWN("없음"){
        @Override
        public String toString() {
            return "";
        }
    },
    ;

    private final String description;

    StudyCafePassType(String description) {
        this.description = description;
    }
}
