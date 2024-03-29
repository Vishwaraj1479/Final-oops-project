package org.knowm.xchart.standalone.issues;

import java.util.ArrayList;
import java.util.List;
import org.knowm.xchart.RadarChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.demo.charts.radar.RadarChart01;
import org.knowm.xchart.style.RadarStyler;

/** Create a Chart matrix */
public class TestForIssue189_1 {

  public static void main(String[] args) {

    ExampleChart<RadarChart> alc = new RadarChart01();
    List<RadarChart> charts = new ArrayList<>();
    {
      RadarChart chart = alc.getChart();
      chart.setTitle("Default radar chart");
      charts.add(chart);
    }
    {
      RadarChart chart = alc.getChart();
      chart.setTitle("Radar chart with circle rendering");
      chart.getStyler().setRadarRenderStyle(RadarStyler.RadarRenderStyle.Circle);
      charts.add(chart);
    }
    {
      // current default
      RadarChart chart = alc.getChart();
      chart.setTitle("Radar chart with 3 variables and start angle");
      chart.getStyler().setToolTipsEnabled(true);
      chart.getStyler().setStartAngleInDegrees(45);
      chart.setRadiiLabels(new String[] {"Sales", "Marketing", "Development"});
      charts.add(chart);
    }
    {
      RadarChart chart = alc.getChart();
      chart.setTitle("Radar chart with non circular rendering");
      chart.getStyler().setCircular(false);
      charts.add(chart);
    }

    new SwingWrapper<RadarChart>(charts).displayChartMatrix();
  }
}
