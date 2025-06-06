/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cems;

import java.awt.Font;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author PC
 */
public class editEvent extends javax.swing.JFrame {
    
    private EditEventData data;  // This will hold the event data including eventNo
    private int eventNo;  // Store eventNo for the update
    
    /**
     * Creates new form CreateEvent
     */
    public editEvent(JFrame parent, EditEventData data) {
        initComponents();
        cems.GlobalMemoryManager.registerFrame(this);
        
        FontLoader.applyFontToLabel(jLabel5, "/fonts/ReemKufi-Regular.ttf", 16f, Font.BOLD, false);
        FontLoader.applyFontToLabel(jLabel6, "/fonts/ReemKufi-Regular.ttf", 16f, Font.BOLD, false);
        FontLoader.applyFontToLabel(jLabel10, "/fonts/ReemKufi-Regular.ttf", 16f, Font.BOLD, false);
        FontLoader.applyFontToLabel(jLabel11, "/fonts/ReemKufi-Regular.ttf", 16f, Font.BOLD ,false);
        FontLoader.applyFontToLabel(jLabel12, "/fonts/ReemKufi-Regular.ttf", 16f, Font.BOLD, false);
        FontLoader.applyFontToLabel(jLabel13, "/fonts/ReemKufi-Regular.ttf", 16f, Font.BOLD, false);
        FontLoader.applyFontToLabel(jLabel14, "/fonts/ReemKufi-Regular.ttf", 16f, Font.BOLD, false);
        
        FontLoader.applyFontToButton(update, "/fonts/ReemKufi-Regular.ttf", 12f, Font.BOLD);
        FontLoader.applyFontToButton(cancel, "/fonts/ReemKufi-Regular.ttf", 12f, Font.BOLD);
        
        timeStartSpinner.setModel(new SpinnerDateModel());
        JSpinner.DateEditor startEditor = new JSpinner.DateEditor(timeStartSpinner, "hh:mm a");
        timeStartSpinner.setEditor(startEditor);
        timeStartSpinner.setValue(new Date());

        timeEndSpinner.setModel(new SpinnerDateModel());
        JSpinner.DateEditor endEditor = new JSpinner.DateEditor(timeEndSpinner, "hh:mm a");
        timeEndSpinner.setEditor(endEditor);
        timeEndSpinner.setValue(new Date());
        
        this.data = data;
        this.eventNo = data.getEventNo();  // Get eventNo from the passed data
        populateFormWithData();
        setLocationRelativeTo(parent);  // Center the form relative to the parent
    }
    
