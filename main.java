import com.opencsv.*;
import java.io.*;
import java.io.IOException;

class Main {
  public static void main(String[] args) {
    FileReader archCSV = null;
    CSVReader csvReader = null;
    
    try {
      //Leo el archivo con el separador estándar ","
      // archCSV = new FileReader("data/ISO-Codes.csv");
      // csvReader = new CSVReader(archCSV);
      // String[] fila = null;
      // while((fila = csvReader.readNext()) != null) {
      //     System.out.println(fila[0]
      //               + " | " + fila[1]
      //               + " |  " + fila[2]);
      // }

      //Ahora leo el archivo con el separador ";"
      archCSV = new FileReader("data/ISO-Codes-puntoycoma.csv");
      CSVParser conPuntoYComa = new CSVParserBuilder().withSeparator(';').build();
      csvReader = new CSVReaderBuilder(archCSV).withCSVParser(conPuntoYComa).build();
      String[] fila = null;
      while((fila = csvReader.readNext()) != null) {
          System.out.println(fila[0]
                    + " | " + fila[1]
                    + " |  " + fila[2]);
      }

    }
    catch(IOException e) {
      System.out.println(e);
    }
    catch(Exception e) {
      System.out.println(e);
    }
    finally {
      try { 
        archCSV.close();
        csvReader.close();
      }
      catch(IOException e) {
        System.out.println(e);
      }
    }
  }
}
