package com.example.nayap7

import android.app.Application
import com.example.nayap7.dependenciesinjection.ContainerApp
import com.example.nayap7.dependenciesinjection.InterfaceContainerApp

class KrsApp : Application() {
    //Fungsinya untuk menyimpan instance containerApp
    lateinit var containerApp: ContainerApp

    override fun onCreate() {
        super.onCreate()
        //membuat instance containerApp
        containerApp = ContainerApp(this)
        //instance adalah yang dibuat dari class
    }
}