# Project-on-Symmetric-Key-Cryptography

1. use encrypt1.Main.java to encrypt a message
2. use decrypt1.Main.java to decrypt a message
3. use fileComparatorModule.Main.java to compare two files whether both are same or not

Encryption procedure -

  encrypt1.Main.java will ask for the plain text file name which have to be encrypted and after execution it will generate a
  cipher text file and a symmetric key file

  You do not need to worry about file extension.

  example :-
    
    plain text file name : script.sh
    
    generated cipher text file name will be : script_cipher.txt
    
    generated symmetric key fill name will be : script_sym.txt
    
    You need to preserve cipher text file and symmetric file to generate original plain text file using decryption module
    
Decryption procedure -

  decrypt1.Main.java will ask for the cipher text file name and symmetric key file name to generate the original plain text 
  file

  example :-
    
    cipher text file name : script_cipher.txt
    
    symmetric key file name : script_sym.txt
    
    generated plain text fill name will be : script_dpt.sh
    
    Here, script.sh and script_dpt.sh are both same.
    You can check using fileComparatorModule.Main.java
    
Whole project is under package Cryptography

ptf_files contains plain text files and corresponding cipher text file, symmetric key file and decrypted file which I have used during verification of this project.

This code is used to verify the algorithm proposed in the paper "Secure Symmetric Key Transmission of Messages Using Random Shuffling of Spiral Matrix and Multiplicative Inverse (RSSMMI)", 

if you are using this code in your research then cite it as 'Manna S., Banerjee S., Panja P., Das R., Dutta S. (2018) Secure Symmetric KeyTransmission of Messages Using Random Shuffling of Spiral Matrix and Multiplica-tive Inverse (RSSMMI). In: Bhattacharyya S., Chaki N., Konar D., Chakraborty U.,Singh C. (eds) Advanced Computational and Communication Paradigms.  Advancesin Intelligent Systems and Computing, pp 135-143, vol 706.  Springer, Singapore'
