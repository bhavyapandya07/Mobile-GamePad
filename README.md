# Mobile-GamePad
<br>Here is the Explanation of the App👇🏻
<br>Telnet Protocal: <br>Telnet is a network protocol used to virtually access a computer and to provide a two-way connection
                 <br>A telnet is a emulation program that is used to access remote servers<br> 
                 ✔️ Command line tool<br>
                 ✔️ No gui<br> 
                 ✔️ All commands send by keyboard<br> 
                 ✔️ Connection is very fast<br> 
                 ✔️ Mostly used in LAN<br>

Socket: <br>is an end point of communication between 2 devices, 
        if 2 computers wanna communicate with each other over a network then they need a socket at each of there ends
        
<br>View - JoystickView - the view of the joystick.
<br>MainActivity - The main View of the project.
<br>utilities - OnJoystickChange interface.
<br>viewModel - contains the MainViewModel.
<br>Model - contains the model.

<br>MVVM Architecture:
<br>Model:
<br>Communicates with the FlightGear server using telnet protocol.
<br>Recieves commands from ViewModel and executes them.
<br>The Model sends the commands to FlightGear simulator, and we see the airplane responds to these commands.
<br>Commands sending is made by single threadpool.
<br>Single threadpool creates an executor that uses single thread worker operating off an unbounded queue(if this single thread terminates due to a failure during execution prior to shutdown, a new one will take its place if needed to execute subsequent tasks.) 
<br>Tasks are guaranteed to execute sequentially, and no more than one task will be active at any given time.

<br>View: 
<br>The MainActivity is our main view which uses the JoystickView of joystick object. 
<br>The MainActivity contains: 
<br>✔️ input text fields for IP address and connection port. 
<br>✔️ Connect Button. 
<br>✔️ Two seekBars for rudder and throttle. 
<br>✔️ JoystickView. 
<br>✔️ enable data binding we configured this option in the build.gradle(app).

<br>Special features: 
<br>Each time the joystick is freed after finger touch, it turns back to its initial location - to the center of the screen. 
<br>In the JoystickApp we're using a logger named Timber. If the user enters a wrong input in the ip address field or in the port field we'll know the exact error, where it occured and when.

<br>View Model:
<br>View Model takes the data entered by user - IP address and connection port - via event listeners and by using data binding. 
<br>The data binding to view model is made by different event listeners, that are listenning to all user's actions. Event listeners proccess the data and send appropriate commands to the Model.

<br>Resources:
<br>Joystick's basis is the joystick layout which uses the drawable circle. 
<br>The image view converts the drawable circle to image element and we place it in the layout.

<br>This app is built-in MVVM Architecture: 
<br>✔️ View - The MainActivity is our main view which uses the JoystickView of joystick object. 
<br>✔️ MainActivity - is responsible for the avtivity_main.xml file to upload. It also connects the Joystick to the ViewModel 
<br>✔️ Joystick - is responsible for the joystick to move and send in the end to the Service.onChange the changes that happened. (if the joystick moved) 
<br>✔️ ModelFlight - is responsible to connect to the FlightGear and send requests. 
<br>✔️ ViewModel - is responsible to connect between the view (MainActivity) and the model (ModelFlight)

Libraries used: 
<br>✔️ Vertical SeekBar v1.0.0 - https://github.com/h6ah4i/android-verticalseekbar
<br>✔️ Virtual Joystick Android v1.10.1 - https://github.com/controlwear/virtual-joystick-android

<br>Here is the Working of the App👇🏻
[Virtual_Gamepad_-_Presentation.pptx](https://github.com/CyberWarrior743/Mobile-GamePad/files/9690967/Virtual_Gamepad_-_Presentation.pptx)
<br>https://user-images.githubusercontent.com/80274814/193424042-563995c5-9f46-4fed-8ab4-50e454d0c60f.mp4
