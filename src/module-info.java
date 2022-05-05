
module Pro4Tech {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.desktop;
	requires javafx.fxml;
	requires javafx.web;
	requires javafx.base;
	requires java.sql;
        requires mysql.connector.java;
        requires openjfx;
        requires openjfx.18.windows.x64.bin.sdk;
	
	opens fxml;
	opens controllers;
	opens view;
	opens Factory;
	opens Dao;

	
}