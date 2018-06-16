package org.usfirst.frc.team3039.robot.subsystems;

import edu.wpi.first.wpilibj.networktables.NetworkTable;


public class VisionProcessor {
	
	double centerX; 
	double centerY;
	double width; 
	double area; 
	double height;
	NetworkTable table;
	
	public VisionProcessor(NetworkTable table){
	//	this.table = table;
		double[] defaultValue = new double[0];
		//centerX = table.getNumberArray("centerX", defaultValue)[0];
		
//		centerY = table.getNumberArray("centerY", defaultValue)[0];
//		area = table.getNumberArray("area", defaultValue)[0];
//		width = table.getNumberArray("width", defaultValue)[0];
//		height = table.getNumberArray("height", defaultValue)[0];
		//System.out.println(table.getNumberArray("area",defaultValue).length);


	}
	
	
	

}
