package utils;


import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import po.RankScore;

public class PieChartDataSet
{
	public static JFreeChart createPieTools(RankScore rankScore) {
	    // TODO Auto-generated method stub
	    // 获取饼状图的数据集
	    DefaultPieDataset dataset = getDataSet(rankScore);
	    // 获取饼状图工具类创建的饼状图
	    JFreeChart chart = PieTools.createPie(dataset);
	    return chart;
	}

	private static DefaultPieDataset getDataSet(RankScore rankScore) {
	    // 数据可以从数据库中得到
	    DefaultPieDataset dataset = new DefaultPieDataset();
	    // 添加数据
	     dataset.setValue("[90-100]", rankScore.getA());
	     dataset.setValue("[80-89]", rankScore.getB());
	     dataset.setValue("[70-79]", rankScore.getC());
	     dataset.setValue("[60-69]", rankScore.getD());
	     dataset.setValue("[0-59]", rankScore.getE());

	    return dataset;

	}

}
