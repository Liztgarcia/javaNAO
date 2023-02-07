package json2csv;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONObject;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			Scanner scanner = new Scanner(new File( args[0] ));
			
			File csvFile = new File(  args[1]  );
		    PrintWriter pw = new PrintWriter(csvFile);
		    CSVWriter csv=new CSVWriter(pw);
		    
		    csv.writeNext( new String[] { "keyword","search_volume","cpc","competition" } );
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				JSONObject doc = new JSONObject(line);
				
				ArrayList<String> row=new ArrayList<String>();
				row.add( doc.getString("keyword") );
				if ( doc.getJSONObject("keyword_info").get("search_volume")!=null ) row.add( ""+doc.getJSONObject("keyword_info").get("search_volume") ); else row.add("");
				if ( doc.getJSONObject("keyword_info").get("cpc")!=null ) row.add( ""+doc.getJSONObject("keyword_info").get("cpc") ); else row.add("");
				if ( doc.getJSONObject("keyword_info").get("competition")!=null ) row.add( ""+doc.getJSONObject("keyword_info").get("competition") ); else row.add("");
				
				csv.writeNext( row.toArray( new String[4] ) );
				}
			
			csv.flush();
		} catch (Exception ex) { ex.printStackTrace(); }
		
		
		}
	
	}
