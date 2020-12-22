package gui;

import serialization.FPLBootstrapStatic;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.Comparator;

public class FPLGui {
    private FPLBootstrapStatic data;
    public FPLGui(FPLBootstrapStatic data) {
        setData(data);

        JFrame frame = buildFrame();
        JTable table = buildElementsTable();
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private JTable buildElementsTable() {
        class IntComparator implements Comparator {
            public int compare(Object o1, Object o2) {
                Integer int1 = (Integer)o1;
                Integer int2 = (Integer)o2;
                return int1.compareTo(int2);
            }

            public boolean equals(Object o2) {
                return this.equals(o2);
            }
        }

        class FloatComparator implements Comparator {
            public int compare(Object o1, Object o2) {
                Float float1 = (Float) o1;
                Float float2 = (Float) o2;
                return float1 < float2 ? -1
                        : float1 > float2 ? 1 : 0;
            }
        }

        String[] columnNames = {
                "First Name",
                "Last Name",
                "Minutes",
                "Assists",
                "Goals",
                "Total Points",
                "Points Per Game"
        };

        // The 0 argument is number rows.
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        JTable table = new JTable(tableModel);

        for (FPLBootstrapStatic.FPLElement elem : data.getElements()) {
            Object[] row = buildTableRow(elem);
            tableModel.addRow(row);
        }

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        IntComparator intComparator = new IntComparator();
        FloatComparator floatComparator = new FloatComparator();
        sorter.setComparator(2, intComparator);
        sorter.setComparator(3, intComparator);
        sorter.setComparator(4, intComparator);
        sorter.setComparator(5, intComparator);
        sorter.setComparator(6, floatComparator);
        table.setRowSorter(sorter);
        table.setAutoCreateRowSorter(false);
        return table;
    }

    private Object[] buildTableRow(FPLBootstrapStatic.FPLElement elem) {
        Object[] row = {
                elem.getFirstName(),
                elem.getLastName(),
                elem.getMinutes(),
                elem.getAssists(),
                elem.getGoalsScored(),
                elem.getTotalPoints(),
                elem.getPointsPerGame()
        };
        return row;
    }


    private JFrame buildFrame() {
        JFrame frame = new JFrame("FPL Elements");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        return frame;
    }

    public FPLBootstrapStatic getData() {
        return data;
    }

    public void setData(FPLBootstrapStatic data) {
        this.data = data;
    }
}
