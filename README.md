Specification
=============

Part 1 - Directory and ArrayDirectory
-------------------------------------

You have been supplied with a Directory interface that contains methods to support the following functionality:

*   insertEntry - Insert new entries into the Directory

*   deleteEntryUsingName - Delete entries from a Directory using a name

*   deleteEntryUsingExtension - Delete entries from a Directory using an extension

*   updateExtensionUsingName - Update/Change a specific staff member’s extension number using their name

*   lookupExtension - Lookup the extension number of a specific member of staff when given their name

*   toArrayList - Return an ArrayList of all entries in the Directory **Note**: the order of the returned entries does not need to be consistent across all implementations of the interface.


**You must not change any of the method signatures of the interface.**

**Note**: you will notice that compiling the given Directory.java interface right away will return errors and/or your IDE will highlight errors. Take these as a hint as to what you may need to do.

Create an ArrayDirectory class that implements the above interface and specifically uses an Array to store Directory entries. The class should implement the functionality of the above methods.

Each staff entry of a Directory will consist of a surname, initials and a telephone extension number. Note: extensions can start with the number 0 and are only 5 digits in length.

Mock data that you can use for testing will be provided for you in the form of a CSV file. The CSV is in the following format:

,,

Each new line represents a separate, different staff entry.

For software engineering best practice, you should also include some evidence of correctness testing for each implementation of the Directory.

Part 2 - Additional Directories and Classes
-------------------------------------------

Create the classes ArrayListDirectory and HashMapDirectory and have them both implement from the Directory interface. Repeat the same process for these classes as you did in part 1 for ArrayDirectory but ensure that the ArrayListDirectory class uses an ArrayList to store entries and HashMapDirectory uses HashMaps. Note: you may find it useful to use 2 different HashMaps to store entries in HashMapDirectory.

Create an input class. Your input class should be able to accept a CSV file and add its entries to a given Directory. It should also be able to accept user input of staff entries via the console. Make sure that user input only allows the correct entry format specified in part 1.

Create an output class. Your output class should be able to print to the console a Directory in a neat ASCII table format (see below for an example). It should additionally be able to export all Directory entries to a CSV file (in the same format described in part 1).+---------+----------+-----------+ | Surname | Initials | Extension | +---------+----------+-----------+ | Bar | F.B | 01123 | | Debbie | B.L.D | 09876 | | Sam | S.S | 87663 | +---------+----------+-----------+

The above is purely an example. You can use whatever characters or form you would like to create the output.

Part 3 - Performance Testing and Report
---------------------------------------

Create a performance analysis class that will measure the **worst**, **average** and **best** case execution times of a Directory’s data insertion, look up and data deletion (both methods). For data deletion and lookup, you should measure the performance using a record in the middle of the data. To do this you can use the StopWatch class provided.

Worst case – The slowest execution time witnessed for the method

Average case – The average execution time across all method runs

Best case – The fastest execution time witnessed for the method

To get an accurate measure of the time to perform an operation, it is a good idea to perform each operation 1000 (or even 10,000) times and measure the average time taken. Make sure you only time the method and not any additional operations such as creating an object, input/output associated with it (buffered I/O completely wrecks performance data), etc.

Modify your output class so that it produces a report of performance analysis in the form of a text file (.txt). The report should include what type of Directory was being analysed and the worst, average and best case execution times of the above-specified methods. The location of where this report is created should be customisable.

Finally, produce some documentation that contains a discussion about your findings and summarises your results. You should comment on and compare your findings as well as propose reasons as to why some data structures perform worse/better for certain operations. For example, you may find from your performance analysis that data lookup is 70% faster using a HashMap when compared to an ArrayList etc. Your report should be around 500 words long - 10% leeway will be taken into consideration for the word count.