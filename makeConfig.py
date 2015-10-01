#!/usr/bin/env python
import string
import random

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

make_config("confA.txt", conn_port="4000")
make_config("confB.txt", conn_port="4000", acc_port="6000")
make_config("confC.txt", acc_port="6000", n=0,length=0)
