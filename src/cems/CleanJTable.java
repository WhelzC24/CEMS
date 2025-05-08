/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cems;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CleanJTable extends JTable {
    private Color emptyBackgroundColor = new Color(0x33, 0x66, 0xFF); // Default dark blue

    public CleanJTable() {
        super();
        configureTable();
    }

    public CleanJTable(javax.swing.table.TableModel model) {
        super(model);
        configureTable();
    }

    public void setEmptyBackgroundColor(String hex) {
        this.emptyBackgroundColor = Color.decode("#" + hex);
        repaint();
    }

    private void configureTable() {
        setOpaque(false);
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        setBorder(null);

        // Set header renderer
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            {
                setOpaque(true);
                setBackground(new Color(0x33, 0x66, 0xFF));
                setForeground(Color.WHITE);
                setFont(new Font("Segoe UI", Font.BOLD, 13));
                setHorizontalAlignment(LEADING);
            }

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                Component c = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);
                c.setBackground(new Color(0x33, 0x66, 0xFF));
                c.setForeground(Color.WHITE);
                return c;
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(emptyBackgroundColor);
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    // Utility method to apply all enhancements to a JScrollPane
    public static void decorateScrollPane(JScrollPane scrollPane) {
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setViewportBorder(null);

        scrollPane.getVerticalScrollBar().setUI(createCustomScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(createCustomScrollBarUI());
    }

    private static BasicScrollBarUI createCustomScrollBarUI() {
        return new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                thumbColor = new Color(0x33, 0x66, 0xFF);
                trackColor = new Color(230, 230, 230);
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
            }
        };
    }
}