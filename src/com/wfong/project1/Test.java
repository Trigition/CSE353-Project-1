package com.wfong.project1;

import java.io.IOException;
import java.lang.Thread;

/**
 * This class is for testing the Node network
 * @author William Fong
 * @TODO Create class for generating config files...
 */
public class Test {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		ServerNode server;
		RelayNode relay;
		SenderNode client;
		try {	
			Thread ClientThread = new Thread(client = new SenderNode("Node A", "confA.txt"));
			ClientThread.start();
			Thread RelayThread = new Thread(relay  = new RelayNode("Node B", "confB.txt"));
			RelayThread.start();
			Thread ServerThread = new Thread(server = new ServerNode("Node C", "confC.txt"));
			ServerThread.start();
		} catch (NumberFormatException e) {
			System.err.println("Error! Could not construct nodes, improper Config Files present");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error! Could not find config files!");
			e.printStackTrace();
		}
	}
}