import java.awt.Color;
import java.awt.BasicStroke;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

import javax.swing.*;

public class XYLineChart_AWT extends JFrame {

    public XYLineChart_AWT(String applicationTitle, String chartTitle, XYSeries xySeries) {
        super(applicationTitle);
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                chartTitle ,
                "" ,
                "" ,
                createDataset(xySeries) ,
                PlotOrientation.VERTICAL ,
                true , true , false);

        ChartPanel chartPanel = new ChartPanel( xylineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 1200 , 650 ) );
        final XYPlot plot = xylineChart.getXYPlot( );

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.BLUE );
        renderer.setSeriesStroke( 0 , new BasicStroke( 1.0f ) );
        plot.setRenderer( renderer );
        setContentPane( chartPanel );
    }

    private XYDataset createDataset(XYSeries xySeries) {
//        final XYSeries firefox = new XYSeries( "Firefox" );
//        firefox.add( 1.0 , 1.0 );
//        firefox.add( 2.0 , 4.0 );
//        firefox.add( 3.0 , 3.0 );


        final XYSeriesCollection dataset = new XYSeriesCollection( );
        dataset.addSeries(xySeries);
        return dataset;
    }

    public static void main( String[ ] args ) {
//        XYLineChart_AWT chart = new XYLineChart_AWT("Browser Usage Statistics",
//                "Which Browser are you using?");
//        chart.pack( );
//        RefineryUtilities.centerFrameOnScreen( chart );
//        chart.setVisible( true );
    }
}