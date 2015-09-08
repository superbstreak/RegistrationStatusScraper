# RegistrationStatusScraper
A program aim to automate the boring and time consuming manual multi-page refresh process.

Feature:
--
- Customizable refresh interval (> 3 minutes)
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
- The refresh interval should be greater than 3 minutes
- Each line should be separted by starting a new line
- Sample format: https://github.com/superbstreak/RegistrationStatusScraper/blob/master/Build/classes.txt

