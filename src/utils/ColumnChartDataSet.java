package utils;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import po.RankScore;

public class ColumnChartDataSet
{
	public static JFreeChart createColumnarTools(RankScore rankScore) {
	    // 获得数据
	    CategoryDataset dataset = getDataSet(rankScore);
	    // 获取柱状图工具类创建的柱状图，（将数据集传入）
	    JFreeChart chart = ColumnarTools.createCoColumnar(dataset);
	    return chart;
	}

	 //获取一个演示用的组合数据集对象 为柱状图添加数据

	private static CategoryDataset getDataSet(RankScore rankScore) {

	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    dataset.addValue(rankScore.getA(), "", "[90-100]");
	    dataset.addValue(rankScore.getB(), "", "[80-89]");
	    dataset.addValue(rankScore.getC(), "", "[70-79]");
	    dataset.addValue(rankScore.getD(), "", "[60-69]");
	    dataset.addValue(rankScore.getE(), "", "[0-59]");
	    return dataset;
	}

}
