/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage7;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Phil Rey Paderogao
 */
public class CustomHeaderRenderer extends JLabel implements TableCellRenderer{
    Color backgroundColor,foregroundColor;
    Font font;

    public CustomHeaderRenderer(Color backgroundColor, Color foregroundColor,Font font) {
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
        this.font = font;
    }
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        setFont(font);
        setForeground(foregroundColor);
        
        return this;
    }
}
