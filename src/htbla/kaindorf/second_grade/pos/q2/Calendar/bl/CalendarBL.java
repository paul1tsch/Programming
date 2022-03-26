package htbla.kaindorf.second_grade.pos.q2.Calendar.bl;

import java.time.LocalDate;
import java.util.Random;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        CalendarBL.java
 */

public class CalendarBL {

    private String[] dates, deleteStringArray;
    private boolean wrong = true, appointments;
    private int len;

    public String generateDaysOfMonth(String month) {
        LocalDate date = LocalDate.now();
        int currentYear = date.getYear();

        appointments = false;
        switch (month) {
            case "Jan" -> {
                dates = new String[31];
                for (int i = 0; i < dates.length; i++) {
                    dates[i] = "January " + String.format("%02d", i + 1) + ", " + currentYear + " - ";
                }
                wrong = false;
            }
            case "Feb" -> {
                if ((((currentYear % 100) != 0) && ((currentYear % 4) == 0)) || ((currentYear % 400) == 0)) {
                    dates = new String[29];
                    for (int i = 0; i < dates.length; i++) {
                        dates[i] = "February " + String.format("%02d", i + 1) + ", " + currentYear + " - ";
                    }
                } else {
                    dates = new String[28];
                    for (int i = 0; i < dates.length; i++) {
                        dates[i] = "February " + String.format("%02d", i + 1) + ", " + currentYear + " - ";
                    }
                }
                wrong = false;
            }
            case "Mar" -> {
                dates = new String[31];
                for (int i = 0; i < dates.length; i++) {
                    dates[i] = "March " + String.format("%02d", i + 1) + ", " + currentYear + " - ";
                }
                wrong = false;
            }
            case "Apr" -> {
                dates = new String[30];
                for (int i = 0; i < dates.length; i++) {
                    dates[i] = "April " + String.format("%02d", i + 1) + ", " + currentYear + " - ";
                }
                wrong = false;
            }
            case "May" -> {
                dates = new String[31];
                for (int i = 0; i < dates.length; i++) {
                    dates[i] = "May " + String.format("%02d", i + 1) + ", " + currentYear + " - ";
                }
                wrong = false;
            }
            case "Jun" -> {
                dates = new String[30];
                for (int i = 0; i < dates.length; i++) {
                    dates[i] = "June " + String.format("%02d", i + 1) + ", " + currentYear + " - ";
                }
                wrong = false;
            }
            case "Jul" -> {
                dates = new String[31];
                for (int i = 0; i < dates.length; i++) {
                    dates[i] = "July " + String.format("%02d", i + 1) + ", " + currentYear + " - ";
                }
                wrong = false;
            }
            case "Aug" -> {
                dates = new String[31];
                for (int i = 0; i < dates.length; i++) {
                    dates[i] = "August " + String.format("%02d", i + 1) + ", " + currentYear + " - ";
                }
                wrong = false;
            }
            case "Sep" -> {
                dates = new String[30];
                for (int i = 0; i < dates.length; i++) {
                    dates[i] = "September " + String.format("%02d", i + 1) + ", " + currentYear + " - ";
                }
                wrong = false;
            }
            case "Oct" -> {
                dates = new String[31];
                for (int i = 0; i < dates.length; i++) {
                    dates[i] = "October " + String.format("%02d", i + 1) + ", " + currentYear + " - ";
                }
                wrong = false;
            }
            case "Nov" -> {
                dates = new String[30];
                for (int i = 0; i < dates.length; i++) {
                    dates[i] = "November " + String.format("%02d", i + 1) + ", " + currentYear + " - ";
                }
                wrong = false;
            }
            case "Dec" -> {
                dates = new String[31];
                for (int i = 0; i < dates.length; i++) {
                    dates[i] = "December " + String.format("%02d", i + 1) + ", " + currentYear + " - ";
                }
                wrong = false;
            }
            default -> {
                dates = new String[1];
                dates[0] = "[-] Something went horribly wrong!";
                wrong = true;
            }
        }

        StringBuilder datesString = new StringBuilder();
        len = dates.length;
        for (int i = 0; i < len; i++) {
            datesString.append(dates[i]).append("<br>");
        }

        return datesString.toString();
    }

    public String generateEvents() {
        Random random = new Random();

        String[] eventStrings = {"Programming", "Website", "Learning", ""};
        String[] times = {"00", "15", "30", "45"};
        String[] complete = new String[len];
        StringBuilder completeString = new StringBuilder();
        String time;
        String event;

        int eventLen = eventStrings.length;
        appointments = false;

        if (!wrong) {
            for (int i = 0; i < len; i++) {
                event = eventStrings[random.nextInt(((eventLen - 1)) + 1)];
                if (event.equals("")) {
                    complete[i] = dates[i] + event;
                } else {
                    int rand = 6 + random.nextInt(13);
                    time = String.format("%02d:%s", rand, times[random.nextInt(((times.length - 1)) + 1)]);
                    complete[i] = dates[i] + "<span style='font-style: italic; font-family: Consolas; font-weight: bold;'>" + time + " </span><span style='color: red;'>" + event + "</span>";
                }
                completeString.append(complete[i]).append("<br>");
            }
        } else {
            return "[-] Something went horribly wrong!";
        }

        appointments = true;
        deleteStringArray = complete;
        return completeString.toString();
    }

    public String delEvent(String delete) {
        delete = String.format("%02d", Integer.parseInt(delete));
        int indexOfMinus;
        boolean found = false;

        if (appointments) {
            for (int i = 0; i < len; i++) {
                indexOfMinus = dates[i].indexOf("-");
                for (int j = 0; j < indexOfMinus - 5; j++) {
                    if ((dates[i].substring(j, j + 2)).equals(delete)) {
                        deleteStringArray[i] = deleteStringArray[i].substring(0, indexOfMinus + 1);
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
        } else {
            return "[-] There are no appointments!";
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < len; i++) {
            str.append(deleteStringArray[i]).append("<br>");
        }

        return str.toString();
    }
}
