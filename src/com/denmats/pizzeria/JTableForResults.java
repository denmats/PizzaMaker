package com.denmats.pizzeria;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.sql.*;


class JTableForResults extends JFrame {

    private static Object[][] databaseResults = null;
    private static Object[] columns = {"ID","Order Number","Client Number","Pizza Name","Pizza Quantity","Date"};

    //this method override to keep distinct data format
    //that later will be use for sorting data in JTable
    private static DefaultTableModel dTableModel = new DefaultTableModel(databaseResults,columns)
    {
        public Class getColumnClass(int column){
            Class returnValue;

            if(column >= 0 && column < getColumnCount()){
                returnValue = getValueAt(0,column).getClass();
            }else{
                returnValue = Object.class;
            }
            return returnValue;
        }
    };


    private static JTable table = new JTable(dTableModel);


    JTableForResults(){
        String url = "jdbc:mysql://localhost/pizzeria?useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String uname = "root";
        String pass = "1234";


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, uname, pass);

            Statement statement = conn.createStatement();
            String query = "SELECT * FROM orders";

            ResultSet rows = statement.executeQuery(query);

            Object[] tempRow;

            while (rows.next()){
                tempRow = new Object[]{
                        rows.getInt(1),
                        rows.getInt(2),
                        rows.getInt(3),
                        rows.getString(4),
                        rows.getInt(5),
                        rows.getDate(6)
                };
                dTableModel.addRow(tempRow);
            }

            statement.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }

        table.setFont(new Font("Serif",Font.PLAIN,24));
        table.setRowHeight(table.getRowHeight() + 16);
        table.setAutoCreateRowSorter(true);
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        TableColumn col1 = table.getColumnModel().getColumn(0);
        col1.setPreferredWidth(15);
        TableColumn col2 = table.getColumnModel().getColumn(1);
        col2.setPreferredWidth(50);
        TableColumn col3 = table.getColumnModel().getColumn(2);
        col3.setPreferredWidth(25);
        TableColumn col4 = table.getColumnModel().getColumn(3);
        col4.setPreferredWidth(300);
        TableColumn col5 = table.getColumnModel().getColumn(4);
        col5.setPreferredWidth(15);

        TableColumn tc1 = table.getColumn("ID");
        CenterTableCellRenderer centerRenderer1 = new CenterTableCellRenderer();
        tc1.setCellRenderer(centerRenderer1);
        TableColumn tc2 = table.getColumn("Order Number");
        CenterTableCellRenderer centerRenderer2 = new CenterTableCellRenderer();
        tc2.setCellRenderer(centerRenderer2);
        TableColumn tc3 = table.getColumn("Client Number");
        CenterTableCellRenderer centerRenderer3 = new CenterTableCellRenderer();
        tc3.setCellRenderer(centerRenderer3);
        TableColumn tc4 = table.getColumn("Pizza Name");
        CenterTableCellRenderer centerRenderer4 = new CenterTableCellRenderer();
        tc4.setCellRenderer(centerRenderer4);
        TableColumn tc5 = table.getColumn("Pizza Quantity");
        CenterTableCellRenderer centerRenderer5 = new CenterTableCellRenderer();
        tc5.setCellRenderer(centerRenderer5);

        JScrollPane jScrollPane = new JScrollPane(table);

        frame.add(jScrollPane,BorderLayout.CENTER);
        frame.setSize(1200,500);
        frame.setVisible(true);
    }//End of Constructor

    private class CenterTableCellRenderer extends DefaultTableCellRenderer {
        private CenterTableCellRenderer() {
            setHorizontalAlignment(JLabel.CENTER);
        }
    }
}//End of Class
