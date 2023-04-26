# 🎮 Mobile-GamePad

Here is the explanation of the app 👇🏻

🔸 **Telnet Protocol**: Telnet is a network protocol used to virtually access a computer and to provide a two-way connection. A telnet is an emulation program that is used to access remote servers.

✔️ Command line tool<br>
✔️ No GUI<br> 
✔️ All commands sent by keyboard<br> 
✔️ Connection is very fast<br> 
✔️ Mostly used in LAN<br>

🔸 **Socket**: Socket is an endpoint of communication between 2 devices. If 2 computers want to communicate with each other over a network, then they need a socket at each of their ends.

🔸 **View-JoystickView**: The view of the joystick.

🔸 **MainActivity**: The main view of the project.

🔸 **Utilities**: OnJoystickChange interface.

🔸 **ViewModel**: Contains the MainViewModel.

🔸 **Model**: Contains the model.

🔸 **MVVM Architecture**:

**Model:**
- Communicates with the FlightGear server using telnet protocol.
- Receives commands from ViewModel and executes them.
- The Model sends the commands to FlightGear simulator, and we see the airplane respond to these commands.
- Commands sending is made by a single thread pool.
- Single thread pool creates an executor that uses a single thread worker operating off an unbounded queue. If this single thread terminates due to a failure during execution prior to shutdown, a new one will take its place if needed to execute subsequent tasks. 
- Tasks are guaranteed to execute sequentially, and no more than one task will be active at any given time.

**View:**
- The MainActivity is our main view which uses the JoystickView of the joystick object. 
- The MainActivity contains: 
  - Input text fields for IP address and connection port. 
  - Connect Button. 
  - Two seekBars for rudder and throttle. 
  - JoystickView. 
  - Enable data binding, we configured this option in the build.gradle(app).

🔸 **Special Features:**
- Each time the joystick is freed after finger touch, it turns back to its initial location - to the center of the screen. 
- In the JoystickApp, we're using a logger named Timber. If the user enters wrong input in the IP address field or in the port field, we'll know the exact error, where it occurred and when.

🔸 **ViewModel:**
- ViewModel takes the data entered by the user - IP address and connection port - via event listeners and by using data binding. 
- The data binding to view model is made by different event listeners, that are listening to all user's actions. Event listeners process the data and send appropriate commands to the Model.

🔸 **Resources:**
- Joystick's basis is the joystick layout which uses the drawable circle. 
- The image view converts the drawable circle to an image element, and we place it in the layout.

<br>This app is built-in MVVM Architecture: 
<br>✔️ View - The MainActivity is our main view which uses the JoystickView of joystick object. 
<br>✔️ MainActivity - is responsible for the avtivity_main.xml file to upload. It also connects the Joystick to the ViewModel 
<br>✔️ Joystick - is responsible for the joystick to move and send in the end to the Service.onChange the changes that happened. (if the joystick moved) 
<br>✔️ ModelFlight - is responsible to connect to the FlightGear and send requests. 
<br>✔️ ViewModel - is responsible to connect between the view (MainActivity) and the model (ModelFlight)

🔸 **Libraries Used:**
- Vertical SeekBar v1.0.0 - https://github.com/h6ah4i/android-verticalseekbar
- Virtual Joystick Android v1.10.1 - https://github.com/controlwear/virtual-joystick-android

🔸 **Application APK:**<br>
[Virtual Gamepad.zip](https://github.com/CyberWarrior743/Mobile-GamePad/files/10146780/Virtual.Gamepad.zip)

🔸 **Flight Game Link:**<br>
https://www.flightgear.org/

🔸**Here is the Working of the App:**<br>
[Virtual_Gamepad_-_Presentation.pptx](https://github.com/CyberWarrior743/Mobile-GamePad/files/9690967/Virtual_Gamepad_-_Presentation.pptx)
<br>https://user-images.githubusercontent.com/80274814/193424042-563995c5-9f46-4fed-8ab4-50e454d0c60f.mp4
