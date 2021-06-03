package com.santy.mvvmprueba.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.santy.mvvmprueba.Model.MailModel
import com.santy.mvvmprueba.Model.MailProvider

class MailModel: ViewModel() {
    val messageModel = MutableLiveData<MailModel>()

    fun randomMessage(){
        val currentModel = MailProvider.random()
        messageModel.postValue(currentModel[1])
    }
}