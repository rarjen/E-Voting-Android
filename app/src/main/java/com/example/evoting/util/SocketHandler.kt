package com.example.evoting.util

import android.util.Log
import io.socket.client.Socket
import io.socket.client.IO
import java.net.URISyntaxException

object SocketHandler {

    lateinit var mSocket: Socket

    @Synchronized
    fun setSocket() {
        try {
            mSocket = IO.socket("http://10.0.2.2:3000")
        } catch (e: URISyntaxException) {
            Log.d("ERROR", "Error: $e")
        }
    }

    @Synchronized
    fun getSocket(): Socket {
        return mSocket
    }

    @Synchronized
    fun establishConnection() {
        mSocket.connect()
    }

    @Synchronized
    fun closeConnection() {
        mSocket.disconnect()
    }
}


