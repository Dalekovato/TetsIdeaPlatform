package com.example.tetsideaplatform.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun MainScreen() {


    ListItem()

}

@Composable
fun ListItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(7.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(7.dp),
        ) {

            Column {

                Row(horizontalArrangement = Arrangement.Start) {
                    Text(text = "iPhone 13")
                }

                Row(horizontalArrangement = Arrangement.Start) {
                    //Здесь реализовать Chips
                }

                Row(horizontalArrangement = Arrangement.Start) {

                    Column(horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .weight(1f)) {
                        Text(text = "На складе")
                        Text(text = "12")
                    }

                    Column(horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .weight(1f)) {
                        Text(text = "Дата добавления")
                        Text(text = "ДД.ММ.ГГГГ")
                    }

                }

            }

        }
    }
}


