package com.xml.serverlist.ServerListApp.config;

public class Config {
	public static final String DATABASE_FILE = "/home/obodnariu/git/XMLServerlist/database/servers.xml";
	public final static String API_INFO = "<!DOCTYPE html>\n" + 
			"<html>\n" + 
			"<head>\n" + 
			"<style>\n" + 
			"table {\n" + 
			"  font-family: arial, sans-serif;\n" + 
			"  border-collapse: collapse;\n" + 
			"  width: 100%;\n" + 
			"}\n" + 
			"\n" + 
			"td, th {\n" + 
			"  border: 1px solid #dddddd;\n" + 
			"  text-align: left;\n" + 
			"  padding: 8px;\n" + 
			"}\n" + 
			"\n" + 
			"tr:nth-child(even) {\n" + 
			"  background-color: #dddddd;\n" + 
			"}\n" + 
			"</style>\n" + 
			"</head>\n" + 
			"<body>\n" + 
			"\n" + 
			"<h2>API Cheat Sheet</h2>\n" + 
			"\n" + 
			"<table>\n" + 
			"  <tr>\n" + 
			"    <th>API</th>\n" + 
			"    <th>Description</th>\n" + 
			"  </tr>\n" + 
			"  <tr>\n" + 
			"    <td>/</td>\n" + 
			"    <td>Root element, display the home page.</td>\n" + 
			"  </tr>\n" + 
			"  <tr>\n" + 
			"    <td>/api_info</td>\n" + 
			"    <td>Util info about the API.</td>\n" + 
			"  </tr>\n" + 
			"  <tr>\n" + 
			"    <td>/xml/all</td>\n" + 
			"    <td>Displays all the info in the database.</td>\n" + 
			"  </tr>\n" + 
			"  <tr>\n" + 
			"    <td>/xml/name/$variable</td>\n" + 
			"    <td>Displays all the servers for a game.</td>\n" + 
			"  </tr>\n" + 
			"  <tr>\n" + 
			"    <td>/xml/address/$address</td>\n" + 
			"    <td>Displayes the server with the $address id.</td>\n" + 
			"  </tr>\n" + 
			"  <tr>\n" + 
			"    <td>/xml/post/$id/$game/$servername/$address/$players/$playersMax/$votes/$version</td>\n" + 
			"    <td>Adds a new element to the database.</td>\n" + 
			"  </tr>\n" + 
			"  <tr>\n" + 
			"    <td>/xml/delete/$id</td>\n" + 
			"    <td>Deletes the server with $id from the database.</td>\n" + 
			"  </tr>\n" + 
			"  <tr>\n" + 
			"    <td>/xml/test_db</td>\n" + 
			"    <td>Runs test of the database.</td>\n" + 
			"  </tr>\n" + 
			"  <tr>\n" + 
			"    <td>/xml/raw</td>\n" + 
			"    <td>Displays the xml file.</td>\n" + 
			"  </tr>\n" + 
			"  <tr>\n" + 
			"    <td>/xml/dummy_table</td>\n" + 
			"    <td>Tests the UI using dummy data.</td>\n" + 
			"  </tr>\n" + 
			"  \n" + 
			"</table>\n" + 
			"\n" + 
			"</body>\n" + 
			"</html>";
}
