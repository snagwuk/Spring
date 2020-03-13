package chap07.event;

public class Event
{
    private long id;
    private String name;
    private EventType type;
    public long getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public EventType getType()
    {
        return type;
    }
    public static Event create(Long id , String name , EventType type)
    {
        Event result = new Event();
        result.id = id;
        result.name = name;
        result.type= type;
        return result;
    }
}
