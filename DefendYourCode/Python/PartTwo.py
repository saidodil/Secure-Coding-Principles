import re
import os
import hashlib


def validname(name):
    if name.replace(" ", "").isalpha():
        return True
    else:
        return False


def getName(value):
    name = input("Enter your " + value + "Name: \n")
    while not validname(name):
        print("Invalid Name. Please write correct format: \n")
        name = name = input("Enter your " + value + "Name\n")
    return name


def getInt(value):
    number = int(input("Enter your " + value + "integer: \n"))
    while not isinstance(number, int):
        print("Invalid Number. Please print correct format: \n")
        number = int(input("Enter your " + value + "integer: \n"))
    return number


def getfilename(value):
    file = input("Enter " + value + " file as name.txt: \n")
    last_chars = file[-4:]

    while (len(file) < 5) or (last_chars != ".txt"):
        print("Invalid File Name. Please write correct format: \n")
        file = input("Enter " + value + " file as name.txt: \n")
        last_chars = file[-4:]
    return file


def validpassword(password):
    regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[ !@#$%&*()-+=^]).{8,15}$"
    pat = re.compile(regex)
    mat = re.search(pat, password)
    if len(password) == 0:
        return False
    if mat:

        return True

    else:
        return False


def getpassword(value):
    password = input("Enter " + value + " : \n")
    while not validpassword(password):
        print("Invalid Password. Please enter correct format: \n")
        password = input("Enter " + value + " : \n")
    return password


# hash password

def hashpassword(password):
    salt = b'-\xe1{\x96\t\xe7\xc8\xc7z:\x8d\xe4@9!\xbc\x1e\xe0\xaek\xf2\xc9\x06=,\x1bs\xf6\x19\x84\xdd8'

    plaintext = password.encode()

    digest = hashlib.pbkdf2_hmac('sha256', plaintext, salt, 10000)

    hex_hash = digest.hex()
    return hex_hash


firstName = getName("First")
lastName = getName("Last")
firstInteger = getInt("First")
secondInteger = getInt("Second")

inputFileName = getfilename("input")
outputFileName = getfilename("output")
password1 = getpassword(" your password")
passwordHash1 = hashpassword(password1)
f = open(inputFileName, "w")
f.write(passwordHash1)
f.close()
verifyPassword = getpassword(" your password to verify")
passwordHash2 = hashpassword(verifyPassword)

# read passwordHash1 from input file
f = open(inputFileName, "r")
data = f.read()
while data != passwordHash2:
    print("Password is invalid\n")
    verifyPassword = getpassword(" your password to verify")
    passwordHash2 = hashpassword(verifyPassword)
f.close()

# open output file and write to it
fw = open(outputFileName, "a")
fw.write("# writing to the output file\n")
fw.write("First name: " + firstName + "\n")
fw.write("Last name: " + lastName + "\n")
fw.write("First integer: " + str(firstInteger) + "\n")
fw.write("Second integer: " + str(secondInteger) + "\n")
fw.write("Sum: " + str(firstInteger + secondInteger) + "\n")
fw.write("Product: " + str(firstInteger * secondInteger) + "\n")
fw.write("Input file: " + inputFileName + "\n")
fw.write("Input file contents:\n")
# Read the contents of the input file and write it to the output file
f = open(inputFileName, "r")
content = f.read()
f.close()
fw.write(content)

fw.close()
