import home.starks.*;
import java.io.*;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class International_Reporting {

	public static void main(String[] args) throws IOException, ParseException {
		// Variables //
		ArrayList<LineHolder> zuoraData = new ArrayList<LineHolder>();
		ArrayList<SubDetail> subDistincts = new ArrayList<SubDetail>();
		ArrayList<Location> local = new ArrayList<Location>();
		ArrayList<SalesRep> rep = new ArrayList<SalesRep>();
		
		String dataFileLocation = "C:/Files/RPC.TSV"; 									// Stores the Path to the Zuora data file to parse
		String locationFileLocation = "C:/Files/Location.TSV"; 							// Stores the Path to the location file to parse
		String sales_RepFileLocation = "C:/Files/Sales_Rep.TSV"; 						// Stores the Path to the Sales_Rep file to parse
		String outputZuoraFile = "C:/Files/ZuoraOut"+System.currentTimeMillis()+".txt";	// Output of Zuora Array 
		
				// Start // 
		// Load Files to Array //
		FiletoArray(zuoraData, dataFileLocation);										// Loads Zuora data
		LocationFiletoArray(local, locationFileLocation);								// Loads Location Data
		
		// Begin Building List // 
		getDistincts(zuoraData,subDistincts);											// Returns Distinct values from Zuora data
		updateMinVer(zuoraData, subDistincts);											// Update subs with the minimum version
		updateMaxVer(zuoraData, subDistincts);											// Updates subs with the maximum version
		updateAccountNumber(zuoraData, subDistincts);									// Update subs with account numbers
		updateAccountName(zuoraData, subDistincts);										// Update subs with account name
		updateLocation(zuoraData, subDistincts, local);									// Update Location
		updateisRenewal(zuoraData, subDistincts);										// Updates renewal field
		updateStatus(zuoraData, subDistincts);											// Updates status field
		
		
		
		
		// Output to File //
		writeArraytoFile(subDistincts, outputZuoraFile);								// Writes values tab seperated to file
		
}
	
	
	private static void FiletoArray(ArrayList<LineHolder> list, String fileToParse){
		
		int columnCount = 0;
		
		try{
			File f = new File(fileToParse);
			FileInputStream stream = new FileInputStream(f);
			BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-16LE"));
	        String lineJustFetched;
	        String[] wordsArray;
	        br.readLine();
	        while((lineJustFetched = br.readLine()) != null){
	        	
	        	
	        	//lineJustFetched.trim();
	        	wordsArray = lineJustFetched.split("\\t");
	        	LineHolder newLine = new LineHolder();
	        	for(String each : wordsArray){
	        			newLine.set(columnCount, each);
	        			columnCount++;
	        		}
	        	list.add(newLine);
	        	columnCount = 0;
	        	
	        }
	        
	
	      
	        br.close();
	
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	}

	private static void getDistincts(ArrayList<LineHolder> values, ArrayList<SubDetail> distinct){
		
		ArrayList<String> distinctList = new ArrayList<String>(); 
		for(LineHolder each : values){
			if(distinctList.contains(each.get(2))){
				
			}
			else{
				distinctList.add(each.get(2));
			}
		}
		for(String subDetailMake : distinctList){
					SubDetail myItem = new SubDetail();
					myItem.set("distinctSubNumber", subDetailMake);
					distinct.add(myItem);
		}		
	}

	private static void LocationFiletoArray(ArrayList<Location> list, String fileToParse){
		
		int columnCount = 0;
		
		try{
			File f = new File(fileToParse);
			FileInputStream stream = new FileInputStream(f);
			BufferedReader br = new BufferedReader(new InputStreamReader(stream, Charset.forName("US-ASCII")));
	        String lineJustFetched;
	        String[] wordsArray;
	        br.readLine();
	        while((lineJustFetched = br.readLine()) != null){
	        	
	        	
	        	lineJustFetched.trim();
	        	wordsArray = lineJustFetched.split("\t");
	        	Location newLocation = new Location();
	        	for(String each : wordsArray){
	        			newLocation.set(columnCount, each.trim());
	        			columnCount++;
	        		}
	        	list.add(newLocation);
	        	columnCount = 0;
	        	
	        }
	        
	
	      
	        br.close();
	
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	}
	
	private static void writeArraytoFile(ArrayList<SubDetail> data, String fileToWrite)throws IOException{
		
		File fout = new File(fileToWrite);
		FileOutputStream fos = new FileOutputStream(fout);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		osw.write(data.get(0).returnHeaders());
		for (SubDetail each : data){
			osw.write(each.toString());
			}	
		osw.close();
		fos.close();
		}
	
	private static void updateMinVer(ArrayList<LineHolder> data, ArrayList<SubDetail> distinct){
		int minValue = 100000000;
		int currentRow = 0;
		for(SubDetail each : distinct){
			for(LineHolder each2 : data){
				if(each.getString("distinctSubNumber").equals(each2.get(2)))
					if(Integer.parseInt(each2.get(6)) == minValue){
					}
					else if(Integer.parseInt(each2.get(6)) < minValue){
						minValue = Integer.parseInt(each2.get(6));
					}
				}
			
			distinct.get(currentRow).set("minVer", minValue);
			currentRow++;
			minValue = 10000000;
			}
		}

	private static void updateMaxVer(ArrayList<LineHolder> data, ArrayList<SubDetail> distinct){
		int maxValue = -100000000;
		int currentValue = 0;
		int currentRow = 0;
		for(SubDetail each : distinct){
	
			for(LineHolder each2 : data){
				if(each.getString("distinctSubNumber").equals(each2.get(2)))
					currentValue = Integer.parseInt(each2.get(6));
					if(currentValue == maxValue){
					}
					else if(currentValue > maxValue){
						maxValue = currentValue;
					}
				}
			
			distinct.get(currentRow).set("maxVer", maxValue);
			currentRow++;
			maxValue = -100000000;
			}
			
		}

	private static void updateAccountNumber(ArrayList<LineHolder> data, ArrayList<SubDetail> distinct){
		int currentRow = 0;
		for(SubDetail each : distinct){
			for(LineHolder each2 : data){
				if(each.getString("distinctSubNumber").equals(each2.get(2))){
					distinct.get(currentRow).set("accountNumber", each2.get(1));
				}
			}
			++currentRow;
		}
	}

	private static void updateAccountName(ArrayList<LineHolder> data, ArrayList<SubDetail> distinct){
		int currentRow = 0;
		for(SubDetail each : distinct){
			for(LineHolder each2 : data){
				if(each.getString("distinctSubNumber").equals(each2.get(2))){
					distinct.get(currentRow).set("accountName", each2.get(0));
				}
			}
			++currentRow;
		}
	}

	private static void updateLocation(ArrayList<LineHolder> data, ArrayList<SubDetail> distinct, ArrayList<Location> local){
		int currentRow = 0;
		for(SubDetail each : distinct){
			for(LineHolder each2 : data){
				if(each.getString("distinctSubNumber").equals(each2.get(2))){
					for(Location each3 : local){
						if(each3.get(0).equals(each2.get(28))){
							distinct.get(currentRow).set("location", each3.get(1));
						}
					}
				}
			}
			++currentRow;
		}
	}

	private static void updateisRenewal(ArrayList<LineHolder> data, ArrayList<SubDetail> distinct) throws ParseException{
		int currentRow = 0;
		Calendar cal = Calendar.getInstance();
		int currentMonth = cal.get(cal.MONTH)+1;
		int currentYear = cal.get(cal.YEAR);
		for(SubDetail each : distinct){
			for(LineHolder each2 : data){
				if(each.getString("distinctSubNumber").equals(each2.get(2))){
					String[] date = each2.get(7).split("-");
					int startMonth = Integer.parseInt(date[1]);
					int startYear = Integer.parseInt(date[0]);
					if(startMonth == currentMonth && (currentYear - startYear) > 0 ){
						distinct.get(currentRow).set("isRenewal", "True");
					}
					else{
						distinct.get(currentRow).set("isRenewal", "False");
					}
				}
			}
			++currentRow;
		}
	}

	private static void updateStatus(ArrayList<LineHolder> data, ArrayList<SubDetail> distinct){
		String currentStatus = null;
		int currentRow = 0;
		for(SubDetail each: distinct){
			for(LineHolder each2: data){
				if(each.getString("distinctSubNumber").equals(each2.get(2))){
					if(Integer.parseInt(each2.get(6)) == each.getInt("maxVer")){
						currentStatus = each2.get(10);
					}
					else{
						// do nothing	
					}
				}	
			}
			distinct.get(currentRow).set("status", currentStatus);
			currentStatus = null;
			++currentRow;
		}
	}



}
