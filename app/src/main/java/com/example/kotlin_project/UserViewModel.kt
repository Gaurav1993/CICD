package com.example.kotlin_project

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(var userRepository: UserRepository): ViewModel()
{

    private var _users = MutableLiveData<List<User>>()
    val users: MutableLiveData<List<User>> get() = _users


    fun getUsers() {
        viewModelScope.launch {
            _users.value = userRepository.getAlluser()

        }
    }

    fun insert(user: User)
    {
        viewModelScope.launch {
            userRepository.insert(user)
        }
    }
}