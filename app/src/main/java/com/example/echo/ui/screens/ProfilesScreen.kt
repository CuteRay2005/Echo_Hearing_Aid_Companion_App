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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow

//@Preview
@Composable
fun AudioProfilesScreen(modifier: Modifier) {
    val profiles = listOf("TELEVISION", "WORK", "CAFE", "CONVERSATION")
    var selectedProfile by remember { mutableStateOf("CONVERSATION") }

    Box(
        modifier = Modifier.background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            // Title
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* TODO */ }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
                Text(
                    text = "Profiles",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            // Profile selector row
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = Color(0XFFDDDDDD))
                    .padding(horizontal = 10.dp)
            ) {
                FlowRow(
                    mainAxisSpacing = 12.dp,
                    crossAxisSpacing = 6.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    profiles.forEach { profile ->
                        ProfileChip(
                            label = profile,
                            selected = profile == selectedProfile,
                            onClick = { selectedProfile = profile },
                            modifier = Modifier.padding(4.dp),
                        )
                    }
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(
                            imageVector = Icons.Outlined.Add,
                            contentDescription = "new"
                        )
                    }
                }
            }


            Spacer(Modifier.height(32.dp))

            // Frequency Section
            Text(
                text = "Frequency",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(Modifier.height(32.dp))

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
                Text(
                    "LEARN MORE"
                )
            }
        }
    }
}

@Composable
fun ProfileChip(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val bg = if (selected) Color(0xFF00A8A8) else Color.White
    val textColor = if (selected) Color.White else Color.Black

    Box(
        modifier = modifier
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
        Text(label, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun LabeledSlider(label: String) {
    Column {
        Slider(
            value = 0.5f,
            onValueChange = {},
            colors = SliderDefaults.colors(
                thumbColor = Color(0xFF00A8A8),
                activeTrackColor = Color(0xFF00A8A8),
                inactiveTrackColor = Color(0xFFB2EBEB)
            )
        )
        Text(label, style = MaterialTheme.typography.titleMedium)
    }
}