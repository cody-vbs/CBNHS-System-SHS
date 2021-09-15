/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Phil Rey
 */
public class CustomCellRenderer extends DefaultTableCellRenderer{
    Color bkgndColor, fgndColor,selectFC,selectBC;
    Font font,fontB;
    
    public CustomCellRenderer(Color bkgnd, Color foregnd, Font font,Color selectF,Color selectB) {
       super(); 
       bkgndColor = bkgnd;
       fgndColor = foregnd;
       this.font = font;
       selectFC = selectF;
       selectBC = selectB;
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column){
        Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
        cell.setFont(font);
        if(isSelected){
            cell.setBackground( selectBC );
            cell.setForeground( selectFC );
        }else{
            cell.setBackground( bkgndColor );
            cell.setForeground( fgndColor );
        }

        return cell;
    }
}
