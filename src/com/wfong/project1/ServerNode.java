package com.wfong.project1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.wfong.glamourPrint.GlamourPrint;

/**
 * This class reads data from incoming client connections and prints it out to System out
 * @author William Fong
 *
 */
public class ServerNode extends Node implements Runnable {
	private InetAddress serverAddress;
	
	/**
	 * This constructor allows manual specification of the Node Name and Port for the Server Socket
	 * @param nodeName The Node's Name
	 * @param port The Server Port number for connection requests
	 */
	public ServerNode(String nodeName, int port) {
		super(nodeName);
		serverAddress = getLocalAddress();
		this.addServerSocket(port, serverAddress);
		
	}
	
	/**
	 * This constructor creates a server node using a config file
	 * @param nodeName The Node's Name
	 * @param FilePath The file path to the config file
	 * @throws NumberFormatException Is thrown when the config file's port number section is incorrectly formatted
	 * @throws IOException Is thrown when the config file does not exist
	 */
	public ServerNode(String nodeName, String FilePath) throws NumberFormatException, IOException {
		super(nodeName);
		serverAddress = getLocalAddress();
		FileReader configFile = new FileReader(FilePath);
		BufferedReader configSettings = new BufferedReader(configFile);
		int port = Integer.parseInt(configSettings.readLine());
		this.addServerSocket(port, serverAddress);
		configSettings.close();
	}
	
	/**
	 * This method returns the local host address
	 * @return The LocalHost IP
	 * @TODO Move this method to the Node Superclass, it is used by all of the subclasses
	 */
	public InetAddress getLocalAddress() {
		try {
			return InetAddress.getByName("::1");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void run() {
		readSocket();
		System.out.println(this.getNodeName() + ": " + GlamourPrint.badString("exiting."));
	}
}
