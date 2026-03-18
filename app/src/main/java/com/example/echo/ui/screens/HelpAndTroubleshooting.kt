package com.example.echo.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Battery5Bar
import androidx.compose.material.icons.filled.Bluetooth
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.CloudDownload
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.Hearing
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Subject
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.echo.ui.theme.EchoTheme

private val PageBackground = Color(0xFFF3F3F3)
private val CardBackground = Color.White
private val EchoTeal = Color(0xFF0AA3A3)
private val TextPrimary = Color(0xFF1F1F1F)
private val TextSecondary = Color(0xFF666666)
private val BorderColor = Color(0xFFD8D8D8)
private val SelectedColor = Color(0xFFE6F7F7)

data class HelpTopic(
    val title: String,
    val subtitle: String,
    val icon: ImageVector
)

data class DiagnosticTool(
    val label: String,
    val icon: ImageVector
)

data class FaqItem(
    val question: String,
    val answer: String
)

@Composable
fun HelpAndTroubleshooting(modifier: Modifier = Modifier) {
    var searchText by remember { mutableStateOf("") }
    var selectedMainButton by remember { mutableIntStateOf(-1) }
    var selectedDiagnosticButton by remember { mutableIntStateOf(-1) }

    val snackbarHostState = remember { SnackbarHostState() }

    val mainTopics = listOf(
        HelpTopic(
            title = "Sound\nIssues",
            subtitle = "Fix distortion or low volume.",
            icon = Icons.Default.GraphicEq
        ),
        HelpTopic(
            title = "Connection\nHelp",
            subtitle = "Troubleshoot Bluetooth problems.",
            icon = Icons.Default.Bluetooth
        ),
        HelpTopic(
            title = "Battery &\nCharging",
            subtitle = "Check status or address issues.",
            icon = Icons.Default.Battery5Bar
        ),
        HelpTopic(
            title = "Device\nSetup",
            subtitle = "Get help with pairing and setup.",
            icon = Icons.Default.Settings
        )
    )

    val diagnosticTools = listOf(
        DiagnosticTool("Check\nConnection", Icons.Default.CloudDownload),
        DiagnosticTool("Run Hearing\nAid Test", Icons.Default.Hearing),
        DiagnosticTool("Battery\nHealth", Icons.Default.Battery5Bar),
        DiagnosticTool("Send\nDiagnostics", Icons.Default.Subject)
    )

    val faqItems = listOf(
        FaqItem(
            "Bluetooth not connecting",
            "Make sure Bluetooth is enabled, your hearing aid is powered on, and the device is within range. You can also try disconnecting and pairing again."
        ),
        FaqItem(
            "App not detecting one ear",
            "Check whether both hearing aids are turned on and paired correctly. Try removing and reconnecting the affected device."
        ),
        FaqItem(
            "Hearing aid volume too low",
            "Confirm your volume settings in the app and check that the hearing aid is properly fitted and unobstructed."
        ),
        FaqItem(
            "Update failed",
            "Keep the device nearby, ensure the battery is sufficiently charged, and do not close the app while the update is in progress."
        )
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(PageBackground)
    ) {
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 8.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            contentPadding = PaddingValues(top = 24.dp, bottom = 110.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = TextPrimary
                        )
                    }

                    Text(
                        text = "Help & Troubleshooting",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                }
            }

            item {
                OutlinedTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(
                            text = "How can we help you?",
                            color = TextSecondary
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = TextSecondary
                        )
                    },
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = CardBackground,
                        unfocusedContainerColor = CardBackground,
                        focusedBorderColor = EchoTeal,
                        unfocusedBorderColor = BorderColor
                    )
                )
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    mainTopics.take(2).forEachIndexed { index, topic ->
                        HelpTopicCard(
                            topic = topic,
                            selected = selectedMainButton == index,
                            modifier = Modifier.weight(1f),
                            onClick = { selectedMainButton = index }
                        )
                    }
                }
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    mainTopics.drop(2).forEachIndexed { index, topic ->
                        val actualIndex = index + 2
                        HelpTopicCard(
                            topic = topic,
                            selected = selectedMainButton == actualIndex,
                            modifier = Modifier.weight(1f),
                            onClick = { selectedMainButton = actualIndex }
                        )
                    }
                }
            }

            item {
                Text(
                    text = "Diagnostic Tools",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    diagnosticTools.forEachIndexed { index, tool ->
                        DiagnosticToolCard(
                            tool = tool,
                            selected = selectedDiagnosticButton == index,
                            modifier = Modifier.weight(1f),
                            onClick = { selectedDiagnosticButton = index }
                        )
                    }
                }
            }

            item {
                Text(
                    text = "Frequently Asked Questions",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
            }

            items(faqItems.size) { index ->
                ExpandableFaqCard(faq = faqItems[index])
            }
        }

        FloatingActionButton(
            onClick = { },
            containerColor = EchoTeal,
            contentColor = Color.White,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 20.dp, bottom = 20.dp)
                .navigationBarsPadding()
        ) {
            Icon(
                imageVector = Icons.Default.Chat,
                contentDescription = "Chatbot"
            )
        }

        LaunchedEffect(selectedMainButton) {
            if (selectedMainButton != -1) {
                snackbarHostState.showSnackbar(
                    "Selected: ${mainTopics[selectedMainButton].title.replace("\n", " ")}"
                )
            }
        }

        LaunchedEffect(selectedDiagnosticButton) {
            if (selectedDiagnosticButton != -1) {
                snackbarHostState.showSnackbar(
                    "Selected: ${diagnosticTools[selectedDiagnosticButton].label.replace("\n", " ")}"
                )
            }
        }
    }
}

@Composable
private fun HelpTopicCard(
    topic: HelpTopic,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(140.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (selected) SelectedColor else CardBackground
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .background(EchoTeal, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = topic.icon,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Text(
                text = topic.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )

            Text(
                text = topic.subtitle,
                fontSize = 12.sp,
                color = TextSecondary
            )
        }
    }
}

@Composable
private fun DiagnosticToolCard(
    tool: DiagnosticTool,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(138.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (selected) SelectedColor else CardBackground
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 18.dp, horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Icon(
                imageVector = tool.icon,
                contentDescription = null,
                tint = EchoTeal,
                modifier = Modifier.size(32.dp)
            )

            Text(
                text = tool.label,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary
            )
        }
    }
}

@Composable
private fun ExpandableFaqCard(faq: FaqItem) {
    var expanded by remember { mutableStateOf(faq.question == "Bluetooth not connecting") }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = faq.question,
                    modifier = Modifier.weight(1f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )

                Icon(
                    imageVector = if (expanded) {
                        Icons.Default.KeyboardArrowUp
                    } else {
                        Icons.Default.KeyboardArrowDown
                    },
                    contentDescription = "Expand FAQ",
                    tint = TextPrimary
                )
            }

            AnimatedVisibility(visible = expanded) {
                Column {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = faq.answer,
                        fontSize = 15.sp,
                        color = TextPrimary,
                        lineHeight = 22.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HelpAndTroubleshootingPreview() {
    EchoTheme {
        HelpAndTroubleshooting()
    }
}