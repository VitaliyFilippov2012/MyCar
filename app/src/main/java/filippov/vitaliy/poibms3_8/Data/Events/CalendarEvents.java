package filippov.vitaliy.poibms3_8.Data.Events;


import android.util.Log;

import java.util.ArrayList;

import filippov.vitaliy.poibms3_8.Base.Constants;
import filippov.vitaliy.poibms3_8.Base.File.WorkWithFile;
import filippov.vitaliy.poibms3_8.Base.File.WorkWithXML;

public class CalendarEvents {

    private static ArrayList<Event> events;
    static {
        events = new ArrayList<Event>();
        events.add(new Event("Fuel", 45.6f, 1300000, "", "23.02.2000", "Дизель", 45));
        events.add(new Event("Fuel", 15.6f, 1300000, "", "13.02.2010", "Дизель", 15));
        events.add(new Event("Fuel", 85.6f, 1300000, "", "23.12.2012", "Дизель", 75));
        events.add(new Event("Fuel", 95.6f, 1300000, "", "16.02.2001", "Дизель", 65));
        events.add(new Event("Fuel", 235.6f, 1300000, "", "5.02.2003", "Дизель", 105));
        events.add(new Event("Service", "TO",235.6f, 1300000, "", "5.02.2003", 100));
        events.add(new Event("Wash", "",235.6f, 1310000, "", "5.02.2003",10));
        events.add(new Event("Service", "Шины",235.6f, 1320000, "", "5.02.2003", 150));
        events.add(new Event("Wash","" ,235.6f, 1330000, "", "5.02.2003", 15));
        synchronizedEventsWithFile();
        events.clear();
        loadFromFile();
        Log.d("MyEvent", "Static block");
    }

    public static ArrayList<Event> getEvents(){
        return events;
    }

    public static ArrayList<Event> getEventByDate(String dateWithFormatYYYYMMDD){
        ArrayList<Event> dateEvents = new ArrayList<>();
        for(Event e:events){
            if(e.getDateEvent().equals(dateWithFormatYYYYMMDD)){
                dateEvents.add(e);
            }
        }
        return dateEvents;
    }

    public static ArrayList<Event> getEventByCategory(String category){
        ArrayList<Event> categoryEvents = new ArrayList<>();
        for(Event e:events){
            if(e.getNameEvent().equals(category)){
                categoryEvents.add(e);
            }
        }
        return categoryEvents;
    }

    public static boolean addEvent(Event event,boolean sync){
        events.add(event);
        Log.d("MyEvent","Add new event");
        if(sync)
            task.run();
        return true;
    }

    private static Event checkSameEventWithThisDate(Event e){
        for(Event e1:events){
            if(e.compareEvent(e1)){
                return e1;
            }
        }
        return null;
    }

    public static boolean removeEvent(Event event){
        Event existsEvent = checkSameEventWithThisDate(event);
        if(existsEvent!=null){
            events.remove(existsEvent);
            task.run();
            Log.d("MyEvent","Remove event");
            return true;
        }
        return false;
    }

    public static void clear(){
        events.clear();
        task.run();
    }

    private static boolean changeEvent(Event oldEvent, Event newEvent){
        if(events.contains(oldEvent)){
            events.remove(oldEvent);
            events.add(newEvent);
            task.run();
            Log.d("MyEvent","Change event");
            return true;
        }
        return false;
    }

    private static Runnable task = new Runnable() {
        @Override
        public void run() {
            synchronizedEventsWithFile();
        }
    };

    private static void synchronizedEventsWithFile(){
        WorkWithFile wfS = new WorkWithFile(Constants.EVENTS);
        wfS.createFile(true);
        WorkWithXML xml = new WorkWithXML(wfS);
        xml.serializeToXMLDocument(Category.getCategoryNames(),CalendarEvents.getEvents());
        Log.d("MyEvent","synchronized");
    }

    private static void loadFromFile(){
        WorkWithFile wfS = new WorkWithFile(Constants.EVENTS);
        WorkWithXML xml = new WorkWithXML(wfS);
        xml.deserialize();
        Log.d("MyEvent","loadFromFile");
    }

    @Override
    public String toString(){
        return "\nCount events: " + events.size();
    }
}