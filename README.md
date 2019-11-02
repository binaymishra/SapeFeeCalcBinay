Step 1 : Unzip SapeFeeCalcBinay.zip to Folder C:\\SapeFeeCalcBinay
Step 2 : Build fat Jar using git-bash command prompt and executing command
     ./gradlew clean build jacocoTestReport

Step 3 : Go to folder SapeFeeCalcBinay/build/libs
   cd build/libs


Step 4 : Place input file 'Input Data.csv' in the same 'build/libs' folder

Step 5: Run java jar executable command with file name/path as commandline argument

Example:
    java -jar SapeFeeCalcBinay-0.0.1-SNAPSHOT.jar "Input Data.csv"

    Hit enter.


Sample_Output.csv will be generated.


Please follow the screen-shot present in folder 'build-and-run'

SapeFeeCalcBinay/build-and-run/Step-1_Build.JPG
SapeFeeCalcBinay/build-and-run/Step-2_Pre_Run.JPG
SapeFeeCalcBinay/build-and-run/Step-3_Run.JPG

If you face any issue you can contact me :)

Name  : Binay Mishra
Email : binaymishrabca@gmail.com
Mobile: +917381634897