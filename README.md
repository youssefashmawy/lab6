# lab6
lab 6 assignment for Advanced programming course Junior Computer Engineer
This program reads an ARXML file containing a list of containers, each with a unique ID, and reorders the containers alphabetically by their name sub-container "SHORT-NAME". The program writes the reordered containers to a new ARXML file.

## Prerequisites
Java 8 or higher


## Usage
1. Use the batch file for direct usage of the code
2. If the file isn't empty and is of extension arxml then the output file should be "<input file name>_mod.arxml".
3. If the input file is not having .arxml extension then "NotVaildAutosarFileException" will be thrown.
4. If the input file is empty, "EmptyAutosarFileException" will be thrown.
## Exception Handling
The program handles the following exceptions:
- NotVaildAutosarFileException: triggered when the file is not having .arxml extension.
- EmptyAutosarFileException: triggered when the file is empty.

## Author
### [Youssef Ashmawy](https://github.com/youssefashmawy)
Email: [Youssef Ashmawy](mailto:youssefwael005@gmail.com)

## License

This project is licensed under the terms of the [MIT license](https://opensource.org/licenses/MIT).
