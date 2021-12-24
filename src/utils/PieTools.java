package utils;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

public class PieTools
{
	public static JFreeChart createPie(DefaultPieDataset  dataset){
	    //创建饼状图
	    JFreeChart chart =ChartFactory.createPieChart3D("课程分数段统计情况", dataset, true, true, true);
	    //为饼状图设置字体
	    getChartByFont(chart);      
	    return chart;
	}
	private static void getChartByFont(JFreeChart chart){
	    //处理图形上的乱码
        //处理主标题的乱码
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));
        //处理子标题乱码
        chart.getLegend().setItemFont(new Font("宋体",Font.BOLD,15));
        //获取图表区域对象
        PiePlot3D categoryPlot = (PiePlot3D)chart.getPlot();
        //处理图像上的乱码
        categoryPlot.setLabelFont(new Font("宋体",Font.BOLD,15));
        //设置图形的生成格式为（张三  23 （10%））（姓名 值 百分比）
        String fm = "{0} {1} ({2})";
        categoryPlot.setLabelGenerator(new StandardPieSectionLabelGenerator(fm));
	}
}
