package com.xml.serverlist.html;

import java.util.List;

public class TableBuilder {
	public static int NUMBER_OF_COLS = 8;
	private static int added_cols = 0;
	private final String CSS = "<style>\n" + "table {\n" + "  font-family: arial, sans-serif;\n"
			+ "  border-collapse: collapse;\n" + "  width: 100%;\n" + "}\n" + "\n" + "td, th {\n"
			+ "  border: 1px solid #dddddd;\n" + "  text-align: left;\n" + "  padding: 8px;\n" + "}\n" + "\n"
			+ "tr:nth-child(even) {\n" + "  background-color: #dddddd;\n" + "}\n" + "</style>";

	private final String HTML_TABLE = "<h2>Servers List</h2><table>\n" + "<tr>\n" + "<th>id</th>    <th>Game</th>\n"
			+ "    <th>Name</th>\n" + "    <th>Address</th>\n" + "    <th>Players</th>\n" + "    <th>Max Players</th>\n"
			+ "    <th>Votes</th>\n" + "    <th>Version</th>\n" + "  </tr>\n";

	private StringBuilder customData = new StringBuilder();

	public TableBuilder appendCol(String col) {
		if (added_cols == 0) {
			beginCol();
		}
		if (added_cols == NUMBER_OF_COLS) {
			added_cols = 0;
			endCol();
		}
		customData.append("<td>" + col + "</td>");
		added_cols++;
		return this;
	}

	public TableBuilder appendCol(List<String> cols) {
		int added_cols = 0;
		customData.append("<tr>");
		for (String col : cols) {
			String aux_col = col.substring(2, col.length() - 4);
			String[] column = aux_col.split("\n");
			for(String c : column) {
				customData.append("<td>" + c + "</td>");
				added_cols++;
				if (added_cols == NUMBER_OF_COLS) {
					customData.append("</tr>");
					customData.append("<tr>");
					added_cols=0;
				}
			}
		}
		customData.append("</tr>");
		return this;
	}

	public TableBuilder endCol() {
		customData.append("</tr>");
		return this;
	}

	public TableBuilder beginCol() {
		customData.append("<tr>");
		return this;
	}

	public String buildTable() {
		return CSS + HTML_TABLE + customData.toString();
	}

}
