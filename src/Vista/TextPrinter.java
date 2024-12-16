/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vista;

/**
 *
 * @author ulise
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.*;

public class TextPrinter implements Printable {
    private String printData;

    public TextPrinter(String printData) {
        this.printData = printData;
    }

    @Override
    
public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
    if (page > 0) {
        return NO_SUCH_PAGE;
    }
    Graphics2D g2d = (Graphics2D) g;
    g2d.translate(pf.getImageableX(), pf.getImageableY());  // Ajusta esto si es necesario
    g.drawString(printData, 10, 10);  // Ajusta las coordenadas x, y según sea necesario
    return PAGE_EXISTS;
}

    public void printText() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean doPrint = job.printDialog();
        if (doPrint) {
            try {
                job.print();
            } catch (PrinterException e) {
                System.err.println("Error printing: " + e.getMessage());
            }
        }
    }
}
