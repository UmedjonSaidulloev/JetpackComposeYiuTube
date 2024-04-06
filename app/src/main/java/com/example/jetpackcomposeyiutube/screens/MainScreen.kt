package com.example.jetpackcomposeyiutube.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.BadgeDefaults.containerColor
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.containerColor
import androidx.compose.material3.TabRowDefaults.contentColor
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.jetpackcomposeyiutube.R
import com.example.jetpackcomposeyiutube.ui.theme.BlueLight
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun MainCard() {
    Column(
        modifier = Modifier
            .padding(5.dp),
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(BlueLight),
            elevation = CardDefaults.cardElevation(0.dp),
            shape = CardDefaults.shape
//            colors = CardDefaults.cardColors(Color.Gray),
//            backgroundColor = BlueLight
//            elevation = 0.dp
//            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                        text = "05 Feb 2023 15:00",
                        style = TextStyle(fontSize = 15.sp),
                        color = White
                    )
                    AsyncImage(
                        model = "https://cdn.weatherapi.com/weather/64x64/day/116.png",
                        contentDescription = "im2",
                        modifier = Modifier
                            .padding(
                                top = 3.dp,
                                end = 8.dp
                            )
                            .size(35.dp)
                    )
                }
                Text(
                    text = "Khujand",
                    style = TextStyle(fontSize = 24.sp),
                    color = White
                )
                Text(
                    text = "18°C",
                    style = TextStyle(fontSize = 65.sp),
                    color = White
                )
                Text(
                    text = "Sunny",
                    style = TextStyle(fontSize = 16.sp),
                    color = White,
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = {

                        }) {
                        Icon(
                            painter = painterResource(id = R.drawable.is_search),
                            contentDescription = "im3",
                            tint = White
                        )
                    }
                    Text(
                        modifier = Modifier.padding(all = 6.dp),
                        text = "23°C/12°C",
                        style = TextStyle(fontSize = 16.sp),
                        color = White
                    )
                    IconButton(
                        onClick = {

                        }) {
                        Icon(
                            painter = painterResource(id = R.drawable.is_sync),
                            contentDescription = "im4",
                            tint = White
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout() {
    val tabList = listOf("HOURS", "DAYS")
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(
                start = 5.dp,
                end = 5.dp
            )
            .clip(RoundedCornerShape(5.dp))

    ) {
        TabRow(
//            selectedTabIndex = tabIndex,
//            indicator = { pos ->
//                TabRowDefaults.Indicator(
//                    Modifier.pagerTabIndicatorOffset(pagerState, pos),
//                )
//            },
            selectedTabIndex = tabIndex,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.offset(
                        x = tabPositions[tabIndex].left,
                        y = tabPositions[tabIndex].right
                    )
                )
            },
            //contentColor = TabRowDefaults.containerColor,
            containerColor = BlueLight,
            contentColor = White
        )
        {
            tabList.forEachIndexed { index, text ->
                Tab(
                    selected = false,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(text = text)
                    }
                )
            }
        }
        HorizontalPager(
            count = tabList.size,
            state = pagerState,
            modifier = Modifier.weight(1.0f)
        ) { index ->
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ){
                items(15){
                    ListItem()
                }
            }
        }
    }
}

