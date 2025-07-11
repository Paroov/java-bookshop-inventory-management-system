/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ASUS
 */
public class ImageRenderer extends DefaultTableCellRenderer {
    public Component getDefaultTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column){
        Component c= super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
        
        if(value instanceof ImageIcon){
            setIcon((ImageIcon)value);
            setText("");
        }/*else{
            setText(value != null?value.toString():"");
            setIcon(null);
        }*/
        //setHorizontalAlignment(JLabel.CENTER);
        return c;
    
    }
    
}
