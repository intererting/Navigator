package com.yuliyang.navigator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    enum class AuthenticationState {
        AUTHENTICATED,          // Initial state, the user needs to authenticate
        UNAUTHENTICATED,        // The user has authenticated successfully
        INVALID_AUTHENTICATION  // Authentication failed
    }

    val authenticationState = MutableLiveData<AuthenticationState>()
    var username = ""

    init {
        // In this example, the user is always unauthenticated when MainActivity is launched
        authenticationState.value = AuthenticationState.UNAUTHENTICATED
        username = ""
    }

    fun refuseAuthentication() {
        authenticationState.value = AuthenticationState.UNAUTHENTICATED
    }

    fun authenticate(username: String = "", password: String = "") {
        if (passwordIsValidForUsername(username, password)) {
            this.username = username
            authenticationState.value = AuthenticationState.AUTHENTICATED
        } else {
            authenticationState.value = AuthenticationState.INVALID_AUTHENTICATION
        }
    }

    private fun passwordIsValidForUsername(username: String, password: String): Boolean {
        return true
    }
}