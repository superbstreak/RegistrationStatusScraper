package registrationscraper.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import registrationscraper.controller.ScraperTimerController;
import registrationscraper.model.AClass;
import registrationscraper.util.Constants;

public class Main {  
  
  private static ScraperTimerController timer;
  private static Set<AClass> classesToMonitor = new HashSet<AClass>();
  
  public static void main(String [] args){
    classesToMonitor = new HashSet<AClass>();
    boolean isFirstLine = true;
    int refresh_interval = Constants.REFRESH_INTERVAL;
    try(BufferedReader br = new BufferedReader(new FileReader("classes.txt"))) {
      System.out.println();
      for(String line; (line = br.readLine()) != null; ) {
        if (isFirstLine) {
          isFirstLine = false;
          String interval = line.trim();
          refresh_interval = Integer.parseInt(interval);
          if (refresh_interval <= 3) {
            throw new IllegalArgumentException("Refresh interval must be greater than 3 and an integer.");
          }
          System.out.println("Refresh interval set to: "+refresh_interval+" minutes.");
        } 
        else {
          String url = line.trim();
          int nameStart = url.indexOf("dept=") + 5;
          String name = url.substring(nameStart, nameStart+4);
          int courseStart = url.indexOf("course=") + 7;
          name += " " + url.substring(courseStart, courseStart+3);
          int sectionStart = url.indexOf("section=") + 8;
          String section = url.substring(sectionStart, sectionStart + 3);
          classesToMonitor.add(new AClass(name, section, 0, false, url));
          System.out.println("Monitoring "+name+" "+section+".");
        }
      }
      System.out.println();
    } catch (Exception e) {
      System.err.println("Error while reading: "+e);
    }
    
    timer = new ScraperTimerController(refresh_interval, classesToMonitor);
    timer.startGlobalTimer();
    
  }
}
