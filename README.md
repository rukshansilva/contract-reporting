# Contract Reporting Technical Challenge

## Reference Documentation

#### First, clone the remote repository
```
Open Git Bash
Change the current working directory to the location where you want the cloned directory
Type 'git clone', and then paste the remote repository URL, Press enter 
```

#### Once cloned, follow these steps to build and run the app
```
cd contract-reporting

mvn clean package

cd target
java -jar contract-reporting-1.0.jar <STRING_INPUT>
```

#### Following is a sample String input used in testing the App
Please Note: each line in the CSV has been separated with a \n (newline) character
```
"2343225,2345,us_east,RedTeam,ProjectApple,3445s\n1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s"
```

#### Therefore, A sample command to run the app including the input string is:
```
java -jar contract-reporting-1.0.jar "2343225,2345,us_east,RedTeam,ProjectApple,3445s\n1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n3244332,2346,eu_west,YellowTeam3,ProjectCarrot,432
2s\n1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s"
```

---
## Assumptions:

- The project requires Java 17 and Maven to be installed
- Uses JUnit dependency (for Unit Testing)  
- More complex CSVs (e.g: with quotes or commas) will not be parsed as intended with this approach
- The app currently only works with a CSV input as a String. Potential extention would be to accept CSV or XML based files. 