package com.example.myapplication.model
import java.io.IOException
import java.io.OutputStream
import java.lang.Exception
import java.net.InetSocketAddress
import java.net.Socket

class Client() {
    private  var client: Socket = Socket()

    private lateinit var writer: OutputStream
    private fun isConnected() :Boolean{
        return client.isConnected
    }
    fun connect(ip: String, port: Int){
        if(!isConnected()) {
                client.connect(InetSocketAddress(ip, port))
                writer = client.getOutputStream()
                println("Connected")
        }
    }
    fun disconnect(){
        if(this.isConnected()) {
            writer.close()
            client.close()
            client = Socket()
        }
    }
    fun write(message: String) {
        if (isConnected()) {
            try {
                writer.write(message.toByteArray())
            } catch (e: IOException){
                disconnect()
            }
        }
    }
}

