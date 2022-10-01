# Mobile-GamePad

Telnet Protocal: Telnet is a network protocol used to virtually access a computer and to provide a two-way connection 
                 A telnet is a emulation program that is used to access remote servers 
                 ↬ Command line tool 
                 ↬ No gui 
                 ↬ All commands send by keyboard 
                 ↬ Connection is very fast 
                 ↬ Mostly used in LAN

Socket: is an end point of communication between 2 devices, 
        if 2 computers wanna communicate with each other over a network then they need a socket at each of there ends

View - JoystickView - the view of the joystick.
MainActivity - The main View of the project.
utilities - OnJoystickChange interface.
viewModel - contains the MainViewModel.
Model - contains the model.

MVVM Architecture
Model
Communicates with the FlightGear server using telnet protocol.
Recieves commands from ViewModel and executes them.
The Model sends the commands to FlightGear simulator, and we see the airplane responds to these commands.
Commands sending is made by single threadpool.
Single threadpool creates an executor that uses single thread worker operating off an unbounded queue(if this single thread terminates due to a failure during execution prior to shutdown, a new one will take its place if needed to execute subsequent tasks.) 
Tasks are guaranteed to execute sequentially, and no more than one task will be active at any given time.

View 
The MainActivity is our main view which uses the JoystickView of joystick object. 
The MainActivity contains: 
↬ input text fields for IP address and connection port. 
↬ Connect Button. 
↬ Two seekBars for rudder and throttle. 
↬ JoystickView. 
To enable data binding we configured this option in the build.gradle(app).

Special features: 
Each time the joystick is freed after finger touch, it turns back to its initial location - to the center of the screen. 
In the JoystickApp we're using a logger named Timber. If the user enters a wrong input in the ip address field or in the port field we'll know the exact error, where it occured and when.

View Model 
View Model takes the data entered by user - IP address and connection port - via event listeners and by using data binding. 
The data binding to view model is made by different event listeners, that are listenning to all user's actions. Event listeners proccess the data and send appropriate commands to the Model.

Resources
Joystick's basis is the joystick layout which uses the drawable circle. 
The image view converts the drawable circle to image element and we place it in the layout.

This app is built-in MVVM Architecture: 
↬ View - The MainActivity is our main view which uses the JoystickView of joystick object. 
↬ MainActivity - is responsible for the avtivity_main.xml file to upload. It also connects the Joystick to the ViewModel 
↬ Joystick - is responsible for the joystick to move and send in the end to the Service.onChange the changes that happened. (if the joystick moved) 
↬ ModelFlight - is responsible to connect to the FlightGear and send requests. 
↬ ViewModel - is responsible to connect between the view (MainActivity) and the model (ModelFlight)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
Libraries used: 
↬ Vertical SeekBar v1.0.0 - https://github.com/h6ah4i/android-verticalseekbar
↬ Virtual Joystick Android v1.10.1 - https://github.com/controlwear/virtual-joystick-android
