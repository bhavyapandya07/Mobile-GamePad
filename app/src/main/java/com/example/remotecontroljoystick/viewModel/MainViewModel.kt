package com.example.remotecontroljoystick.viewModel

import android.widget.SeekBar
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.remotecontroljoystick.model.Model
import kotlin.properties.Delegates

class MainViewModel : ViewModel() {

    private var _aileron: Float = 0.0f
    private var _elevator: Float = 0.0f
    private var model = Model(this)

    val clientConnected = MutableLiveData<Boolean>()

    fun startClientViewModel(ip: String, port: Int) {
        model.startClient(ip, port)
    }
    fun onThrottleChanged (seekbar : SeekBar, progress : Int, fromUser : Boolean) {
        model.sendCommand("set /controls/engines/current-engine/throttle ${progress/100f}\r\n")
    }
    fun onRudderChanged (seekbar : SeekBar, progress : Int, fromUser : Boolean) {
        model.sendCommand("set /controls/flight/rudder ${progress/100f}\r\n")
    }
    // aileron changed callback
    var aileron: Float by Delegates.observable(_aileron) { _, _, new ->
        model.sendCommand("set /controls/flight/aileron $new\r\n")
    }
    // elevator changed callback
    var elevator: Float by Delegates.observable(_elevator) { _, _, new ->
        model.sendCommand("set /controls/flight/elevator $new\r\n")
    }
}