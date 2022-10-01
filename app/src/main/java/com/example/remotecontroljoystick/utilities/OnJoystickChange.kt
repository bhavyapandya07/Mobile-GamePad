package com.example.remotecontroljoystick.utilities
// functional interface for joystick movement
fun interface OnJoystickChange {
    fun invoke(aileron : Float, elevator : Float)
}