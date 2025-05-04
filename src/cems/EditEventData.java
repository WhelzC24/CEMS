/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cems;

import java.util.Date;

/**
 *
 * @author whelz
 */
public class EditEventData {
    private int eventNo;
    private String title;
    private String type;
    private String location;
    private Date dateStart;
    private Date timeStart;
    private Date dateEnd;
    private Date timeEnd;

    public EditEventData(int eventNo, String title, String type, String location,
                         Date dateStart, Date timeStart, Date dateEnd, Date timeEnd) {
        this.eventNo = eventNo;
        this.title = title;
        this.type = type;
        this.location = location;
        this.dateStart = dateStart;
        this.timeStart = timeStart;
        this.dateEnd = dateEnd;
        this.timeEnd = timeEnd;
    }

    // Getters
    public int getEventNo() { return eventNo; }
    public String getTitle() { return title; }
    public String getType() { return type; }
    public String getLocation() { return location; }
    public Date getDateStart() { return dateStart; }
    public Date getTimeStart() { return timeStart; }
    public Date getDateEnd() { return dateEnd; }
    public Date getTimeEnd() { return timeEnd; }
}
