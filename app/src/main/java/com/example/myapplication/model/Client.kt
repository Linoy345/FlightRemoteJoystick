package com.example.myapplication.model

import java.io.OutputStream
import java.net.InetSocketAddress
import java.net.Socket
import java.util.concurrent.Executors

//TODO: Test this class.
class Client() {
    private  var client: Socket = Socket()
    private lateinit var writer: OutputStream
    constructor(ip: String, port: Int) : this() {
            client.connect(InetSocketAddress(ip, port))
            writer = client.getOutputStream()
    }
    private fun isConnected() :Boolean{
        return client.isConnected
    }
    fun connect(ip: String, port: Int){
        if(!isConnected()) {
            client.connect(InetSocketAddress(ip, port))
            writer = client.getOutputStream()
        }
    }
    fun disconnect(){
        client.close()
    }
    fun write(message: String){
        if(this.isConnected()) {
            val charset = Charsets.US_ASCII
            writer.write(message.toByteArray(charset))
        }
    }
}

