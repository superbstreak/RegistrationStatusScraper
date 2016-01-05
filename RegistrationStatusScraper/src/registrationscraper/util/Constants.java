package registrationscraper.util;

public class Constants {

  public static int REFRESH_INTERVAL = 5; // in minutes

  public static final String SEAT_REMAINING_BASE = "body > div.container > div.content.expand > table";
  public static final String TOTAL_SEAT_REMAINING = "tbody > tr:nth-child(1) > td:nth-child(2) > strong";

  public static final CharSequence SEAT_TABLE_TEXT = "Total Seats Remaining:";
}
