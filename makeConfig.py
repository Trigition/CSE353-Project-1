#!/usr/bin/env python
import string
import random
import argparse

parser = argparse.ArgumentParser(description="Options for the creation of Project Configuration files")
parser.add_argument("line_count", type=int, default=10, help="The number of lines of data to create for configuration files")
parser.add_argument("line_length", type=int, default=10 ,help="The length of each line of data")
args = parser.parse_args()

def generate_lines(n, length=20):
    lines = []
    for i in range(n):
        randString = "".join(random.choice(string.ascii_uppercase + string.ascii_lowercase + string.digits) for _ in range(length))
        lines.append(randString)
    return lines    

def make_config(filename, conn_port=None, acc_port=None, n=10, length=100):
    lines = generate_lines(n=n, length=length)
    config_file = open(filename, "w")
    i = 0
    if conn_port:
        config_file.write(conn_port + "\n")
    if acc_port:
        config_file.write(acc_port + "\n")
    for line in lines:
        config_file.write("Line " + str(i) + ": " + line + "\n")
        i += 1


print "Creating configuration files..."
print "Number of lines of data:", args.line_count
print "Length of lines:", args.line_length

make_config("confA.txt", conn_port="4000")
make_config("confB.txt", conn_port="4000", acc_port="6000")
make_config("confC.txt", acc_port="6000", n=0,length=0)

print "Created configs!"
