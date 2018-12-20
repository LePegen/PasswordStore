# Password Store
This is a package for the culminating task of Team Lezned for PRG08P section A67. This section was made by Job Lipat


Note: Password store is the working name of the project

## Usage

### Model Class
The model is the representation of persisent data


It is the data structure of the program. The data stored in the model are: the key that is used to decrypt the data and the data stored.

The user must first pass in the key that will unlock the model.

### Decrypt and Encrypt Class
These classes are used to ,as the name suggests, descrypt and encrypt the data.

The users passes in the key from the key derivation class and the model to decrypt/encrypt. Then, the user uses the respective method to perform the action desired.  It will return a encrypted/decrypted model.

### Key Derivation Class
This class is used to get the key to unlock encrypted data. 

The user passes in the password and the hash of the password. The program then hashes the password and compares it with the passed hash. If they  are equal it will return a key derived form the password.


## Encryption Model

The program uses the Advanced Encryption Standard to encrypt data.

## Todo
* Finalize model
* Change project name
* Document code
* Change project structure


