package agenda;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Event {

    /**
     * The myTitle of this event
     */
    private String myTitle;
    
    /**
     * The starting time of the event
     */
    private LocalDateTime myStart;

    /**
     * The durarion of the event 
     */
    private Duration myDuration;


    /**
     * Constructs an event
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     */
    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public boolean isInDay(LocalDate aDay) {
        int duréeMin = (int) getDuration().toMinutes();
        LocalDateTime myEnd = myStart.plus(duréeMin, ChronoUnit.MINUTES);
        LocalDate fin = myEnd.toLocalDate();
        LocalDate début = myStart.toLocalDate();
        if ((aDay.isAfter(début) && aDay.isBefore(fin) || aDay.isEqual(début) || aDay.isEqual(fin))) {
            return true;
        }
        return false;
    }
   
    /**
     * @return the myTitle
     */
    public String getTitle() {
        return myTitle;
    }

    /**
     * @return the myStart
     */
    public LocalDateTime getStart() {
        return myStart;
    }


    /**
     * @return the myDuration
     */
    public Duration getDuration() {
        return myDuration;
    }

    @Override
    public String toString() {
        return "Simple Event{ Titre :" + myTitle + ", Jour de début : " + myStart+ ", Durée : " + myDuration+ "}";
    }
}
