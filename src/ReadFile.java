import org.jfree.data.xy.XYSeries;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadFile {
    private int lineNum = 0;
    private int nodes;
    private ArrayList<String[]> allCoordinates = new ArrayList<>();
    private ArrayList<String[]> adjacentMatrix = new ArrayList<>();
    private String[][] adjacentMatrixArray;

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        readFile.getNodesData("C:\\Users\\TOSHIBA\\Desktop\\benchmark\\input20.txt");

        for (int i = 0; i < readFile.nodes; i++) {
            for (int j = 0; j <readFile.nodes; j++) {
                System.out.print(readFile.adjacentMatrixArray[i][j] + " ");
            }
            System.out.println();
        }

//        for (String[] s : readFile.adjacentMatrix) {
//            for (String s1 : s) {
//                System.out.print(s1 + "   ");
//            }
//            System.out.println();
//        }

//        XYSeries xySeries = new XYSeries("nodes");
//        System.out.println(readFile.allCoordinates.size());
//        for (String[] s : readFile.allCoordinates) {
//            System.out.println(s[0] + "  " + s[1] + "  " + s[2]);
//            xySeries.add(Double.parseDouble(s[1]), Double.parseDouble(s[2]));
//        }
//        XYLineChart_AWT chart = new XYLineChart_AWT("Shortest path", "Graph", xySeries);
//        chart.pack( );
//        RefineryUtilities.centerFrameOnScreen( chart );
//        chart.setVisible( true );
    }

    public void showGraph(String filePath) {
        ReadFile readFile = new ReadFile();
        readFile.getNodesData(filePath);
        XYSeries xySeries = new XYSeries("nodes");
        System.out.println(readFile.allCoordinates.size());
        for (String[] s : readFile.allCoordinates) {
            System.out.println(s[0] + "  " + s[1] + "  " + s[2]);
            xySeries.add(Double.parseDouble(s[1]), Double.parseDouble(s[2]));
        }
        XYLineChart_AWT chart = new XYLineChart_AWT("", "Graph", xySeries);
        chart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }

    private int getNodesData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int matrixLineNum = 0;
            while ((line = br.readLine()) != null) {
                if (lineNum == 2) {
                    nodes = Integer.parseInt(line);
                    adjacentMatrixArray = new String[nodes][nodes];
                    matrixLineNum = nodes + 4;
                } else if (lineNum >= 4 && lineNum < (nodes + 4)) {
                    String[] coordinateData = line.split("\t");
                    allCoordinates.add(coordinateData);
                } else if ((matrixLineNum != 0 && matrixLineNum != 1) && lineNum >= matrixLineNum) {
                    String[] abc = line.split("\t");
                    for (int i = 0; i < abc.length; i++) {
                        if (i == 0) {
                            adjacentMatrixArray[Integer.parseInt(abc[0])][Integer.parseInt(abc[1])] = abc[3];
                            i = 5;
                        } else {
                            adjacentMatrixArray[Integer.parseInt(abc[0])][Integer.parseInt(abc[i])] = abc[i + 2];
                            i += 4;
                        }
                    }
                    adjacentMatrix.add(abc);
                }
                lineNum++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nodes;
    }
}
