package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import chap07.event.Event;
import chap07.event.EventType;
import javax.servlet.http.HttpServletRequest;

import chap07.event.SearchOption;
import service.EventService;

@Controller
@RequestMapping("/event")
public class EventController
{
    private static final String REDIRECT_EVENT_LIST = "redirect:/event/list";
    @Autowired
    private EventService eventService;
    
    public EventController()
    {
        eventService = new EventService();
    }
    
    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyyMMdd"),true);
        binder.registerCustomEditor(Date.class, dateEditor);
    }
    
    @ModelAttribute("recEventList")
    public List<Event> recommend()
    {
        return eventService.getRecommendedEventService();
    }
    @RequestMapping("/list")
    public String list(SearchOption option, Model model)
    {
        List<Event> eventList = eventService.getOpenedEventList(option);
        model.addAttribute("eventList", eventList);
        model.addAttribute("eventTypes", EventType.values());
        return "event/list";
    }
    
    @RequestMapping("/list2")
    public ModelAndView list2(SearchOption option)
    {
        List<Event> eventList = eventService.getOpenedEventList(option);
        ModelAndView modelview = new ModelAndView();
        modelview.setViewName("event/list");
        modelview.addObject("eventList", eventList);
        modelview.addObject("eventTypes", EventType.values());
        return modelview;
    }
    
    
    
    @RequestMapping("/detail")
    public String detail(HttpServletRequest request, Model model) throws IOException
    {
        String id = request.getParameter("id");
        if (id == null) 
            return REDIRECT_EVENT_LIST;
        Long eventId = null;
        try
        {
            eventId = Long.parseLong(id);
        }
        catch (NumberFormatException e)
        {
            return REDIRECT_EVENT_LIST;
        }
        Event event = getEvent(eventId);
        if (event == null) 
            return REDIRECT_EVENT_LIST;
        
        model.addAttribute("event", event);
        return "event/detail";
    }
    
    private Event getEvent(Long eventId)
    {
        return eventService.getEvent(eventId);
    }
    
    @RequestMapping("/detail2")
    //public String detail2(@RequestParam(value="id",defaultValue="1") long eventId, Model model)
    public String detail2(@RequestParam(value="id" ,required = false) long eventId, Model model)
    {
        Event event = getEvent(eventId);
        if (event == null) return REDIRECT_EVENT_LIST;
        model.addAttribute("event", event);
        return "event/detail";
    }
    
}
