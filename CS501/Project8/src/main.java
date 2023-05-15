/**Author: Sijie Yu
 * Course: CS-501 WS4
 * Description: A JavaFX Application 
 */


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class main extends Application{
    //set PI
	public static double PI = 3.14159;
	
	//three output varable
	public double SurfaceArea;
	public double Circumference;
	public double CWeight;
	
	//Button for Display the output
	private Button btnDisplay;
	
	//RadioButton for user to choose
	private RadioButton planet1;
	private RadioButton planet2;
	private RadioButton planet3;
	private RadioButton planet4;
	private RadioButton planet5;
	private RadioButton planet6;
	private RadioButton planet7;
	private RadioButton planet8;
	
    //used to choose only on RadioButton
	private ToggleGroup planetGroup;
	
	//CheckBox for user to choose one or more
	private CheckBox surfaceArea;
	private CheckBox cir;
	private CheckBox distanceFromSun;
	private CheckBox corWeight;
	
	//TextArea that displays the output
	private TextArea outputArea;
	
	//text content of output
	private String text = "";
	
    //Alert Window to tell users all exception
    private Alert alert = new Alert(Alert.AlertType.WARNING);
    
    //Input derived from TextArea to calculate
	public double Input;
	
	//Input derived from TextArea
	private String input;
	
	//Input FIle
    InputFile file;
    
    //initialize the TextField
    TextField userWeight = new TextField();
    
    //main function to launch the JavaFX Application
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch(args);
	}
	
	//override start function to show the app content
	@Override
	public void start(Stage primaryStage) throws IOException{
		//initialize the InputFile instance
		file = new InputFile();
		
		//read the file and process possible exceptions
		try {
			file.setData();
		} catch (FileNotFoundException e) {
			//if can't find file, warn the user and close the application
			alert.setContentText("SORRY, Can Not Find the File: " + file.file.getName());
			System.exit(0);
		}
		
		//set the titile of the application
		primaryStage.setTitle("PLANET INFORMATION");
		
		//initialize all needed RadioButton instance
		planet1 = new RadioButton("Mercury");
		planet2 = new RadioButton("Venus");
		planet3 = new RadioButton("Earth");
		planet4 = new RadioButton("Mars");
		planet5 = new RadioButton("Jupiter");
		planet6 = new RadioButton("Saturn");
		planet7 = new RadioButton("Uranus");
		planet8 = new RadioButton("Neptune");
		
		planetGroup = new ToggleGroup();
		
		//add all RadioButton to the ToggleGroup so that user can only choose one of them
		planet1.setToggleGroup(planetGroup);
		planet2.setToggleGroup(planetGroup);
		planet3.setToggleGroup(planetGroup);
		planet4.setToggleGroup(planetGroup);
		planet5.setToggleGroup(planetGroup);
		planet6.setToggleGroup(planetGroup);
		planet7.setToggleGroup(planetGroup);
		planet8.setToggleGroup(planetGroup);
		
		//initialize all needed CheckBox instance
		surfaceArea = new CheckBox("Surface Area");
		cir = new CheckBox("Circumference");
		distanceFromSun = new CheckBox("Distance from Sun");
		corWeight = new CheckBox("Corresponding Weight in kg");
		
		//create two Labels of subtitle
		Label planetLabel = new Label("Choose a Planet");
		Label displayLabel = new Label("Display");
		
		//initialize the button for display
		btnDisplay = new Button("Display");
		
		//initialize the outputArea instance
		outputArea = new TextArea();
		
		//set the size of outputArea
		outputArea.setPrefColumnCount(20);
		outputArea.setPrefRowCount(10);
		
		//create three gridpane for better layout
		GridPane gridpane = new GridPane();
		GridPane gridpane2 = new GridPane();
		GridPane gridpane3 = new GridPane();
		
		//gridpane2 is used to store all RadioButton
		gridpane2.add(planet1, 0, 0);
		gridpane2.add(planet2, 0, 1);
		gridpane2.add(planet3, 0, 2);
		gridpane2.add(planet4, 0, 3);
		gridpane2.add(planet5, 0, 4);
		gridpane2.add(planet6, 0, 5);
		gridpane2.add(planet7, 0, 6);
		gridpane2.add(planet8, 0, 7);
		
		//gridpane3 is used to store all checkbox
		gridpane3.add(surfaceArea, 0, 0);
		gridpane3.add(cir, 0, 1);
		gridpane3.add(distanceFromSun, 0, 2);
		gridpane3.add(corWeight, 0, 3);
		gridpane3.add(userWeight, 0, 4);
		
		//gridpane store all user options about planet 
		gridpane.add(planetLabel, 0, 0);
		gridpane.add(gridpane2, 0, 1);
		gridpane.add(displayLabel, 1, 0);
		gridpane.add(gridpane3, 1, 1);
		
		//set up gap
		gridpane2.setHgap(10);
		gridpane2.setVgap(20);
		gridpane.setHgap(50);
		gridpane.setVgap(40);
		gridpane3.setVgap(40);
		
		//set up the whole layout by HBox
		HBox hbox = new HBox(30, gridpane, btnDisplay, outputArea);
		hbox.setAlignment(Pos.CENTER);
		
		//create the scene
		Scene scene = new Scene(hbox, 900, 500);
		
		//show the scene on the stage
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
		btnDisplay.setOnAction(new ButtonClickHandler());
		
	}
	
	//a function to decide if a string is numeric
	public boolean isMatched(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	//EventHandler for the button of display
	class ButtonClickHandler implements EventHandler<ActionEvent> {
		
		@Override
		public void handle(ActionEvent event) {
			
			//show the output according to the user's option
			if (planet1.isSelected()) {
				text = text + file.planetList.get(0).name + ": \n\n";
				if (surfaceArea.isSelected()) {
					SurfaceArea = Double.parseDouble(file.planetList.get(0).radius) * Double.parseDouble(file.planetList.get(0).radius) * 4 * PI;
					text = text + "Surface Area = " + SurfaceArea + " km sq \n\n";
				}
				if (cir.isSelected()) {
					Circumference = Double.parseDouble(file.planetList.get(0).radius) * 2 * PI;
					text = text + "Circumference = " + Circumference + " km \n\n";
				}
				if (distanceFromSun.isSelected()) {
					text = text + "Distance Form Sun = " + file.planetList.get(0).distanceFS + " AU \n\n";
				}
			    if (corWeight.isSelected()) {
			    	//get the user input in TextArea
					input = userWeight.getText();
					
					//process the possible NegativeInputValueException
					try {
						Input = Double.parseDouble(input);
						if (Input < 0) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						//warn the user and expect a valid input
						alert.setContentText("Negative Input!  Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					}
					
					//process the possible InputMismatchException
					try {
						if (!isMatched(input)) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						//warn the user and expect a valid input
						alert.setContentText("Invalid Input!  Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
				    }
					
					try {
						if (input == null || input.length() == 0) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						//warn the user and expect a valid input
						alert.setContentText("You haven't inputed anything ! Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
				    }
					CWeight = Double.parseDouble(input) * Double.parseDouble(file.planetList.get(0).weightRatio);
					text = text + "Converted weight = " + CWeight + " kg \n\n";
				}
				
			    //show the output
				outputArea.setText(text);
				
				//clear the content in TextArea
				text = "";
			}
			
			//All same as above
			if (planet2.isSelected()) {
				text = text + file.planetList.get(1).name + ": \n\n";
				if (surfaceArea.isSelected()) {
					SurfaceArea = Double.parseDouble(file.planetList.get(1).radius) * Double.parseDouble(file.planetList.get(1).radius) * 4 * PI;
					text = text + "Surface Area = " + SurfaceArea + " km sq \n\n";
				}
				if (cir.isSelected()) {
					Circumference = Double.parseDouble(file.planetList.get(1).radius) * 2 * PI;
					text = text + "Circumference = " + Circumference + " km \n\n";
				}
				if (distanceFromSun.isSelected()) {
					text = text + "Distance Form Sun = " + file.planetList.get(1).distanceFS + " AU \n\n";
				}
			    if (corWeight.isSelected()) {
					input = userWeight.getText();
					try {
						Input = Double.parseDouble(input);
						if (Input < 0) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("Negative Input!  Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					}
					
					try {
						if (!isMatched(input)) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("Invalid Input!  Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					
				    }
					
					try {
						if (input == null || input.length() == 0) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("You haven't inputed anything ! Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					
				    }
					CWeight = Double.parseDouble(input) * Double.parseDouble(file.planetList.get(1).weightRatio);
					text = text + "Converted weight = " + CWeight + " kg \n\n";
				}
				
				outputArea.setText(text);
				
				text = "";
			}
			
			if (planet3.isSelected()) {
				text = text + file.planetList.get(2).name + ": \n\n";
				if (surfaceArea.isSelected()) {
					SurfaceArea = Double.parseDouble(file.planetList.get(2).radius) * Double.parseDouble(file.planetList.get(2).radius) * 4 * PI;
					text = text + "Surface Area = " + SurfaceArea + " km sq \n\n";
				}
				if (cir.isSelected()) {
					Circumference = Double.parseDouble(file.planetList.get(2).radius) * 2 * PI;
					text = text + "Circumference = " + Circumference + " km \n\n";
				}
				if (distanceFromSun.isSelected()) {
					text = text + "Distance Form Sun = " + file.planetList.get(2).distanceFS + " AU \n\n";
				}
			    if (corWeight.isSelected()) {
					input = userWeight.getText();
					try {
						Input = Double.parseDouble(input);
						if (Input < 0) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("Negative Input!  Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					}
					
					try {
						if (!isMatched(input)) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("Invalid Input!  Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					
				    }
					
					try {
						if (input == null || input.length() == 0) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("You haven't inputed anything ! Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					
				    }
					CWeight = Double.parseDouble(input) * Double.parseDouble(file.planetList.get(2).weightRatio);
					text = text + "Converted weight = " + CWeight + " kg \n\n";
				}
				
				outputArea.setText(text);
				
				text = "";
			}
			
			if (planet4.isSelected()) {
				text = text + file.planetList.get(3).name + ": \n\n";
				if (surfaceArea.isSelected()) {
					SurfaceArea = Double.parseDouble(file.planetList.get(3).radius) * Double.parseDouble(file.planetList.get(3).radius) * 4 * PI;
					text = text + "Surface Area = " + SurfaceArea + " km sq \n\n";
				}
				if (cir.isSelected()) {
					Circumference = Double.parseDouble(file.planetList.get(3).radius) * 2 * PI;
					text = text + "Circumference = " + Circumference + " km \n\n";
				}
				if (distanceFromSun.isSelected()) {
					text = text + "Distance Form Sun = " + file.planetList.get(3).distanceFS + " AU \n\n";
				}
			    if (corWeight.isSelected()) {
					input = userWeight.getText();
					try {
						Input = Double.parseDouble(input);
						if (Input < 0) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("Negative Input!  Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					}
					
					try {
						if (!isMatched(input)) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("Invalid Input!  Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					
				    }
					
					try {
						if (input == null || input.length() == 0) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("You haven't inputed anything ! Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					
				    }
					CWeight = Double.parseDouble(input) * Double.parseDouble(file.planetList.get(3).weightRatio);
					text = text + "Converted weight = " + CWeight + " kg \n\n";
				}
				
				outputArea.setText(text);
				
				text = "";
			}
			
			if (planet5.isSelected()) {
				text = text + file.planetList.get(4).name + ": \n\n";
				if (surfaceArea.isSelected()) {
					SurfaceArea = Double.parseDouble(file.planetList.get(4).radius) * Double.parseDouble(file.planetList.get(4).radius) * 4 * PI;
					text = text + "Surface Area = " + SurfaceArea + " km sq \n\n";
				}
				if (cir.isSelected()) {
					Circumference = Double.parseDouble(file.planetList.get(4).radius) * 2 * PI;
					text = text + "Circumference = " + Circumference + " km \n\n";
				}
				if (distanceFromSun.isSelected()) {
					text = text + "Distance Form Sun = " + file.planetList.get(4).distanceFS + " AU \n\n";
				}
			    if (corWeight.isSelected()) {
					input = userWeight.getText();
					try {
						Input = Double.parseDouble(input);
						if (Input < 0) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("Negative Input!  Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					}
					
					try {
						if (!isMatched(input)) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("Invalid Input!  Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					
				    }
					
					try {
						if (input == null || input.length() == 0) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("You haven't inputed anything ! Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					
				    }
					CWeight = Double.parseDouble(input) * Double.parseDouble(file.planetList.get(4).weightRatio);
					text = text + "Converted weight = " + CWeight + " kg \n\n";
				}
				
				outputArea.setText(text);
				
				text = "";
			}
			
			if (planet6.isSelected()) {
				text = text + file.planetList.get(5).name + ": \n\n";
				if (surfaceArea.isSelected()) {
					SurfaceArea = Double.parseDouble(file.planetList.get(5).radius) * Double.parseDouble(file.planetList.get(5).radius) * 4 * PI;
					text = text + "Surface Area = " + SurfaceArea + " km sq \n\n";
				}
				if (cir.isSelected()) {
					Circumference = Double.parseDouble(file.planetList.get(5).radius) * 2 * PI;
					text = text + "Circumference = " + Circumference + " km \n\n";
				}
				if (distanceFromSun.isSelected()) {
					text = text + "Distance Form Sun = " + file.planetList.get(5).distanceFS + " AU \n\n";
				}
			    if (corWeight.isSelected()) {
					input = userWeight.getText();
					try {
						Input = Double.parseDouble(input);
						if (Input < 0) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("Negative Input!  Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					}
					
					try {
						if (!isMatched(input)) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("Invalid Input!  Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					
				    }
					
					try {
						if (input == null || input.length() == 0) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("You haven't inputed anything ! Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					
				    }
					CWeight = Double.parseDouble(input) * Double.parseDouble(file.planetList.get(5).weightRatio);
					text = text + "Converted weight = " + CWeight + " kg \n\n";
				}
				
				outputArea.setText(text);
				
				text = "";
			}
			
			
			
			if (planet7.isSelected()) {
				text = text + file.planetList.get(6).name + ": \n\n";
				if (surfaceArea.isSelected()) {
					SurfaceArea = Double.parseDouble(file.planetList.get(6).radius) * Double.parseDouble(file.planetList.get(6).radius) * 4 * PI;
					text = text + "Surface Area = " + SurfaceArea + " km sq \n\n";
				}
				if (cir.isSelected()) {
					Circumference = Double.parseDouble(file.planetList.get(6).radius) * 2 * PI;
					text = text + "Circumference = " + Circumference + " km \n\n";
				}
				if (distanceFromSun.isSelected()) {
					text = text + "Distance Form Sun = " + file.planetList.get(6).distanceFS + " AU \n\n";
				}
			    if (corWeight.isSelected()) {
					input = userWeight.getText();
					try {
						Input = Double.parseDouble(input);
						if (Input < 0) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("Negative Input!  Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					}
					
					try {
						if (!isMatched(input)) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("Invalid Input!  Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					
				    }
					
					try {
						if (input == null || input.length() == 0) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("You haven't inputed anything ! Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					
				    }
					CWeight = Double.parseDouble(input) * Double.parseDouble(file.planetList.get(6).weightRatio);
					text = text + "Converted weight = " + CWeight + " kg \n\n";
				}
				
				outputArea.setText(text);
				
				text = "";
			}
			
			if (planet8.isSelected()) {
				text = text + file.planetList.get(7).name + ": \n\n";
				if (surfaceArea.isSelected()) {
					SurfaceArea = Double.parseDouble(file.planetList.get(7).radius) * Double.parseDouble(file.planetList.get(7).radius) * 4 * PI;
					text = text + "Surface Area = " + SurfaceArea + " km sq \n\n";
				}
				if (cir.isSelected()) {
					Circumference = Double.parseDouble(file.planetList.get(7).radius) * 2 * PI;
					text = text + "Circumference = " + Circumference + " km \n\n";
				}
				if (distanceFromSun.isSelected()) {
					text = text + "Distance Form Sun = " + file.planetList.get(7).distanceFS + " AU \n\n";
				}
			    if (corWeight.isSelected()) {
					input = userWeight.getText();
					try {
						Input = Double.parseDouble(input);
						if (Input < 0) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("Negative Input!  Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					}
					
					try {
						if (!isMatched(input)) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("Invalid Input!  Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					
				    }
					
					try {
						if (input == null || input.length() == 0) {
							throw new IllegalArgumentException();
						}
					}catch (IllegalArgumentException e) {
						alert.setContentText("You haven't inputed anything ! Please Enter a valid number!");
						alert.show();
						userWeight.requestFocus();
					
				    }
					CWeight = Double.parseDouble(input) * Double.parseDouble(file.planetList.get(7).weightRatio);
					text = text + "Converted weight = " + CWeight + " kg \n\n";
				}
				
				outputArea.setText(text);
				
				text = "";
			}
			
			
			
			
		}
		
	}
}

	





