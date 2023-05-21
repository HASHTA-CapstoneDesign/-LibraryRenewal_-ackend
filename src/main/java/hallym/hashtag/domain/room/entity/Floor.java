package hallym.hashtag.domain.room.entity;

public enum Floor {
    floor1("2층 스터디룸"),
    floor2("3층"),
    floor3("4층(디지털스터디룸)"),
    floor4("4층 C.Square"),
    floor5("5층");

    private final String label;

    Floor(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
