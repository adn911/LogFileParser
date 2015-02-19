import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		int profilerTime[] = new int[24];
		
		Scanner scanner = new Scanner(System.in);
		BufferedReader reader = null;
     
		try {

			String currentLine;
			String homeDirectory = System.getProperty("user.home");
			String fileName = "therap.log.ms-2.2013-10-21";
			

			reader = new BufferedReader(new FileReader(homeDirectory + "/"
					+ fileName));
	
			System.out.print("Enter URI: ");
			String urlToSearch = scanner.nextLine();
			urlToSearch = "URI=[" + urlToSearch.trim() + "]";

			while ((currentLine = reader.readLine()) != null) {

				if (currentLine.contains(urlToSearch)) {
					
					String hour = currentLine.split(" ")[1].substring(0, 2);
					//profilerTime[Integer.parseInt(hour)] += Integer.parseInt(currentLine.split(" time")[1].split("ms")[0].replace("=", ""));
					profilerTime[Integer.parseInt(hour)] += Integer.parseInt(currentLine.split(" time=")[1].replace("ms", ""));
				}
			}

			for (int hour = 0; hour < 24; hour++) {
				System.out.println("Total Profiler Time at "+hour+" hour: "+profilerTime[hour]+" ms");
			}

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
	

}

//URIs 
// /ma/newfpage/worklist
// /ma/sa/view
// /ma/logbook/view
// /ma/entry
// /ma/splash/view
