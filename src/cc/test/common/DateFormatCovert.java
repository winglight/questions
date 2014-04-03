package cc.test.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将毫秒值转换为制定格式的日期字符串
 * @author sunny
 *
 */
public class DateFormatCovert {
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	/**
	 * @param date 日期毫秒值
	 * @return 制定格式的字符串
	 */
	public static String dateTiemFormat(Date date){
		return dateTimeFormat.format(date);
	}
}
