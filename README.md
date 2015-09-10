# RegistrationStatusScraper
Tired of clicking the refresh button every new term? This program aims to help reduce the pain...
When an spot opens up on your desired course, it will automatically opens up the link in the default web browser ready for you.

Download: <br />
--
JAR: https://github.com/superbstreak/RegistrationStatusScraper/raw/master/Build/classScraper.jar

Feature:
--
- Customizable refresh interval (>= 2 minutes)
- Monitor as many classes as you like
- Automatically open the available class in the default web browser
- Free

How To Use:<br />
--
1. Put both classScraper.jar and classes.txt in the same folder.<br />
2. open termial if you're on OSX or cmd.exe if your are on Windows<br />
3. cd into that folder<br />
4. start classScraper.jar by typing 'java -jar classScraper.jar' then press enter<br />
5. Leave the terminal/cmd up as long as you like<br />


The jar file reads in a text file 'classes.txt' and the format should be:
--
- Start the file with a number (in minutes, refresh interval)
- The refresh interval should be greater than or equal to 2 minutes
- Each line should be separted by starting a new line
- Sample format: https://github.com/superbstreak/RegistrationStatusScraper/blob/master/Build/classes.txt

