package com.example.radar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.radar.ui.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            // state ديناميكي
            var points by remember { mutableStateOf(listOf<RadarPoint>()) }

            // simulation (باش نشوفو UI يخدم)
            LaunchedEffect(Unit) {
                while (true) {
                    points = listOf(
                        RadarPoint(0.3f, 1.0f, 0.9f, "CRITICAL"),
                        RadarPoint(0.6f, 2.0f, 0.6f, "DANGER"),
                        RadarPoint(0.8f, 3.0f, 0.3f, "SAFE")
                    )
                    kotlinx.coroutines.delay(1000)
                }
            }

            RadarUltimate(points)
        }
    }
}
