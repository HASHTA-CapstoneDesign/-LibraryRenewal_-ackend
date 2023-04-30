package hallym.hashtag.domain.roomRes.entity;

public enum UseTime {
    time1("09:00-10:00"),
    time2("10:00-11:00"),
    time3("11:00-12:00"),
    time4("12:00-13:00"),
    time5("13:00-14:00"),
    time6("14:00-15:00"),
    time7("15:00-16:00"),
    time8("16:00-17:00"),
    time9("17:00-18:00"),
    time10("18:00-19:00"),
    time11("19:00-20:00"),
    time12("20:00-21:00"),
    time13("21:00-22:00");

    private final String useTime;

    private UseTime(String useTime) {
        this.useTime = useTime;
    }

    public String getUseTime() {
        return useTime;
    }
}
