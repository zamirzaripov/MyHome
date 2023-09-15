package com.example.myhome.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myhome.R

class MainActivity : ComponentActivity() {

    //private lateinit var viewModel: CameraViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var selectedTabIndex by remember { mutableIntStateOf(0) }
            val tabs = listOf(stringResource(id = R.string.cameras), stringResource(id = R.string.doors))

            //viewModel = ViewModelProvider(this)[CameraViewModel::class.java]

            Scaffold(
                topBar = {
                    TopAppBar(
                        backgroundColor = Color.Transparent,
                        elevation = 0.dp
                    ) {
                        Box {
                            Text(
                                text = stringResource(id = R.string.my_home),
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                },
                modifier = Modifier.fillMaxSize()
            ) { paddingValue ->
                Box(modifier = Modifier.padding(paddingValue)) {

                }
                Column(modifier = Modifier.fillMaxSize()) {
                    TabRow(
                        selectedTabIndex = selectedTabIndex,
                        indicator = { tabPositions ->
                            TabRowDefaults.Indicator(
                                Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                                color = Color.Blue
                            )
                        },
                        backgroundColor = Color.Transparent,
                        contentColor = Color.Black,
                        divider = {}
                    ) {
                        tabs.forEachIndexed { index, text ->
                            Tab(
                                selected = selectedTabIndex == index,
                                onClick = { selectedTabIndex = index },
                                text = {
                                    Text(
                                        text = text,
                                        modifier = Modifier.padding(8.dp),
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 14.sp,
                                        color = Color.Black
                                    )
                                },
                                interactionSource = MutableInteractionSource()
                            )
                        }
                    }

                    when (selectedTabIndex) {
                        0 -> {
                            CameraScreen()
                        }

                        1 -> {
                            DoorScreen()
                        }
                    }
                }
            }
        }
    }
}