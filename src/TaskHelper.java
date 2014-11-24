import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskHelper {
	
	static int malesCount = 0;
	static String oldestPerson;
	static String oldestDate;
	static int age = 0;
	static String currentDOB;
	static String currentPersonName;
	static String billDOB;
	static String paulDOB;
	static DateFormat df = new SimpleDateFormat("dd/MM/yy");
	

	
	/**
	 * Gathers necessary data from Address Book to answer questions
	 */
	public static void processData(){
		BufferedReader br = null;

		try {

			String sCurrentLine;
			br = new BufferedReader(new FileReader(".\\AddressBook"));
			
			Date dateobj = new Date();
			oldestDate = df.format(dateobj);
			
			while ((sCurrentLine = br.readLine()) != null) {
				
				System.out.println(sCurrentLine);
				
				//Gathering data for Question - 1
				//Increment malesCount variable by 1 if the text 'Male' is found in a line
				if(sCurrentLine.contains("Male"))
					malesCount++;
				
				//Gathering data for Question - 2
				
				//Get current record's Date of birth
				currentDOB = sCurrentLine.split(",")[2].trim();
				
				//Initially stores the first person's name as oldest person
				//Verifies every record, if an older DOB is found, assigns that name to the oldestPerson variable
				//Therefore when the loop is completed the oldestPerson variable will contain oldest person's name
				if(isNewDateAnEarlierDate(dateobj, df.parse(currentDOB)))
					oldestPerson = sCurrentLine.split(",")[0].trim();
				
				dateobj = df.parse(currentDOB);
				
				//Gathering data for Question - 3
				currentPersonName = sCurrentLine.split(",")[0].trim();
				
				if(currentPersonName.contains("Bill"))
					billDOB = currentDOB;
				
				if(currentPersonName.contains("Paul"))
					paulDOB = currentDOB;
			}
			System.out.println("");
			System.out.println("Read Successful...");
			System.out.println("");
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	/** Verifies if new date is an earlier calendar date, returns true if yes, false otherwise
	 * @param oldDate
	 * @param newDate
	 * @return boolean
	 */
	public static boolean isNewDateAnEarlierDate(Date oldDate, Date newDate) {
		boolean isNewDateAnEarlierDate = false;
        if (oldDate.after(newDate)) 
            return true;
        
        return isNewDateAnEarlierDate;
    }
	
	/** Gets the difference between two dates in days
	 * @param df
	 * @param oldDate
	 * @param newDate
	 * @return int
	 */
	public static int getDifferenceinDays(DateFormat df, String oldDate, String newDate) {
		int differenceinDays = 0;
	    try {
	    	Date d1 = null;
	        Date d2 = null;
	        d1 = df.parse(oldDate);
	        d2 = df.parse(newDate);
	        //Calculate difference in time
	        long diff = d2.getTime() - d1.getTime();
	        //convert it to days
	        differenceinDays = (int) (diff / (60 * 60 * 1000) / 24);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    return differenceinDays;
}
}
