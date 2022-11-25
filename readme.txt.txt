We are using client server architecture to perform basic file transfer program.  
The client reads the data from a text file and sends it to the server. The server receives it and saves the data to another text file .
we will initially create a TCP socket. 
we will listen to the client and accept it from the client . 
WE save the data received into the text file. 
afterwards, we send a response message black to the client . 
This is what happens in the server side. 
Now we will  look into what happens in the client side; 
initially we create a TCP socket for the client . 
We connect it to  the server. 
we read the data and send the file to the server , receive response from the server and close the file and finally close the connection . 
