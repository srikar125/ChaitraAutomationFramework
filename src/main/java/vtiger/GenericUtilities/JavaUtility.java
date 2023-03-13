package vtiger.GenericUtilities;


import java.util.Date;
import java.util.Random;

/**
 * This class contains methods of java specific meethods
 * @author Srikar Reddy
 *
 */
public class JavaUtility {
/**
 * This method will generate random number on every execution
 * @return
 */
	public int getRandomNumber()
	{
		Random ran=new Random();
		return ran.nextInt(1000);
	}
	/**
	 * This method will gives the current system date
	 * @return
	 */
	public String getSysemDate()
	{
		Date dt=new Date();
		return dt.toString();
	}
	/**
	 * This method will gives the current system date in specific format
	 * @return
	 */
	public String getSysemDateInFormat()
	{
		Date dt=new Date();
		String[] dtArr=dt.toString().split(" ");
		String date=dtArr[2];
		String month=dtArr[1];
		String year=dtArr[5];
		String time=dtArr[3].replaceAll(":", "-");
		String dateInFormat=date+" "+month+" "+year+" "+time;
		return dateInFormat;
	}

}
