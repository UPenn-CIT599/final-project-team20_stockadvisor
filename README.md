# final-project-team20_stockadvisor
final-project-team20_stockadvisor created by GitHub Classroom

MCIT 591 Final Project-A Stock Investment Advisor By Time Series Trend Analysis

Team members: Boyu Wu, Liangen Hu, Chenming Cao

Here we have built a real time API multi-asset robo-advisor by performing time series analysis autoregressive integrated moving average (ARIMA) of user selected security (stocks, etfs) and providing the user with the short-term or long-term investment suggestion (overweight or underweight). 

This project is built using a maven project and using 3 APIs.

YahooFinanceAPI is used for getting real-time asset data from YahooFinance. Timeseries is used for getting the statistical analysis tools and helping with our ARIMA analysis. Assertj is used for JUnit test for swing GUI components.


In order to successfully run the program, after downloading all the files from the project folder, please create a maven project, then check and make sure all the dependencies for these 3 APIs are in the pom.xml file. Then please check the JRE system library and make sure it is set as JavaSE-1.8. (Alternatively you could copy and paste all the content in the project folder to the local maven project folder). The program could be launched by running AppRunner.java in Eclipse IDE. Please follow the instructions on the window when using the App. If you encounter any issue running the program, please feel free to let us know. Thanks!
