package seclass.qc.edu.glm;

import java.util.*;

public class Reminder {

    private String type;
    private String name;
    private boolean checkOff;

    private Alert alert;


    public Reminder() { }

    public Reminder(String t, String n, String d, String tm) {
        type = t;
        name = n;
        checkOff = false;

        alert = new Alert(d, tm);
    }

    public String getType() {
        return type;
    }

    public void setType(String t) {
        type = t;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

}
