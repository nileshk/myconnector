package com.myconnector.client.timesheet;

/** 
 *
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class TimesheetGUI {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        TimesheetWindow timesheetWindow = new TimesheetWindow();
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