    private void populateFormWithData() {
        // Populate form fields with the data from EditEventData
        titleTextField.setText(data.getTitle());
        eventTypeComboBox.setSelectedItem(data.getType());
        locationTextField.setText(data.getLocation());
        dateStartChooser.setDate(data.getDateStart());
        timeStartSpinner.setValue(data.getTimeStart());
        dateEndChooser.setDate(data.getDateEnd());
        timeEndSpinner.setValue(data.getTimeEnd());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DBlue_panel1 = new javax.swing.JPanel();
        DBlue_panel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        event_table = new javax.swing.JTable();
        organizer_new = new javax.swing.JButton();
        organizer_edit = new javax.swing.JButton();
        organizer_delete = new javax.swing.JButton();
        organzier_viewstudents = new javax.swing.JButton();
        organizer_poster = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        DBlue_panel = new javax.swing.JPanel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel5 = new javax.swing.JLabel();
        titleTextField = new org.edisoncor.gui.textField.TextField();
        jLabel6 = new javax.swing.JLabel();
        eventTypeComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        locationTextField = new org.edisoncor.gui.textField.TextField();
        jLabel11 = new javax.swing.JLabel();
        dateStartChooser = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        timeStartSpinner = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        dateEndChooser = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        timeEndSpinner = new javax.swing.JSpinner();
        cancel = new com.k33ptoo.components.KButton();
        update = new com.k33ptoo.components.KButton();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        DBlue_panel1.setBackground(new java.awt.Color(98, 98, 130));

        DBlue_panel2.setBackground(new java.awt.Color(0, 0, 51));

        javax.swing.GroupLayout DBlue_panel2Layout = new javax.swing.GroupLayout(DBlue_panel2);
        DBlue_panel2.setLayout(DBlue_panel2Layout);
        DBlue_panel2Layout.setHorizontalGroup(
            DBlue_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
        );
        DBlue_panel2Layout.setVerticalGroup(
            DBlue_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        event_table.setAutoCreateRowSorter(true);
        event_table.setBackground(new java.awt.Color(20, 20, 20));
        event_table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        event_table.setForeground(new java.awt.Color(255, 255, 255));
        event_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Events", "Event type", "Location", "Date & Time: Begin/End", "Participants"
            }
        ));
        event_table.setFocusable(false);
        jScrollPane1.setViewportView(event_table);

        organizer_new.setBackground(new java.awt.Color(37, 55, 30));
        organizer_new.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        organizer_new.setForeground(new java.awt.Color(255, 255, 255));
        organizer_new.setText("Create new event");
        organizer_new.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        organizer_edit.setBackground(new java.awt.Color(37, 55, 30));
        organizer_edit.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        organizer_edit.setForeground(new java.awt.Color(255, 255, 255));
        organizer_edit.setText("Edit event");
        organizer_edit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        organizer_delete.setBackground(new java.awt.Color(37, 55, 30));
        organizer_delete.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        organizer_delete.setForeground(new java.awt.Color(255, 255, 255));
        organizer_delete.setText("Delete event");
        organizer_delete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        organzier_viewstudents.setBackground(new java.awt.Color(102, 51, 0));
        organzier_viewstudents.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        organzier_viewstudents.setForeground(new java.awt.Color(255, 255, 255));
        organzier_viewstudents.setText("View registered students");
        organzier_viewstudents.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        organizer_poster.setBackground(new java.awt.Color(102, 0, 51));
        organizer_poster.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        organizer_poster.setForeground(new java.awt.Color(255, 255, 255));
        organizer_poster.setText("Upload poster");
        organizer_poster.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout DBlue_panel1Layout = new javax.swing.GroupLayout(DBlue_panel1);
        DBlue_panel1.setLayout(DBlue_panel1Layout);
        DBlue_panel1Layout.setHorizontalGroup(
            DBlue_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DBlue_panel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(DBlue_panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DBlue_panel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(DBlue_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DBlue_panel1Layout.createSequentialGroup()
                        .addGroup(DBlue_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(organizer_new, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(organizer_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(organizer_delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(organizer_poster, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(organzier_viewstudents, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DBlue_panel1Layout.setVerticalGroup(
            DBlue_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DBlue_panel1Layout.createSequentialGroup()
                .addGroup(DBlue_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DBlue_panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DBlue_panel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(organizer_new)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(organizer_edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(organizer_delete)
                        .addGap(63, 63, 63)
                        .addComponent(organizer_poster)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(organzier_viewstudents)
                .addGap(18, 18, 18)
                .addComponent(DBlue_panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        DBlue_panel.setBackground(new java.awt.Color(0, 0, 51));

        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(51, 102, 255));
        kGradientPanel1.setkGradientFocus(0);
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 0, 51));

        jLabel5.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Event Title:");

        titleTextField.setBackground(new java.awt.Color(0, 0, 51));
        titleTextField.setForeground(new java.awt.Color(255, 255, 255));
        titleTextField.setBorde(0.0F);

        jLabel6.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Event Type:");

        eventTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select Event Type --", "App Launch", "Art Exhibit", "Author Talk", "Awareness Campaign", "Blood Donation Drive", "Book Fair", "Career Talk", "Charity Event", "Clean-Up Drive", "Club Meeting", "Coding Competition", "Community Service", "Concert", "Cultural Festival", "Dance Party", "Debate Competition", "Entrepreneurhip Pitch", "Essay Writing Contest", "Fashion Show", "Fitness Challenge", "Food Festival", "Game Night", "Guest Lecture", "Hackathon", "Health Awareness Camp", "Innovation Challenge", "Internship Info Session", "Job Fair", "Marathon", "Movie Night", "Networking Event", "Open Mic Night", "Poetry Reading", "Research Presentation", "Resume Workshop", "Robotics Demo", "Seminar", "Sports Tournament", "Storytelling Session", "Student Assembly", "Student Council Election", "Talent Show", "Tech Expo", "Thesis Defense", "Tree Planting", "Workshop", "Yoga Session", "Zumba Class" }));

        jLabel10.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Location:");

        locationTextField.setBackground(new java.awt.Color(0, 0, 51));
        locationTextField.setForeground(new java.awt.Color(255, 255, 255));
        locationTextField.setBorde(0.0F);

        jLabel11.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Date Start:");

        dateStartChooser.setBackground(new java.awt.Color(0, 0, 51));
        dateStartChooser.setForeground(new java.awt.Color(255, 255, 255));
        dateStartChooser.setOpaque(false);

        jLabel12.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Time:");

        jLabel13.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Date End:");

        dateEndChooser.setBackground(new java.awt.Color(0, 0, 51));
        dateEndChooser.setForeground(new java.awt.Color(255, 255, 255));
        dateEndChooser.setOpaque(false);

        jLabel14.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Time:");

        cancel.setText("Cancel");
        cancel.setkEndColor(new java.awt.Color(153, 0, 0));
        cancel.setkHoverEndColor(new java.awt.Color(76, 0, 0));
        cancel.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        cancel.setkHoverStartColor(new java.awt.Color(153, 0, 0));
        cancel.setkPressedColor(new java.awt.Color(153, 0, 0));
        cancel.setkStartColor(new java.awt.Color(76, 0, 0));
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        update.setkEndColor(new java.awt.Color(30, 153, 0));
        update.setkHoverEndColor(new java.awt.Color(15, 76, 0));
        update.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        update.setkHoverStartColor(new java.awt.Color(30, 153, 0));
        update.setkPressedColor(new java.awt.Color(30, 153, 0));
        update.setkStartColor(new java.awt.Color(0, 76, 0));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateStartChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titleTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eventTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(locationTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateEndChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeStartSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeEndSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eventTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateStartChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeStartSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateEndChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(timeEndSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        kGradientPanel2.setkBorderRadius(0);
        kGradientPanel2.setkEndColor(new java.awt.Color(0, 0, 51));
        kGradientPanel2.setkGradientFocus(0);
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 0, 51));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("MV Boli", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BISU Campus Event Manager");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Edit Event");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DBlue_panelLayout = new javax.swing.GroupLayout(DBlue_panel);
        DBlue_panel.setLayout(DBlue_panelLayout);
        DBlue_panelLayout.setHorizontalGroup(
            DBlue_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DBlue_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DBlue_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        DBlue_panelLayout.setVerticalGroup(
            DBlue_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DBlue_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DBlue_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(9, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DBlue_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        updateEvent();
    }//GEN-LAST:event_updateActionPerformed

    private void updateEvent() {
        String eventName = titleTextField.getText().trim();
        String eventType = eventTypeComboBox.getSelectedItem().toString();
        String location = locationTextField.getText().trim();

        // Get selected values
        Date dateStart = dateStartChooser.getDate();
        Date dateEnd = dateEndChooser.getDate();
        Date timeStart = (Date) timeStartSpinner.getValue();
        Date timeEnd = (Date) timeEndSpinner.getValue();

        // Validation
        if (eventName.isEmpty() || location.isEmpty() || dateStart == null || dateEnd == null || timeStart == null || timeEnd == null) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
            return;
        }

        // Merge date and time into full datetime
        Calendar calStart = Calendar.getInstance();
        calStart.setTime(dateStart);
        Calendar calStartTime = Calendar.getInstance();
        calStartTime.setTime(timeStart);
        calStart.set(Calendar.HOUR_OF_DAY, calStartTime.get(Calendar.HOUR_OF_DAY));
        calStart.set(Calendar.MINUTE, calStartTime.get(Calendar.MINUTE));
        calStart.set(Calendar.SECOND, calStartTime.get(Calendar.SECOND));
        Timestamp date_start = new Timestamp(calStart.getTimeInMillis());

        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dateEnd);
        Calendar calEndTime = Calendar.getInstance();
        calEndTime.setTime(timeEnd);
        calEnd.set(Calendar.HOUR_OF_DAY, calEndTime.get(Calendar.HOUR_OF_DAY));
        calEnd.set(Calendar.MINUTE, calEndTime.get(Calendar.MINUTE));
        calEnd.set(Calendar.SECOND, calEndTime.get(Calendar.SECOND));
        Timestamp date_end = new Timestamp(calEnd.getTimeInMillis());

        // Update event in the database using the eventNo
        boolean success = DBHelper.updateEvent(eventNo, eventName, eventType, location, date_start, date_end);
        if (success) {
            JOptionPane.showMessageDialog(null, "Event updated successfully!");
            this.dispose();  // Close the edit event form
        } else {
            JOptionPane.showMessageDialog(null, "Failed to update event.");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(editEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditEventData dummyData = new EditEventData(
                    0,
                    "Sample Title",
                    "Seminar",
                    "Auditorium",
                    new Date(), new Date(),
                    new Date(), new Date()
                );
                new editEvent(null, dummyData).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DBlue_panel;
    private javax.swing.JPanel DBlue_panel1;
    private javax.swing.JPanel DBlue_panel2;
    private com.k33ptoo.components.KButton cancel;
    private com.toedter.calendar.JDateChooser dateEndChooser;
    private com.toedter.calendar.JDateChooser dateStartChooser;
    private javax.swing.JComboBox<String> eventTypeComboBox;
    private javax.swing.JTable event_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private org.edisoncor.gui.textField.TextField locationTextField;
    private javax.swing.JButton organizer_delete;
    private javax.swing.JButton organizer_edit;
    private javax.swing.JButton organizer_new;
    private javax.swing.JButton organizer_poster;
    private javax.swing.JButton organzier_viewstudents;
    private javax.swing.JSpinner timeEndSpinner;
    private javax.swing.JSpinner timeStartSpinner;
    private org.edisoncor.gui.textField.TextField titleTextField;
    private com.k33ptoo.components.KButton update;
    // End of variables declaration//GEN-END:variables
}
