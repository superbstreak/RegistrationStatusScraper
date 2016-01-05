package registrationscraper.controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import registrationscraper.model.AClass;
import registrationscraper.util.Constants;

public class ScraperTimerController {

  private Timer timer;
  private Set<AClass> classesToMonitor = new HashSet<AClass>();
  private int interval = Constants.REFRESH_INTERVAL;

  public ScraperTimerController(int interval, Set<AClass> classess) {
    this.timer = new Timer();
    this.classesToMonitor = classess;
    this.interval = interval;
  }

  public void startGlobalTimer() {
    killGlobalTimer();
    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        System.out.println();
        System.out.println("=======================================================================");
        System.out.println("Scraped Started On: " + new Date());
        System.out.println("-----------------------------------------------------------------------");
        int scraped = 0;
        try {
          for (AClass aClass : classesToMonitor) {
            if (aClass != null && aClass.getUrl() != null) {
              scrapeStatus(aClass);
              scraped += 1;
            }
          }
        } catch (IOException e) {
          System.err.println("Error Occurred: " + e);
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Scraped Ended On: " + new Date() + " Total scraped: " + scraped);
        System.out.println("=======================================================================");
      }
    }, 0, interval * 1000 * 60);
    System.out.println("Timer Has Been STARTED!");
  }

  public void killGlobalTimer() {
    if (this.timer != null) {
      this.timer.cancel();
    }
    this.timer = new Timer();
    System.out.println("Timer Has Been KILLED! The Manhunt Is On!");
  }

  public void updateObserver(Set<AClass> classes) {
    if (this.classesToMonitor == null) {
      this.classesToMonitor = new HashSet<AClass>();
    }
    this.classesToMonitor = classes;
  }

  private void scrapeStatus(AClass interest) throws IOException {
    Document doc = Jsoup.connect(interest.getUrl()).get();
    Elements seatTable = doc.select(Constants.SEAT_REMAINING_BASE);
    int tabSize = seatTable.size();
    Element seats = null;
    for (int i = 0; i < tabSize; i++) {
      Element tempSeat = seatTable.get(i);
      if (tempSeat != null && tempSeat.toString().contains(Constants.SEAT_TABLE_TEXT)) {
        seats = tempSeat;
      }
    }
    if (seats != null) {
      Elements totalSeats = seats.select(Constants.TOTAL_SEAT_REMAINING);
      String remaining = totalSeats.text();
      if (remaining != null && !remaining.isEmpty()) {
        int remain = Integer.parseInt(remaining);
        if (remain > 0) {
          System.out.println("> TimeStamp: " + new Date() + ", " + interest.getClassIdentifier() + " " + interest.getSectionIdentifier() + ": " + remain
              + " remaining! GET IT NOW! <-------------------");
          notifyUser(interest.getUrl());
        } else {
          System.out.println("> TimeStamp: " + new Date() + ", " + interest.getClassIdentifier() + " " + interest.getSectionIdentifier() + ": " + remain + " seat.");
        }
      }
    }

  }

  private void notifyUser(String url) {
    try {
      Desktop.getDesktop().browse(new URI(url.trim()));
    } catch (Exception ignored) {
    }
  }

}
