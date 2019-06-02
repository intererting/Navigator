package com.yuliyang.navigator

import androidx.navigation.ActivityNavigator

val homeNavigator by lazy {
    ActivityNavigator(MyApplication.provideInstance())
}
