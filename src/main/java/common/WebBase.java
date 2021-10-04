package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class WebBase {
	@DataProvider(name = "Data Login")
	public String[][] getloginData() {
		String[][] LoginData = { { "Admin", "admin123" }, { "ess", "ess123" } };
		return LoginData;
	}

	@DataProvider(name = "DataCSVLogin")
	public String[][] getLoginCSVData() throws IOException {
		String filename = "C:\\Users\\gsm\\eclipse-workspace\\selenium-automation-framework2\\src\\main\\resources\\LoginData.csv";
		File file=new File(filename);
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		int maxrow=0;
		int maxcolm=0;
		String line;
		while( (line=br.readLine()) !=null) {
			maxrow++;
			String data[]=line.split(",");
			maxcolm=data.length;
			break;
			}
		System.out.println(maxrow);
		System.out.println(maxcolm);

		String[][] logData=new String[6][2];
		int i=0;
		while((line=br.readLine()) !=null) {
			String data[]=line.split(",");
			logData[i]=data;
			i++;
		}
		return logData;
	}
}
