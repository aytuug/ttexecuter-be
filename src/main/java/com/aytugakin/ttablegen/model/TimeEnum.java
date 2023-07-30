package com.aytugakin.ttablegen.model;

public enum TimeEnum {

    MON912("MONDAY 9:00 - 11:00"),
    MON1012("MONDAY 10:00 - 12:00"),
    MON1315("MONDAY 13:00 - 15:00"),
    MON1316("MONDAY 13:00 - 16:00"),
    MON1417("MONDAY 14:00 - 17:00"),
    MON1418("MONDAY 14:00 - 18:00"),
    MON1518("MONDAY 15:00 - 18:00"),

    TUE912("TUESDAY 9:00 - 11:00"),
    TUE1012("TUESDAY 10:00 - 12:00"),
    TUE1315("TUESDAY 13:00 - 15:00"),
    TUE1316("TUESDAY 13:00 - 16:00"),
    TUE1417("TUESDAY 14:00 - 17:00"),
    TUE1418("TUESDAY 14:00 - 18:00"),
    TUE1518("TUESDAY 15:00 - 18:00"),

    WED912("WEDNESDAY 9:00 - 11:00"),
    WED1012("WEDNESDAY 10:00 - 12:00"),
    WED1315("WEDNESDAY 13:00 - 15:00"),
    WED1316("WEDNESDAY 13:00 - 16:00"),
    WED1417("WEDNESDAY 14:00 - 17:00"),
    WED1418("WEDNESDAY 14:00 - 18:00"),
    WED1518("WEDNESDAY 15:00 - 18:00"),

    THU912("THURSDAY 9:00 - 11:00"),
    THU1012("THURSDAY 10:00 - 12:00"),
    THU1315("THURSDAY 13:00 - 15:00"),
    THU1316("THURSDAY 13:00 - 16:00"),
    THU1417("THURSDAY 14:00 - 17:00"),
    THU1418("THURSDAY 14:00 - 18:00"),
    THU1518("THURSDAY 15:00 - 18:00"),

    FRI912("FRIDAY 9:00 - 11:00"),
    FRI1012("FRIDAY 10:00 - 12:00"),
    FRI1315("FRIDAY 13:00 - 15:00"),
    FRI1316("FRIDAY 13:00 - 16:00"),
    FRI1417("FRIDAY 14:00 - 17:00"),
    FRI1418("FRIDAY 14:00 - 18:00"),
    FRI1518("FRIDAY 15:00 - 18:00");

    private final String value;
    TimeEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
