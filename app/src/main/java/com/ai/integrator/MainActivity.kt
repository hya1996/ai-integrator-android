package com.ai.integrator

import android.os.Bundle
import androidx.activity.compose.setContent
import com.ai.integrator.core.framework.activity.BaseActivity
import com.ai.integrator.core.ui.theme.AITheme

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AITheme {
                AIApp()
            }
        }
    }
}