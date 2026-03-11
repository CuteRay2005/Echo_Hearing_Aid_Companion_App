package com.example.echo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun AudioProfilesScreen() {
    val profiles = listOf("TELEVISION", "WORK", "CAFE", "CONVERSATION")
    var selectedProfile by remember { mutableStateOf("CONVERSATION") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        // Title
        Text(
            text = "Profiles",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Profile selector row
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            profiles.forEach { profile ->
                ProfileChip(
                    label = profile,
                    selected = profile == selectedProfile,
                    onClick = { selectedProfile = profile }
                )
            }
        }

        Spacer(Modifier.height(32.dp))

        // Frequency Section
        Text(
            text = "Frequency",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(Modifier.height(16.dp))

        FrequencyBars()

        Spacer(Modifier.height(32.dp))

        // Sliders
        LabeledSlider("Background Noise Reduction")
        Spacer(Modifier.height(24.dp))
        LabeledSlider("Speech Focus")

        Spacer(Modifier.weight(1f))

        // Bottom button
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        ) {
            Text("LEARN MORE")
        }
    }
}

@Composable
fun ProfileChip(label: String, selected: Boolean, onClick: () -> Unit) {
    val bg = if (selected) Color(0xFF00A8A8) else Color(0xFFE0E0E0)
    val textColor = if (selected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(bg)
            .clickable { onClick() }
            .padding(horizontal = 14.dp, vertical = 8.dp)
    ) {
        Text(text = label, color = textColor, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun FrequencyBars() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        FrequencyBar("Low", 0.6f)
        FrequencyBar("Mid", 0.8f)
        FrequencyBar("High", 0.4f)
    }
}

@Composable
fun FrequencyBar(label: String, fillFraction: Float) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .width(40.dp)
                .height(140.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFE0E0E0))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(fillFraction)
                    .align(Alignment.BottomCenter)
                    .background(Color(0xFF00A8A8))
            )
        }
        Spacer(Modifier.height(8.dp))
        Text(label)
    }
}

@Composable
fun LabeledSlider(label: String) {
    Column {
        Text(label, style = MaterialTheme.typography.titleMedium)
        Slider(
            value = 0.5f,
            onValueChange = {},
            colors = SliderDefaults.colors(
                thumbColor = Color(0xFF00A8A8),
                activeTrackColor = Color(0xFF00A8A8),
                inactiveTrackColor = Color(0xFFB2EBEB)
            )
        )
    }
}