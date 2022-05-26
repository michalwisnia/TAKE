/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.PrimeFaces;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author micha
 */
@Named(value = "chartBean")
@RequestScoped
public class ChartBean {
    
    private LineChartModel lineModel;

    public ChartBean() {
        setupChart();
    }
    
    private void setupChart() {
        lineModel = new LineChartModel();
        lineModel.setZoom(true);
        lineModel.setLegendPosition("sw");
        addSeries();
        setupAxises();
    }
    
    private void addSeries() {
        lineModel.addSeries(createSineSeries());
        lineModel.addSeries(createCosineSeries());
    }
    
    private LineChartSeries createSineSeries() {
        LineChartSeries series = new LineChartSeries();
        series.setLabel("Sinus");
        for (int i = 0; i <= 360; i += 10) {
            series.set(i, Math.sin(Math.toRadians(i)));
        }
        
        return series;
    }
    
    private LineChartSeries createCosineSeries() {
        LineChartSeries series = new LineChartSeries();
        series.setLabel("Cosinus");
        for (int i = 0; i <= 360; i += 10) {
            series.set(i, Math.cos(Math.toRadians(i)));
        }
        
        return series;
    }
    
    private void setupAxises() {
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setMin(-1);
        yAxis.setMax(1);
        
        Axis xAxis = lineModel.getAxis(AxisType.X);
        xAxis.setMin(0);
        xAxis.setMax(360);
        xAxis.setTickInterval("10");
        xAxis.setLabel("Degrees");
    }

    public LineChartModel getLineModel() {
        return lineModel;
    }

    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }    
}