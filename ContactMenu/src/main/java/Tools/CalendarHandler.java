package Tools;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.lang.StringBuilder;

/**
 * Class that prints a Calendar on console
 *@author:Jonathan Scheffer
*/

public class CalendarHandler {
	private int month;
	private int year;

	/**
	 * Constants used to print the Calendar on portuguese
	 */
	String[] days = {"Do","Se","Te","Qu","Qu","Se","Sa"};
	String[] Months = {"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto",
						"Setembro","Outubro","Novembro","Dezembro"};

	/**
	 * CalendarHandler Contructor
	 * @param month
	 * @param year
	 */
	public CalendarHandler(int month, int year) {
		super();
		this.month = month;
		this.year = year;
	}
	/**
	 * Method used to contruct the Calendar format String using month and year atributes
	 * @return stringformatCalendar
	 */
	public String CalendarBuilder() {
		int[][] matrix = new int[6][7];
		GregorianCalendar firstDay = new GregorianCalendar(year,month-1,1);
		StringBuilder sb = new StringBuilder();
		int dayOfWeek = firstDay.get(Calendar.DAY_OF_WEEK);
		int daysInMonth = firstDay.getActualMaximum(Calendar.DAY_OF_MONTH);
		int i=0;
		int j = dayOfWeek-1;
		for (int d = 1; d <= daysInMonth ; d++) {
			 matrix[i][j] = d;
			 if(j==6) {
				 i++;
				 j=0;
			 }else j++;
		}		
		sb.append(Months[month-1]+" "+firstDay.get(Calendar.YEAR)+"\n");
		for(String day : days) {
			sb.append(day+" ");
		}
		sb.append("\n");
		for (i = 0; i < 6; i++) {
			for(j=0;j<7;j++) {
				if(matrix[i][j]==0) {
					sb.append("   ");	
				}
				else if(matrix[i][j]>=1&&matrix[i][j]<=9) {
					sb.append(" "+matrix[i][j]+" ");
				}
				else {
					sb.append(matrix[i][j]+" ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}