package com.myconnector.web;

import java.util.Date;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class TimesheetFilterCommand {

    private Date dateFilter;

    private Date weekFilter;

    private Integer monthFilter;

    public Date getDateFilter() {
        return dateFilter;
    }

    public void setDateFilter(Date dateFilter) {
        this.dateFilter = dateFilter;
    }

    public Integer getMonthFilter() {
        return monthFilter;
    }

    public void setMonthFilter(Integer monthFilter) {
        this.monthFilter = monthFilter;
    }

    public Date getWeekFilter() {
        return weekFilter;
    }

    public void setWeekFilter(Date weekFilter) {
        this.weekFilter = weekFilter;
    }
}
