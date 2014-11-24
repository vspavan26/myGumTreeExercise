public class MyTask extends TaskHelper{


	public static void main(String[] args) {
		
		try {
			
		System.out.println("");
		System.out.println("Attempting to read Address Book...");
		System.out.println("");
		
		//Reads the AddressBook and gathers necessary data to answer the 3 questions
		//The idea is to read the book only once as I already know what data I am looking for
		processData();
		
		System.out.println("");
		System.out.println("Answering Questions...");
		
		System.out.println("");
		System.out.println("Q: How many males are in the address book?");
		System.out.println("A: The number of the males in the address book : " + malesCount);
		System.out.println("");
		System.out.println("Q: Who is the oldest person in the address book?");
		System.out.println("A: The oldest person is : " + oldestPerson);
		System.out.println("");
		System.out.println("Q: How many days older is Bill than Paul?");
		System.out.println("A: Bill is '" + getDifferenceinDays(df,billDOB,paulDOB)+ "' days older than Paul(Without including the end date which is Paul's birthday)");
		
		System.out.println("");
		System.out.println("");
		System.out.println("Task Successfully completed...");
		
		}catch(Exception e){
			System.out.println("Task Failed with error message : " + e.getMessage());
		}

	}




}