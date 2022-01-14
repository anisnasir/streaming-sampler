# Description
The code implements reservoir sampling to sample the stream of characters.
The details about the algorithm can be found at https://en.wikipedia.org/wiki/Reservoir_sampling.
The script executes the algorithm on two different type of inputs, i.e., input streamed to the 
script and the generated random string.


## Prerequisite

You need to have java installed on the machine.


## Usage

To run the script on the input stream, you can use the command

```
cat <input>|./gradlew run --args <size>
```

The <input> should be the path to input file that you would like to stream to the script. 
Moreover, the size is the size of the sample that you would like to extract.
A sample input file is included in the project and you can execute the script against that file to generate a sample of size 5 using: 

```
cat input.txt|./gradlew run --args 5
```


Moreover, to run the script on randomly generated string, you can use the command 

```
./gradlew run --args <size>
```

An example value for the size could be 5. The script randomly generates a string of size 256 and generats a sample of provided input size.