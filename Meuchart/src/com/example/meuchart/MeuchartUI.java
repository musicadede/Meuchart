package com.example.meuchart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.dussan.vaadin.dcharts.ChartImageFormat;
import org.dussan.vaadin.dcharts.DCharts;
import org.dussan.vaadin.dcharts.data.DataSeries;
import org.dussan.vaadin.dcharts.metadata.LegendPlacements;
import org.dussan.vaadin.dcharts.metadata.SeriesToggles;
import org.dussan.vaadin.dcharts.metadata.locations.LegendLocations;
import org.dussan.vaadin.dcharts.metadata.renderers.LegendRenderers;
import org.dussan.vaadin.dcharts.metadata.renderers.SeriesRenderers;
import org.dussan.vaadin.dcharts.options.Highlighter;
import org.dussan.vaadin.dcharts.options.Legend;
import org.dussan.vaadin.dcharts.options.Options;
import org.dussan.vaadin.dcharts.options.SeriesDefaults;
import org.dussan.vaadin.dcharts.renderers.legend.EnhancedLegendRenderer;
import org.dussan.vaadin.dcharts.renderers.series.PieRenderer;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("meuchart")
public class MeuchartUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MeuchartUI.class, widgetset = "com.example.meuchart.widgetset.MeuchartWidgetset")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

//		Button button = new Button("Click Me");
//		button.addClickListener(new Button.ClickListener() {
//			public void buttonClick(ClickEvent event) {
//				layout.addComponent(new Label("Thank you for clicking"));
//			}
//		});
//		layout.addComponent(button);
	
		
		
		
//----------------------------chart-------------------------		
//		DataSeries dataSeries = new DataSeries()
//		.newSeries()
//		.add("Baixo Peso", 23)
//		.add("error", 30)
//		.add("click", 5)
//		.add("impression", 25);
//
//	SeriesDefaults seriesDefaults = new SeriesDefaults();
//	seriesDefaults.setRenderer(SeriesRenderers.PIE);
//		seriesDefaults.setRendererOptions(
//			new PieRenderer()
//				.setShowDataLabels(true));
//
//	Legend legend = new Legend();
//	
//	legend.setRowSpacing("100px");
//	legend.setShow(true);
//
//	Highlighter highlighter = new Highlighter()
//		.setShow(true)
//		.setShowTooltip(true)
//		.setTooltipAlwaysVisible(true)
//		.setKeepTooltipInsideChart(true);
//
//	Options options = new Options();
//		options.setSeriesDefaults(seriesDefaults);
//		options.setLegend(legend);
//		options.setHighlighter(highlighter);
//
//	DCharts chart = new DCharts();
//	chart.setDataSeries(dataSeries);
//	chart.setOptions(options);
//	chart.show();
	
		
		// Define the namespace
		

		
		DataSeries dataSeries = new DataSeries()
		.newSeries()
		.add("none", 23)
		.newSeries()
		.add("error", 10)
		.newSeries()
		.add("click", 5)
		.newSeries()
		.add("impression", 25);

	SeriesDefaults seriesDefaults = new SeriesDefaults()
		.setRenderer(SeriesRenderers.PIE)
		.setRendererOptions(
			new PieRenderer()
				.setShowDataLabels(true));

	Legend legend = new Legend()
		.setShow(true)
		.setPlacement(LegendPlacements.OUTSIDE_GRID)
		.setLocation(LegendLocations.SOUTH);
//		.setRenderer(LegendRenderers.ENHANCED);
//		.setRendererOptions(
//			new EnhancedLegendRenderer()
//				.setSeriesToggle(SeriesToggles.SLOW)
//				.setSeriesToggleReplot(true));

	Options options = new Options()
		.setSeriesDefaults(seriesDefaults)
		.setLegend(legend);

	DCharts chart = new DCharts()
		.setDataSeries(dataSeries)
		.setOptions(options)
		.show();
		
//	chart.setWidth("100px");
//	chart.setHeight("100px");
	
	getPage().setTitle("Grafico");
	
	layout.setSizeFull();
	layout.addComponent(chart);
	}

}