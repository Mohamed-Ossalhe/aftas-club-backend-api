package ma.youcode.aftasclubbackendapi.entities;

import java.sql.Date;
import java.sql.Time;

public class Competition {
    private int id;
    private String code;
    private Date date;
    private Time startTime;
    private Time endTime;
    private int numberOfParticipants;
    private String location;
    private double amount;
}
