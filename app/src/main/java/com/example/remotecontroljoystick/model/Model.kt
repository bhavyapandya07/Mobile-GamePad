package com.example.remotecontroljoystick.model
//all libr
import com.example.remotecontroljoystick.viewModel.MainViewModel
import java.io.PrintWriter
import java.lang.Exception
import java.net.Socket
import java.util.concurrent.LinkedBlockingQueue

class Model (private val vm: MainViewModel) {
    private lateinit var client : Socket //var define
    private lateinit var printWriter : PrintWriter
    private var dispatchQueue = LinkedBlockingQueue<Runnable>()
    private var stopTaking = false
    private var stopAdding = false

    init {
        // dispatch loop of the active object
        //connection connected till the user doesnt stop
        Thread {
            while (!stopTaking) {
                dispatchQueue.take().run()
            }
        }.start()
    }
// connection close
    fun stopClient() {
        if (!stopAdding) {
            addJobToQueue(Runnable {
                printWriter.close()
                client.close()
                stopTaking = true
            })
            // prevent more jobs from being added
            stopAdding = true
        }
    }
//user input taken as fcfs
    private fun addJobToQueue(job : Runnable) {
        if (!stopAdding)
            dispatchQueue.put(job)
    }
//connection establish ip and port
    fun startClient(ip: String, port: Int) {
        addJobToQueue(Runnable {
            try {
                client = Socket(ip, port)
                printWriter = PrintWriter(client.getOutputStream())
                // update vieModel about successful connection
                vm.clientConnected.postValue(true)
            } catch (e : Exception) {}
        })
    }
//if the user is connected then sends the command to queue
    fun sendCommand(command: String) {
        if (this::client.isInitialized) {
            addJobToQueue(Runnable {
                printWriter.write(command)
                printWriter.flush()
            })
        }
    }
}