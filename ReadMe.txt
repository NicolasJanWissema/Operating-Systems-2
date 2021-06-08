Project contains makefile with multiple methods available to the user.
NB using make run or make saferun requires additional parameter ARGS="<no_hydrogen> <no_carbon>". This parameter contains the input argument for program.
Use make before using make run or make saferun.

-make: compiles code into bin directory, running javac.
-make run ARGS="<no_hydrogen> <no_carbon>": run RunSimulation with input arguments.
-make saferun ARGS="<no_hydrogen> <no_carbon>": runs SafetyCheckRun with input arguments. SafetyCheckRun checks arguments for syntax errors before running RunSimulation.